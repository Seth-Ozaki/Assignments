import express from "express";
const app = express();
const port = 8000;

app.get("/api/hello", (req, res) => {
    res.send("<h1>Hello World</h1>");
});



app.listen(port, () => console.log(`SERVER is up on port: ${port}`));