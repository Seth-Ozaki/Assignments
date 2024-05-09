import { Router } from "express";
import ShowController from "../controllers/show.controller.js";
const router = Router();


router.route("/shows")
    .get(ShowController.readAll)
    .post(ShowController.create);


router.route("/show/:tvShow")
    .put(ShowController.update)
    .delete(ShowController.delete);

router.route("/shows/:yearCreated")
    .get(ShowController.readOne);

export default router;