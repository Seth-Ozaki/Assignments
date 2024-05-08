import express from "express";
import router from "./routes/user.routes.js";
const app = express();
const port = 8000;

// middleware
app.use(express.json());

// routes
app.use('/api', router);

// this needs to be below the other code blocks
app.listen(port, () => console.log(`Listening on port: ${port}`));