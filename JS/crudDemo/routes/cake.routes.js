import { Router } from "express";
import CakeController from "../controllers/cake.controller.js";

// Creating a router variable for ease of use
const router = Router();

router.route("/cakes")
    .get(CakeController.readAll)
    .post(CakeController.create);

router.route("/cakes/:id")
    .get(CakeController.readOne)
    .put(CakeController.update)
    .delete(CakeController.delete);

export default router;