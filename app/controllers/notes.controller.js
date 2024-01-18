const { DailyNotes, User } = require("../models");

const getDetailNote = async (req, res) => {
  try {
    const { id } = req.params;
    const data = await DailyNotes.findOne({
      where: {
        id_daily: id,
      },
    });
    if (data) {
      return res.status(201).json({
        msg: "succes retrive note",
        data,
      });
    }

    return res.status(404).json({
      msg: "not found note",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const getAllNotes = async (req, res) => {
  try {
    let perPage = Number.parseInt(req.query.perPage)|| 10
    let page = Number.parseInt(req.query.page) || 1
    const {count, rows} = await DailyNotes.findAndCountAll({ 
      limit: perPage,
      offset: (page - 1) * perPage
    });
   
    const totalPage = Math.ceil(count / perPage)
    if (rows) {
      return res.status(201).json({
        msg: "succes retrive all notes",
        page: page,
        results: rows,
        totalPage: totalPage,
        totalResult: count
      });
    }
    return res.status(404).json({
      msg: "note is empty",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const addNotes = async (req, res) => {
  try {
    const id_user = req.userId;
    const query = {
      ...req.body,
      id_user,
    };

    const data = await DailyNotes.create(query);

    return res.status(201).json({
      msg: "succes create daily note",
      data,
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const deleteNotes = async (req, res) => {
  try {
    const { id } = req.params;
    const data = await DailyNotes.destroy({
      where: {
        id_daily: id,
      },
    });
    if (data) {
      return res.status(200).json({
        msg: "succes deleted note",
      });
    }
    return res.status(404).json({
      msg: "note not found!",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

const updateNotes = async (req, res) => {
  try {
    const { id } = req.params;
    const data = await DailyNotes.update(req.body, {
      where: {
        id_daily: id,
      },
    });

    if (data) {
      return res.status(200).json({
        msg: "succes updated note",
      });
    }

    return res.status(404).json({
      msg: "note not found!",
    });
  } catch (error) {
    return res.status(500).json({
      msg: error.message,
    });
  }
};

module.exports = {
  addNotes,
  deleteNotes,
  updateNotes,
  getAllNotes,
  getDetailNote,
};
