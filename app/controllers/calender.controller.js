const { Schadule } = require("../models");

const create = (req, res) => {
  const id_user = req.userId;
  const data = {
    ...req.body,
    id_user,
  };
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

module.exports = {
  create,
};
