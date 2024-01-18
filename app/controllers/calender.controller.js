const { Schadule } = require("../models");

const create = (req, res) => {
  const id_user = req.userId;
  const data = {
    ...req.body,
    id_user,
  };
  console.log(req.body);
  Schadule.create(data)
    .then(() => {
      res
        .status(201)
        .json({ success: true, message: "Schedule created successfully." });
    })
    .catch((error) => {
      console.error("Error creating schedule:", error);
      res
        .status(500)
        .json({ success: false, message: "Internal Server Error." });
    });
};

const getAllCalender = async (req, res) => {
  try {
    const data = await Schadule.findAll();

    if(data) {
      return res.status(200).json({
        msg: 'success retrive all Calender',
        results: data
      })
    }

    return res.status(400).json({
      msg: 'calender is empty!'
    })

  } catch (error) {
    return res.status(500).json({error: error.message})
  }
}

const getDetailCalender = async (req, res) => {
  try {
    const id_schadule = req.params.id_schadule

    const data = await Schadule.findOne({
      where: {
        id_schadule
      }
    })

    if( data ) {
      return res.status(200).json({
        msg: 'succes get Calender',
        result: data
      })
    }

    return res.status(404).json({
      msg: `Calender is not Found with id: ${id_schadule}`
    })

  } catch (error) {
    return res.status(500).json({
      error: error.message
    })
  }
}

const updateCalender = async (req, res) => {
  try {
    const {id_schadule} = req.params
    await Schadule.update(req.body, {
      where: {
        id_schadule
      }
    })
    return res.status(200).json({
      msg: 'success updated Calender'
    })
  } catch (error) {
    return res.status(500).json({
      error: error.message
    })
  }
}

const deleteCalender = async (req, res) => {
  try {
    const {id_schadule} = req.params
    await Schadule.destroy({
      where: {
        id_schadule
      }
    })

    return res.status(200).json({
      msg: 'success deleted calender'
    })
  } catch (error) {
    return res.status(500).json({
      error: error.message
    })
  }
}

module.exports = {
  create,
  getAllCalender,
  getDetailCalender,
  updateCalender,
  deleteCalender
};
