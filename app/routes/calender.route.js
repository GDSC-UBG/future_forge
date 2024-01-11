const { create } = require("../controllers/calender.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkField } = require("../middlewares/schadule");
require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  // auth
  // console.log(default_router);
  router.post("/calender", [verifyToken, checkField], create);

  app.use(default_router, router);
};
