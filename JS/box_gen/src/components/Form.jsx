
import { useState } from 'react';

export const Form = (props) => {
    const [color, setColor] = useState("");
    const [size, setSize] = useState("");

    const createBox = (e) => {
        e.preventDefault();
        const newBox = {
            color, size
        };
        props.addBoxToState(newBox);
        setColor("");
        setSize("");
    };

    return (
        <div style={{ margin: "20px" }}>
            <h4>Create a box!</h4>
            <form onSubmit={createBox} style={{ display: 'flex', flexDirection: 'column' }}>
                <input placeholder='Color' value={color} onChange={(e) => { setColor(e.target.value); }} /> <br />
                <input type='number' placeholder='Size(px)' value={size} onChange={(e) => { setSize(e.target.value); }} /> <br />
                <button type='submit'>Add Box</button>
            </form>
        </div>
    );
};
