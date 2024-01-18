const { 
  create,
  getAllCalender,
  getDetailCalender,
  updateCalender,
  deleteCalender
 } = require("../controllers/calender.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkField } = require("../middlewares/schadule");
require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  // auth
  // console.log(default_router);
  router.post("/calender", [verifyToken, checkField], create);
  router.get("/calender/:id_schadule", [verifyToken], getAllCalender)
  router.get("/calende/:id_schadule", [verifyToken], getDetailCalender)
  router.put("/calender/:id_schadule", [verifyToken], updateCalender)
  router.delete("/calender/:id_schadule", [verifyToken], deleteCalender)

  app.use(default_router, router);
};
