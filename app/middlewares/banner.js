const checkQuery = (req, res, next) => {

  const { page, perPage } = req.query

  if ( page == "" || perPage == "" ) {
    return res.status(400).json({
      msg: `query page or perPage must be not empty!`
    })
  }

  return next()
}
module.exports = {checkQuery}
