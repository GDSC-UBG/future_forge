const { Users } = require("../models");

const hasCreated = async (req, res, next) => {
  try {
    const { email } = req.body; // Anda dapat menyesuaikan ini dengan bagaimana email dikirim dalam permintaan Anda

    // Cek apakah pengguna sudah masuk dengan email tertentu
    const existingUser = await Users.findOne({ where: { email } });

    if (existingUser) {
      // Pengguna sudah masuk, Anda dapat menanggapi sesuai kebutuhan, misalnya:
      return res
        .status(400)
        .json({ message: "User with this email is already register." });
    }

    // Jika pengguna belum masuk, lanjutkan ke middleware atau rute berikutnya
    next();
  } catch (error) {
    console.error("Error checking user sign-in status:", error);
    return res.status(500).json({ message: "Internal Server Error" });
  }
};

module.exports = {
  hasCreated,
};
