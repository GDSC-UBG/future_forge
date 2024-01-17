module.exports = (express, app, default_router) => {
  require("./auth.route")(express, app, default_router);
  require("./user.route")(express, app, default_router);
  require("./calender.route")(express, app, default_router);
  require("./notes.route")(express, app, default_router)
  require('./banner.route')(express, app, default_router)
  require('./feed.route')(express, app, default_router)
  
};
