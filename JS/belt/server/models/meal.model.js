import { model, Schema } from "mongoose";

const MealSchema = new Schema(
    {
        dish: {
            type: String,
            required: [true, "Dish name required"],
            minlength: [3, "That dish name is too short (minimum 4)"],
            maxlength: [20, "That dish name is too long (limit 20)"]
        },
        time: {
            type: Number,
            required: [true, "Dish cook time required"],
            minlength: [2, "Cook time is too short (minimum 3)"],
            maxlength: [240, "Cook time is too long (limit 240)"]
        },
        directions: {
            type: String,
            required: [true, "There must be directions"],
            minlength: [10, "The directions are too short(minimum 10)"]
        },
        ingredientOne: {
            type: String
        },
        ingredientTwo: {
            type: String
        },
        ingredientThree: {
            type: String
        }
    },
    { timestamps: true }
);
const Meal = model("Meal", MealSchema);
export default Meal;