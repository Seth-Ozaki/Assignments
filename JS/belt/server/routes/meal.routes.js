import { Router } from "express";
import MealController from "../controllers/meal.controller.js";

// Creating a router variable for ease of use
const router = Router();

router.route("/meals")
    .get(MealController.readAll)
    .post(MealController.create);

router.route("/meals/:id")
    .delete(MealController.delete)
    .get(MealController.readOne)
    .put(MealController.update);





export default router;