import axios from "axios";

//get all
//get one
//create one
//update one
//delete one


const http = axios.create({
    baseURL: 'http://localhost:8000/api',
});


const getAll = () => {
    return http.get('/books')
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const getOne = (id) => {
    return http.get(`/books/${id}`)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const update = (book) => {
    return http.put(`/books/${book._id}`, book)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const deleteThisBook = (book) => {
    return http.delete(`/books/${book}`)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

const create = (book) => {
    return http.post('/books', book)
        .then(res => res.data)
        .catch(err => {
            throw err;
        });
};

export {
    getAll,
    getOne,
    update,
    deleteThisBook,
    create
};