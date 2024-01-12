const checkField = (req, res, next) => {
  let { google_id, job, child_count, birthdate, picture } = req.body;
  if (google_id == "" || job == "" || child_count == "" || birthdate == "" || picture == "") {
    return res.status(400).json({ message: "All fields must be filled" });
  }

  return next();
};

module.exports = {
  checkField,
};
