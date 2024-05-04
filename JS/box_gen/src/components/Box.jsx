import { useState } from "react";

export const Box = (props) => {
    const { box } = props;


    return (
        <div style={{ display: "flex", flexDirection: "column", alignContent: "center" }}>
            <div style={{ backgroundColor: box.color, width: box.size + "px", height: box.size + "px" }}></div>
            <button onClick={() => { props.deleteBox(props.index); }}>Delete</button>
        </div>
    );
};
