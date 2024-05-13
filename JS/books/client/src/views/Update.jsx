import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { Navbar } from '../components/Navbar';



export const Update = (props) => {

    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [pages, setPages] = useState(1);
    const [isAvailable, setIsAvailable] = useState(false);
    const [errors, setErrors] = useState({});
    const { id } = useParams();
    const nav = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8000/api/books/" + id)
            .then((res) => {
                setTitle(res.data.title);
                setAuthor(res.data.author);
                setPages(res.data.pages);
                setIsAvailable(res.data.isAvailable);
            })
            .catch((err) => console.log(err));
    }, []);

    const updateBook = (e) => {
        e.preventDefault();
        const updatedBook = { title, author, pages, isAvailable };
        axios.put("http://localhost:8000/api/books/" + id, updatedBook)
            .then(res => {
                nav("/");
            })
            .catch(err => {
                setErrors(err.response.data.errors);
            });

    };



    return (
        <div>
            <Navbar title={`Update ${title}`} />
            <div>
                <form onSubmit={updateBook}>
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
        </div>
    );
};