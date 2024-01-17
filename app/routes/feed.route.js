const feedController = require("../controllers/feed.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkQuery } = require('../middlewares/banner')
const {uploadFeed} = require('../middlewares/multer')



require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  
  router.get('/feed', [verifyToken], feedController.getAllFeed)
  router.get('/feed/:id', [verifyToken], feedController.getDetailFeed)
  router.post('/feed', [verifyToken, uploadFeed.single('image')], feedController.createFeed)
  router.delete('/feed/:id', [verifyToken], feedController.deleteFeed)

  app.use(default_router, router);
};
