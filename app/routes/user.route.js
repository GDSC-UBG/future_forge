const UserController = require("../controllers/user.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkField } = require("../middlewares/user");
const {uploadUser} = require('../middlewares/multer')


require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  router.get("/users", [verifyToken], UserController.getAllUser);
  router.get("/users/:id", [verifyToken], UserController.getDetailUser);
  router.put(
    "/users/profile",
    [verifyToken, uploadUser.single('picture')],
    UserController.completedProfileUser
  );
  router.delete("/users/:id", [verifyToken], UserController.deleteUser);

  app.use(default_router, router);
};
