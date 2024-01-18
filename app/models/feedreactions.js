'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class FeedReactions extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      FeedReactions.belongsTo(models.Feeds, {foreignKey: "id_feed"})
    }
  }
  FeedReactions.init({
    id_reaction: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    id_feed: DataTypes.INTEGER,
    id_user: DataTypes.INTEGER,
    type: DataTypes.BOOLEAN
  }, {
    sequelize,
    modelName: 'FeedReactions',
  });
  return FeedReactions;
};