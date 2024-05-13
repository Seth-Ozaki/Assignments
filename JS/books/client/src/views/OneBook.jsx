import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navbar } from '../components/Navbar';


export const OneBook = () => {
    const [book, setBook] = useState(null);
    const { id } = useParams();
    const nav = useNavigate();
    useEffect(() => {
        axios.get("http://localhost:8000/api/books/" + id)
            .then((res) => {
                setBook(res.data);
            })
            .catch((err) => console.log(err));
    }, []);

    const deleteBook = (bookID) => {
        console.log(bookID);
        axios.delete("http://localhost:8000/api/books/" + id)
            .then((res) => {
                nav("/");
            })
            .catch((err) => console.log(err));
    };


    return (
        <div>
            {
                book ? <>
                    <Navbar title={book.title} />
                    <div>
                        <h2 style={{ fontWeight: "bold" }}>{book.title}</h2>
                        <h4>By {book.author}</h4>
                    </div>
                    <div>
                        <h4>Page Count: {book.pages}</h4>
                        {book.isAvailable ? <>
                            <div style={{ color: "green" }}>Available for Borrowing</div>
                            <button onClick={() => deleteBook(book._id)}>Borrow</button>
                        </>
                            : <div style={{ color: "tomato" }}>Not available</div>
                        }
                    </div>
                </>
                    : <h1>...Loading</h1>
            }
        </div>
    );
};
