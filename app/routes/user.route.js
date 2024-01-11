const UserController = require("../controllers/user.controller");
// const { verifyToken } = require("../middlewares/auth.jwt");
require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  //   router.get("/users", [verifyToken], UserController.getAllUser);
  //   router.get("/users/:id", [verifyToken], UserController.getDetailUser);
  //   router.put("/users/:id", [verifyToken], UserController.updateUser);

  app.use(default_router, router);
};
