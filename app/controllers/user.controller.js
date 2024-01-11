const { User, Task } = require("../models");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

const getAllUser = async (req, res) => {
  try {
    const data = await User.findAll({
      include: [
        {
          model: Task,
        },
      ],
    });
    return res.status(200).json({
      msg: "Success retrieve data users",
      data,
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const getDetailUser = async (req, res) => {
  try {
    const { id } = req.params;
    const data = await User.findOne({
      where: { id },
      include: [
        {
          model: Task,
        },
      ],
    });
    return res.status(200).json({
      msg: "Success retrieve detail user",
      data,
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const updateUser = async (req, res) => {
  try {
    const { id } = req.params;
    await User.update(req.body, {
      where: { id },
    });
    return res.status(200).json({
      msg: "Success update detail user.",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

module.exports = {
  signUp,
  signIn,
  getAllUser,
  getDetailUser,
  updateUser,
};
