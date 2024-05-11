import { useParams, useNavigate, useLocation } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";


export const Navbar = (props) => {


    const nav = useNavigate();


    return (
        <div style={{ display: "flex", justifyContent: "space-" }}>
            <div style={{ display: "flex", flexDirection: "column", width: "150px", gap: "10px" }}>
                <button onClick={() => nav("/")}>Home</button>
                <button onClick={() => nav("/Create")}>Add Book</button>
            </div>
            <div>
                <h1>Book Catalog</h1>
            </div>
        </div>
    );
};
