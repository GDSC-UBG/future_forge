const {Feeds, ImageFeed, FeedReactions} = require('../models')


const getAllFeed = async (req, res) => {
  try {
    let page = Number.parseInt(req.query.page) || 1
    let perPage = Number.parseInt(req.query.perPage) || 10

    const {count, rows} = await Feeds.findAndCountAll({
      include: {all: true},
      limit: perPage,
      offset: (page - 1) * perPage
    })
  
    const totalPage = Math.ceil(count / perPage)
  
    if (rows) {
      return res.status(200).json({
        page,
        results: rows,
        totalPage: totalPage,
        totalResult: count
      })
    }
  
    return res.status(404).json({
      msg: `Feeds is empty!`
    })
  } catch (error) {
    return res.status(500).json({ msg: error.message })
  }
}

const getDetailFeed = async (req, res) => {
  try {
    const id = req.params.id

    const data = await Feeds.findOne({
      include: { all: true},
      where: {
        id_feed: id
      }
    })

    if (data) {
      return res.status(201).json({
        msg: 'success retrive feed',
        data
      })
    }

    return res.status(404).json({
      msg: `not found feed with id ${id}`
    })

  } catch (error) {
    return res.status(500).json({msg: error.message})
  }
}

const createFeed = async (req, res) => {
  try {

    const text = req.body.text
    const id_user = req.userId
    const ImagePath = req.file ? req.file.filename : null

    const feed = await Feeds.create({id_user, text})

    if(ImagePath) {
      await ImageFeed.create({
        id_feed: feed.id_feed,
        image: ImagePath
      })
    }

    await FeedReactions.create({
      id_feed: feed.id_feed,
      id_user: id_user,
      type: 0
    })

    res.status(201).json(feed)

  } catch (error) {
    res.status(500).json({msg: error.message})
  }
}

const deleteFeed = async (req, res) => {
  try {

    const {id} = req.params

    const data = await Feeds.destroy({
      where: {id_feed: id}
    })

    if (data) {
      return res.status(200).json({ msg: 'succes deleted feed'})
    }

    return res.status(404).json({
      msg: `not found feed with id ${id}`
    })
  } catch (error) {
    res.status(500).json({msg: error.message})
  }
}

module.exports = {
  createFeed,
  getAllFeed,
  getDetailFeed,
  deleteFeed
}

