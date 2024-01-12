const admin = require("firebase-admin");

var serviceAccount = require("./yesmom-348cc-firebase-adminsdk-5e39x-c39bf81455.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

module.exports = {
  admin,
};
