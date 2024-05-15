import axios from "axios";

const http = axios.create({
    baseURL: 'http://localhost:8000/api',
});


const getAll = () => {
    return http.get('/meals')
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const getOne = (id) => {
    return http.get(`/meals/${id}`)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const update = (book) => {
    return http.put(`/meals/${book._id}`, book)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const deleteThisMeal = (book) => {
    return http.delete(`/meals/${book}`)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const create = (book) => {
    return http.post('/meals', book)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

export {
    getAll,
    getOne,
    update,
    deleteThisMeal,
    create
};