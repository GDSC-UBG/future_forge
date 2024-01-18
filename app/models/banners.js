'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Banners extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      Banners.hasMany(models.ImageBanners, { foreignKey: "id_banner" });
    }
  }
  Banners.init({
    id_banner: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    id_user: DataTypes.INTEGER,
    title: DataTypes.TEXT,
    text: DataTypes.TEXT
  }, {
    sequelize,
    modelName: 'Banners',
  });
  return Banners;
};