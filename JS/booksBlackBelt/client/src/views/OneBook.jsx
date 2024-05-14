import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import { Navbar } from '../components/Navbar';
import { getOne } from "../services/bookService";
import { deleteThisBook } from "../services/bookService";


export const OneBook = () => {
    const [book, setBook] = useState(null);
    const { id } = useParams();
    const nav = useNavigate();
    useEffect(() => {
        getOne(id)
            .then((res) => {
                setBook(res);
            })
            .catch((err) => console.log(err));
    }, []);

    const deleteBook = (bookID) => {
        deleteThisBook(bookID)
            .then((res) => {
                nav("/");
            })
            .catch((err) => console.log(err));
    };

    //usenav inside is a stack where you can pass state
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
