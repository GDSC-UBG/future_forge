'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Feeds extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      Feeds.hasMany(models.ImageFeed, {foreignKey: "id_feed"})
      Feeds.hasMany(models.FeedReactions, {foreignKey: "id_feed"})
    }
  }
  Feeds.init({
     id_feed: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    id_user: DataTypes.INTEGER,
    text: DataTypes.TEXT
  }, {
    sequelize,
    modelName: 'Feeds',
  });
  return Feeds;
};