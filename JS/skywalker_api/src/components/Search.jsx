import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const Search = (props) => {
    const [number, setNumber] = useState("1");
    const [option, setOption] = useState("");

    const nav = useNavigate();

    const submitForm = (e) => {
        e.preventDefault();
        console.log(option + number);
        nav(option + number);
        setOption("");
    };


    return (
        <div>
            <form onSubmit={submitForm}>
                <label htmlFor="option">Select an Option</label>
                <select id="option" onChange={(e) => setOption(e.target.value)} value={option}>
                    <option value="">--Please choose an option--</option>
                    <option value="/character/" >Character</option>
                    <option value="/planets/" >Planet</option>
                </select>
                <input type="number" value={number} onChange={(e) => setNumber(e.target.value)} />
                <button>Find</button>
            </form>
        </div>
    );
};