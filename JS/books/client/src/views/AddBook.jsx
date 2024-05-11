import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";


export const AddBook = (props) => {

    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [pages, setPages] = useState(1);
    const [isAvailable, setIsAvailable] = useState(false);

    const [errors, setErrors] = useState({});

    const nav = useNavigate();

    const createBook = (e) => {
        e.preventDefault();
        console.log("hello");

        const newBook = { title, author, pages, isAvailable };

        axios.post("http://localhost:8000/api/books", newBook)
            .then((res) => {
                nav("/");
            })
            .catch((err) => {
                setErrors(err.response.data.errors);
            });

    };

    return (
        <div>
            <form onSubmit={createBook}>
                <div>
                    <p>Title:</p>
                    <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                    {errors.title && <p>{errors.title.message}</p>}
                </div>
                <div>
                    <p>Author:</p>
                    <input type="text" value={author} onChange={(e) => setAuthor(e.target.value)} />
                    {errors.author && <p>{errors.author.message}</p>}
                </div>
                <div>
                    <p>Pages:</p>
                    <input type="number" value={pages} onChange={(e) => setPages(e.target.value)} />
                    {errors.pages && <p>{errors.pages.message}</p>}
                </div>
                <div>
                    <p>Is Available:</p>
                    <input type="checkbox" checked={isAvailable} onChange={(e) => setIsAvailable(e.target.checked)} />
                    {errors.isAvailable && <p>{errors.isAvailable.message}</p>}
                </div>
                <button>Submit</button>
            </form>
        </div>
    );
};
