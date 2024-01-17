const multer = require('multer');
const path = require('path');

const storageBanner = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, path.join(__dirname, '../uploads/banners/'));
  },
  filename: (req, file, cb) => {
    const ext = path.extname(file.originalname);
    cb(null, Date.now() + ext);
  },
});

const storageFeed = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, path.join(__dirname, '../uploads/feeds/'));
  },
  filename: (req, file, cb) => {
    const ext = path.extname(file.originalname);
    cb(null, Date.now() + ext);
  },
});

const uploadBanner = multer({ storage: storageBanner });
const uploadFeed = multer({storage: storageFeed})

module.exports = {uploadBanner, uploadFeed };
