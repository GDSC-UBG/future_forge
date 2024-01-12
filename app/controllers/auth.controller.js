const { Users } = require("../models");
const { createTokenFCM } = require("../services/fcm.service");
const { createSchadule } = require("../services/schaduler.service");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

const register = async (req, res) => {
  try {
    req.body.password = bcrypt.hashSync(req.body.password, 8);
    await Users.create(req.body).then(async (user) => {
      // create daily schadule
      await createSchadule(
        user.id_user,
        "Daily Note Remainder",
        "Time to jot down your thoughts and reflections for the day!",
        "daily",
        "2024-01-12 17:00:00"
      );

      return res.status(201).json({
        msg: "Successfully register",
        data: {
          id: user.id,
          name: user.name,
        },
      });
    });
  } catch (error) {
    console.log(error);
    return res.status(500).json({
      msg: "Internal server error",
    });
  }
};

const login = async (req, res) => {
  try {
    await Users.findOne({
      where: { email: req.body.email },
    }).then((user) => {
      if (user) {
        let checkPassword = bcrypt.compareSync(
          req.body.password,
          user.password
        );

        if (!checkPassword) {
          return res.status(401).json({
            msg: "Invalid password",
          });
        }

        // create token jwt

        let key = jwt.sign({ id: user.id_user }, process.env.JWT_KEY, {
          expiresIn: 86400 * 2, // 2 days
        });

        return res.status(200).json({
          msg: "Successfully login",
          key,
        });
      }
      return res.status(404).json({
        msg: "User not found",
      });
    });
  } catch (error) {
    console.log(error);
    return res.status(500).json({
      msg: "Internal server error",
    });
  }
};

module.exports = { register, login };
