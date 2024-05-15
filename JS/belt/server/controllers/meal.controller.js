import Meal from "../models/meal.model.js";

//CRUD

const MealController = {

    //CREATE----------------------
    create: async (req, res) => {
        try {
            const newMeal = await Meal.create(req.body);
            res.json(newMeal);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    //READ------------------------
    readAll: async (req, res) => {
        try {
            const allMeals = await Meal.find();
            res.json(allMeals);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    readOne: async (req, res) => {
        try {
            const oneMeal = await Meal.findById(req.params.id);
            res.json(oneMeal);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    //UPDATE-----------------------
    update: async (req, res) => {
        const options = {
            new: true,
            runValidators: true
        };
        try {
            const updatedMeal = await Meal.findByIdAndUpdate(req.params.id, req.body, options);
            res.json(updatedMeal);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    //DELETE------------------------
    delete: async (req, res) => {
        try {
            const deletedMeal = await Meal.findByIdAndDelete(req.params.id);
            res.json(deletedMeal);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    }
};

export default MealController;