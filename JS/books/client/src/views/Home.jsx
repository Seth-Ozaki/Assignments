import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export const Home = (props) => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8000/api/books")
            .then((res) => {
                setBooks(res.data);
            })
            .catch(err => console.log(err));
    }, []);

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Page Count</th>
                        <th>Available</th>
                        <th>Book Page</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map((book) => {
                            return <tr key={book._id}>
                                <td>{book.title}</td>
                                <td>{book.author}</td>
                                <td>{book.pages}</td>
                                <td>{book.isAvailable ? "✔" : "❌"}</td>
                                <td><Link to={"/books/" + book._id}>Book details</Link></td>
                            </tr>;
                        })
                    }
                </tbody>
            </table>
        </div>
    );
};
