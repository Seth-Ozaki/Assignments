// controller?
// CRUD

import Cake from "../models/cake.model.js";

const CakeController = {

    // CREATE ------------------
    create: async (req, res) => {
        try {
            const newCake = await Cake.create(req.body); // {}
            // ! this res.json is what axios will receive in REACT
            res.json(newCake);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    // READ ALL --------------------
    readAll: async (req, res) => {
        try {
            const allCakes = await Cake.find(); // []
            res.json(allCakes); // []
        } catch (error) {
            console.log(error);
            res.status(400).json(error); // here is our error response
        }
    },

    // READ ONE --------------------
    readOne: async (req, res) => {
        try {
            const foundCake = await Cake.findById(req.params.id);
            res.json(foundCake); // {} / null
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    // UPDATE -------------------------
    update: async (req, res) => {
        const options = {
            new: true,
            runValidators: true,
        };
        try {
            const updatedCake = await Cake.findByIdAndUpdate(req.params.id, req.body, options);
            res.json(updatedCake);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    },

    // DELETE ---------------
    delete: async (req, res) => {
        try {
            const deletedCake = await Cake.findByIdAndDelete(req.params.id);
            res.json(deletedCake);
        } catch (error) {
            console.log(error);
            res.status(400).json(error);
        }
    }
};

export default CakeController;