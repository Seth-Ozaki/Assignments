import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import dbConnect from "./config/mongoose.config.js";
import router from "./routes/book.routes.js";
const app = express();

//MIDDLEWARE
app.use(express.json, cors());
app.use("/api", router);

//access .env variables
dotenv.config();
const PORT = process.env.PORT;

//Access remote DB
const DB_NAME = "books";
dbConnect(DB_NAME);

app.listen(PORT, () =>
    console.log(`>>> Listening on port: ${PORT}`)
);