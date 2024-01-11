const jwt = require("jsonwebtoken");
require("dotenv").config();
const key = process.env.JWT_KEY;

const verifyToken = (req, res, next) => {
  let token = req.headers["x-api-key"];

  if (!token) {
    return res.status(403).send({
      msg: `No token provided!`,
    });
  }

  jwt.verify(token, key, (err, decoded) => {
    if (err) {
      return res.status(401).send({
        msg: `Unauthorized!`,
      });
    }
    req.userId = decoded.id;
    next();
  });
};

const hasCreated = async (req, res, next) => {
  try {
    const { email } = req.body; // Anda dapat menyesuaikan ini dengan bagaimana email dikirim dalam permintaan Anda

    // Cek apakah pengguna sudah masuk dengan email tertentu
    const existingUser = await User.findOne({ where: { email } });

    if (existingUser) {
      // Pengguna sudah masuk, Anda dapat menanggapi sesuai kebutuhan, misalnya:
      return res
        .status(401)
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
  verifyToken,
  hasCreated,
};
