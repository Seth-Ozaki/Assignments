import { useNavigate } from "react-router-dom";;


export const Navbar = (props) => {

    const nav = useNavigate();


    return (
        <div style={{ display: "flex", justifyContent: "space-" }}>
            <div style={{ display: "flex", flexDirection: "column", width: "150px", gap: "10px" }}>
                <button onClick={() => nav("/")}>Home</button>
                <button onClick={() => nav("/Create")}>Add Book</button>
            </div>
            <div>
                {
                    props.title ? <h1>{props.title}</h1> : <h1>Book Catalog</h1>
                }
            </div>
        </div>
    );
};
