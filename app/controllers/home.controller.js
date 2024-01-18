const { FeedReactions, ImageFeed, Feeds, ImageBanners, Banners } = require('../models')

const getHome = async (req, res) => {
  try {
    const banner = await Banners.findAll({
      include: [{
        model: ImageBanners, attributes: ["image"]
      }],
      limit: 3
    })

    const feed = await Feeds.findAll({
      include: {all: true},
      limit: 3
    })

    return res.status(200).json({
      banner,
      feed
    })
  } catch (error) {
    return res.status(500).json({
      error: error.message
    })
  }
}

module.exports = {
  getHome
}
