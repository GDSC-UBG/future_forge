const {getHome} = require("../controllers/home.controller");
const { verifyToken } = require("../middlewares/auth.jwt");




require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  
  router.get('/home', [verifyToken], getHome)
  // router.get('/feed/:id', [verifyToken], feedController.getDetailFeed)
  // router.post('/feed', [verifyToken, uploadFeed.single('image')], feedController.createFeed)
  // router.delete('/feed/:id', [verifyToken], feedController.deleteFeed)
  // router.post('/feed/reaction', [verifyToken], feedController.reaction)

  app.use(default_router, router);
};
