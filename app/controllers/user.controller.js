const { Users, DailyNotes } = require("../models");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const { where } = require("sequelize");

const getAllUser = async (req, res) => {
  try {
    const data = await Users.findAll({});
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

const completedProfileUser = async (req, res) => {
  try {
    const id = req.userId;
    await Users.update(req.body, {
      where: {
        id_user: id,
      },
    });
    return res.status(200).json({
      msg: "succes create detail user",
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
    const data = await Users.findOne({
      where: { id_user: id },
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
      where: {
        id_user: id,
      },
    });
    return res.status(200).json({
      msg: "Success update user.",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const deleteUser = async (req, res) => {
  try {
    const { id } = req.params;
    const data = await Users.destroy({
      where: {
        id_user: id,
      },
    });

    if (data) {
      return res.status(200).json({
        msg: "succes deleted user",
      });
    }

    return res.status(404).json({
      msg: "user not found!",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

module.exports = {
  getAllUser,
  getDetailUser,
  updateUser,
  deleteUser,
  completedProfileUser,
};
