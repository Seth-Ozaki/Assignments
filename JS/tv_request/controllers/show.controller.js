import shows from "../models/show.model.js";

const ShowController = {
    readAll: (req, res) => {
        res.json(shows);
    },

    create: (req, res) => {
        console.log(req.body);
        shows.push(req.body);
        res.json(shows);
    },

    readOne: (req, res) => {
        const getShowByYear = shows.find(show => show.yearCreated == req.params.yearCreated);
        console.log(getShowByYear);
        res.json(getShowByYear);
    },


    update: (req, res) => {
        shows.forEach((show, idx) => {
            if (show.tvShow == req.params.tvShow) {
                show = { ...show, ...req.body };
                shows[idx] = show;
            }
        });
        const updatedShow = shows.find(show => show.tvShow == req.params.tvShow);
        res.json(updatedShow);
    },

    delete: (req, res) => {
        const tvShow = req.params.tvShow;
        const index = shows.findIndex(show => show.tvShow == tvShow);
        shows.splice(index, 1);
        res.json(shows);
    }

};

export default ShowController;