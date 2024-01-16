const bannerController = require("../controllers/banner.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { checkQuery } = require('../middlewares/banner')
const upload = require('../middlewares/multer')



require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  
  router.get('/banner', [verifyToken, checkQuery], bannerController.getAllBanner)
  router.get('/banner/:id', [verifyToken], bannerController.getDetailBanner)
  router.post('/banner', [verifyToken, upload.single('image')], bannerController.createBanner)
  router.delete('/banner/:id', [verifyToken], bannerController.deleteBanner)

  app.use(default_router, router);
};
