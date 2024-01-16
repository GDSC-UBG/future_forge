const NotesController = require("../controllers/notes.controller");
const { verifyToken } = require("../middlewares/auth.jwt");
const { haveNotes } = require("../middlewares/authoriztion")
const { checkField } = require('../middlewares/notes')


require("dotenv").config();

module.exports = (express, app, default_router = "/api") => {
  const router = express.Router();

  router.post('/notes', [verifyToken, checkField], NotesController.addNotes)
  router.delete('/notes/:id', [verifyToken], NotesController.deleteNotes)
  router.get('/notes', [verifyToken], NotesController.getAllNotes)
  router.get('/notes/:id', [verifyToken], NotesController.getDetailNote)
  router.put('/notes/:id', [verifyToken, checkField], NotesController.updateNotes)

  app.use(default_router, router);
};
