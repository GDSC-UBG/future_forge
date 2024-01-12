const { default: Sequelize } = require("@sequelize/core");
const { Notifications, Users } = require("../models");
const { admin } = require("./fcm.service");

const sendNotification = async (id_user, title, text, fcm_token) => {
  // check di db apakah notif sudah dibuat, jika belum maka buat
  console.log(`Notification to User ${id_user}: ${title} - ${text}`);
  let notificationToday = await checkIfNotificationCreatedToday(id_user);
  if (!notificationToday) {
    // create notif
    let createNotif = await Notifications.create({
      id_user,
      title,
      text,
    });

    if (createNotif) {
      // setelah dibuat maka kikrim notif ke FCM
      let sendNotif = await sendNotificationToFCM(fcm_token, title, text);
      if (sendNotif) {
        // didalam callback update notif status mennjadi sending
        createNotif.update({ status: "sending" });
      }
    }
  }
};

const checkIfNotificationCreatedToday = async (id_user) => {
  const today = new Date();
  const startOfDay = new Date(
    today.getFullYear(),
    today.getMonth(),
    today.getDate()
  );

  try {
    const notification = await Notifications.findOne({
      where: {
        id_user,
        title: "Daily Note Remainder",
        createdAt: {
          [Sequelize.Op.gte]: startOfDay,
        },
      },
    });

    return notification.length > 0; // Mengembalikan true jika ada notifikasi yang dibuat hari ini
  } catch (error) {
    console.error("Error checking notifications:", error);
    return false;
  }
};

const saveTokenFCM = async (req, res) => {
  const userId = req.userId;
  const { token } = req.body;
  try {
    // Cek apakah pengguna dengan ID yang diberikan ada dalam database
    const user = await Users.findByPk(userId);

    if (!user) {
      return res.status(404).json({ error: "User not found" });
    }

    // Update kolom fcm_token untuk pengguna dengan ID yang diberikan
    await Users.update(
      { fcm_token: token },
      {
        where: {
          id_user: userId,
        },
      }
    );

    return res.status(200).json({ message: "FCM token saved successfully" });
  } catch (error) {
    console.error("Error saving FCM token:", error);
    return res.status(500).json({ error: "Internal Server Error" });
  }
};

const sendNotificationToFCM = async (fcmTokens, title, text) => {
  // Implementasikan pengiriman notifikasi ke FCM menggunakan library atau layanan yang sesuai
  console.log(fcmTokens);
  try {
    const message = {
      data: {
        title,
        text,
      },
      token: fcmTokens,
    };

    await admin.messaging().send(message);

    // Handle response atau update status notifikasi menjadi "sending" di sini jika diperlukan
    console.log("Successfully sent notification");

    return true;
  } catch (error) {
    console.log(error);
    return false;
  }
};

module.exports = {
  sendNotification,
  saveTokenFCM,
};
