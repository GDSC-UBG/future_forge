const checkField = (req, res, next) => {
  let { text, emotional_score } = req.body;
  if (text == "" || emotional_score == "") {
    return res.status(400).json({ message: "All fields must be filled" });
  }

  if(emotional_score < 1 ||  emotional_score > 5) {
    return res.status(400).json({message: "emotional score must be 1 between 5"})
  }

  return next();
};

module.exports = {
  checkField,
};
