import { connect } from "mongoose";
import dotenv from "dotenv";

dotenv.config();
const MONGODB_URI = process.env.MONGODB_URI;

const dbConnect = async (DB_NAME) => {
    try {
        await connect(MONGODB_URI, {
            dbName: DB_NAME
        });
        console.log(`✔ Successfully connected to database: ${DB_NAME}!`);
    } catch (err) {
        console.log(`❌ Error connecting to database: ${DB_NAME}`, err);
        throw err;
    }
};

export default dbConnect;