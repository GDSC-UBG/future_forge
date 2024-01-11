const { DailyNotes } = require("../models");
const { Op } = require("@sequelize/core");

const haveNotes = (req, res, next) => {
  DailyNotes.findOne({
    where: {
      [Op.and]: [{ id_user: req.userId }, { id_daily: req.params.id }],
    },
  }).then((result) => {
    // console.log(result);
    if (result) {
      next();
      return;
    }
    return res.status(401).send({
      msg: `Unauthorized!`,
    });
  });
};

module.exports = {
  haveNotes,
};
