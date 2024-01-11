"use strict";
const { Model } = require("sequelize");
module.exports = (sequelize, DataTypes) => {
  class Notifications extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  Notifications.init(
    {
      id_notification: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      id_user: DataTypes.INTEGER,
      title: DataTypes.STRING,
      text: DataTypes.TEXT,
      emotional_score: DataTypes.STRING,
    },
    {
      sequelize,
      modelName: "Notifications",
    }
  );
  return Notifications;
};
