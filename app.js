const express = require("express");
const app = express();
const cors = require("cors");
const bodyParser = require("body-parser");
require("dotenv").config();
var cron = require("node-cron");
const {
  scheduleDailyNotifications,
} = require("./app/services/schaduler.service");

app.use(cors());

// Ganti penggunaan bodyParser.json() menjadi bodyParser.urlencoded()
// dan atur opsi extended ke true
app.use(bodyParser.json());

const default_router = `/api/${process.env.APP_VERSION}`;
require("./app/routes")(express, app, default_router);

// try {
//   cron.schedule("*/5 * * * * *", () => {
//     console.log("Running a task");
//     scheduleDailyNotifications();
//   });
// } catch (error) {
//   console.log(error);
// }

module.exports = app;
