'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Schadule extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  Schadule.init({
    id_schadule: DataTypes.INTEGER,
    id_user: DataTypes.INTEGER,
    title: DataTypes.STRING,
    text: DataTypes.TEXT,
    type: DataTypes.ENUM,
    start_date: DataTypes.DATE,
    end_date: DataTypes.DATE,
  }, {
    sequelize,
    modelName: 'Schadule',
  });
  return Schadule;
};