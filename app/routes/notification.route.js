const { saveTokenFCM } = require("../services/notification.service");
const { verifyToken } = require("../middlewares/auth.jwt");

require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  router.post("/save/token", [verifyToken], saveTokenFCM);
  app.use(default_router, router);
};
