const { Op } = require("sequelize");
const { Schadule, Users } = require("../models");
const { sendNotification } = require("./notification.service");

const scheduleDailyNotifications = async () => {
  try {
    // Ambil semua data dari model Schadule
    const today = new Date();
    const startOfDay = new Date(
      today.getFullYear(),
      today.getMonth(),
      today.getDate()
    );

    // Ambil semua jadwal yang memiliki tanggal hari ini
    const schedules = await Schadule.findAll({
      where: {
        date: {
          [Op.gte]: startOfDay,
        },
        type: "daily",
      },
      include: [
        {
          model: Users,
          attributes: ["fcm_token"],
        },
      ],
    });

    // Loop melalui setiap jadwal
    schedules.forEach((schedule) => {
      const { id_user, text, User, date } = schedule;

      if (isToday(date)) {
        // Kirim notifikasi
        sendNotification(id_user, "Daily Note Remainder", text, User.fcm_token);
      } else {
        console.log("belum waktunya");
      }
    });
  } catch (error) {
    console.error("Error scheduling notifications:", error);
  }
};

const createSchadule = async (id_user, title, text, type, date) => {
  try {
    let result = await Schadule.create({
      id_user,
      title,
      text,
      type,
      date,
    });
    if (!result) {
      return false;
    }
    return true;
  } catch (error) {
    console.log(error);
    return false;
  }
};

const isToday = (date) => {
  const today = new Date();

  return (
    date.getDate() === today.getDate() &&
    date.getMonth() === today.getMonth() &&
    date.getFullYear() === today.getFullYear() &&
    date.getHours() <= today.getHours() &&
    date.getMinutes() <= today.getMinutes() &&
    date.getSeconds() <= today.getSeconds()
  );
};

module.exports = { scheduleDailyNotifications, createSchadule };
