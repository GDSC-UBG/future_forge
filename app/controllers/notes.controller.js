const {DailyNotes, User} = require('../models')

const getNote = async (req, res) => {
  try {
    const {id} = req.params
    const data = await DailyNotes.findByFk({
      where: {
        id_daily: id
      }
    })
    if(data) {
      return res.status(201).json({
        msg: 'succes retrive note',
        data
      })
    }

    return res.status(404).json({
      msg: 'not found note'
    })
  } catch (error) {
    return res.status(500).json({
      msg: error.message
    })
  }
}

const getAllNotes = async (req, res) => {
  try {
    const data = await DailyNotes.findAll({
    })
    if(data) {
      return res.status(201).json({
        msg: "succes retrive all notes",
        data
      })
    }
    return res.status(404).json({
      msg: 'note is empty'
    })
  } catch (error) {
    return res.status(500).json({
      msg: error.message
    })
  }
}

const addNotes = async (req, res) => {
  try {
    const id_user = req.userId
    const query = {
      ...req.body,
      id_user
    }
    const data = await DailyNotes.create(query)
    return res.status(201).json({
      msg: "succes create daily note",
      data
    })
  } catch (error) {
      return res.status(500).json({
        msg: error.message
      })
  }
}

const deleteNotes = async (req, res) => {
  try {
    const {id} = req.params
    const data =  await DailyNotes.destroy({where: {
      id_daily: id
    }})
    if(data) {
      return res.status(200).json({
        msg: "succes deleted note"
      })
    }
    return res.status(404).json({
      msg: "note not found!"
    })
  } catch (error) {
    return res.status(500).json({
      msg: error.message
    })
  }
}

const updateNotes = async (req, res) => {
  try {
    const {id} = req.params
    const data = await DailyNotes.update(req.body, {where: {
      id_daily: id
    }})

    if(data) {
      return res.status(200).json({
        msg: "succes updated note"
      })
    }

    return res.status(404).json({
      msg: "note not found!"
    })
  } catch (error) {
    return res.status(500).json({
      msg: error.message
    })
  }
}

module.exports = {
  addNotes,
  deleteNotes,
  updateNotes,
  getAllNotes,
  getNote
}
