import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Navbar } from "../components/Navbar";
import { create } from "../services/bookService";


export const AddBook = (props) => {

    // const [title, setTitle] = useState("");
    // const [author, setAuthor] = useState("");
    // const [pages, setPages] = useState(1);
    // const [isAvailable, setIsAvailable] = useState(false);

    const [bookState, setBookState] = useState({
        title: "",
        author: "",
        pages: 1,
        isAvailable: false
    });

    const handleChange = (e) => {
        let newValue;

        if (e.target.type === "checkbox") {
            newValue = e.target.checked;
        } else {
            newValue = e.target.value;
        }
        setBookState((prevState) => ({
            ...prevState,
            [e.target.name]: newValue
        }));
    };

    const [errors, setErrors] = useState({});

    const nav = useNavigate();

    const createBook = (e) => {
        e.preventDefault();

        const newBook = { ...bookState };

        create(newBook)
            .then((res) => {
                nav("/");
            })
            .catch((err) => {
                setErrors(err.response.data.errors);
            });

    };

    return (
        <div>
            <Navbar title={'Add Book'} />
            <div>
                <form onSubmit={createBook}>
                    <div>
                        <p>Title:</p>
                        <input type="text" value={bookState.title} name="title" onChange={handleChange} />
                        {errors.title && <p>{errors.title.message}</p>}
                    </div>
                    <div>
                        <p>Author:</p>
                        <input type="text" value={bookState.author} name="author" onChange={handleChange} />
                        {errors.author && <p>{errors.author.message}</p>}
                    </div>
                    <div>
                        <p>Pages:</p>
                        <input type="number" value={bookState.pages} name="pages" onChange={handleChange} />
                        {errors.pages && <p>{errors.pages.message}</p>}
                    </div>
                    <div>
                        <p>Is Available:</p>
                        <input type="checkbox" checked={bookState.isAvailable} name="isAvailable" onChange={handleChange} />
                        {errors.isAvailable && <p>{errors.isAvailable.message}</p>}
                    </div>
                    <button>Submit</button>
                </form>
            </div>
        </div>
    );
};
