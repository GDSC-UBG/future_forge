const checkField = (req, res, next) => {
  let { title, text, type, date } = req.body;
  if (title == "" || text == "" || type == "" || date == "") {
    return res.status(400).json({ message: "All fields must be filled" });
  }

  return next();
};

module.exports = {
  checkField,
};
