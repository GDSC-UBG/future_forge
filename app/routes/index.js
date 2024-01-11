module.exports = (express, app, default_router) => {
  require("./auth.route")(express, app, default_router);
  require("./user.route")(express, app, default_router);
  require('./notes.route')(express, app, default_router);
};
