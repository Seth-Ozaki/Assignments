import express from "express";
import cors from "cors";
import mongoose from "mongoose";
import dotenv from "dotenv";
import dbConnect from "./config/mongoose.config.js";
const app = express();

//MIDDLEWARE
app.use(express.json, cors());

//Access env variables
dotenv.config();
const PORT = process.env.PORT;

//Access remote DB
const DB_NAME = "firstMongodb";
dbConnect(DB_NAME);

app.listen(PORT, () => {
    console.log(`>>> Listening on port: ${PORT}`);
});