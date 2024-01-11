const { login, register } = require("../controllers/auth.controller");
const { hasCreated } = require("../helpers/auth");
require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  // auth
  // console.log(default_router);
  router.post("/register", [hasCreated], register);
  router.post("/login", login);

  app.use(default_router, router);
};
