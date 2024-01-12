"use strict";
const { Model } = require("sequelize");
module.exports = (sequelize, DataTypes) => {
  class Users extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      Users.hasMany(models.Schadule, { foreignKey: "id_user" });
    }
  }
  Users.init(
    {
      id_user: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      name: DataTypes.STRING,
      email: DataTypes.STRING,
      password: DataTypes.STRING,
      google_id: DataTypes.STRING,
      fcm_token: DataTypes.STRING,
      role: DataTypes.ENUM("admin", "client", "doctor"),
      picture: DataTypes.STRING,
      birthdate: DataTypes.STRING,
      child_count: DataTypes.STRING,
      job: DataTypes.STRING,
    },
    {
      sequelize,
      modelName: "Users",
    }
  );
  return Users;
};
