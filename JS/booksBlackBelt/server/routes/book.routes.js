import { Router } from "express";
import BookController from "../controllers/book.controller.js";

// Creating a router variable for ease of use
const router = Router();

router.route("/books")
    .get(BookController.readAll)
    .post(BookController.create);

router.route("/books/:id")
    .get(BookController.readOne)
    .put(BookController.update)
    .delete(BookController.delete);

export default router;