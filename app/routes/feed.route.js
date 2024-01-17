const feedController = require("../controllers/feed.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkQuery } = require('../middlewares/banner')
const {uploadFeed} = require('../middlewares/multer')



require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  
  // router.get('/banner', [verifyToken, checkQuery], bannerController.getAllBanner)
  // router.get('/banner/:id', [verifyToken], bannerController.getDetailBanner)
  router.post('/feed', [verifyToken, uploadFeed.single('image')], feedController.createFeed)
  // router.delete('/banner/:id', [verifyToken], bannerController.deleteBanner)

  app.use(default_router, router);
};
