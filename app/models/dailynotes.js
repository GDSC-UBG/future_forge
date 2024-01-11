"use strict";
const { Model } = require("sequelize");
module.exports = (sequelize, DataTypes) => {
  class DailyNotes extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  DailyNotes.init(
    {
      id_daily: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      id_user: DataTypes.INTEGER,
      text: DataTypes.TEXT,
      emotional_score: DataTypes.STRING,
    },
    {
      sequelize,
      modelName: "DailyNotes",
    }
  );
  return DailyNotes;
};
