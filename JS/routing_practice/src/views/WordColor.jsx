import { useParams } from "react-router-dom";

export const WordColor = (props) => {
    const { word, color1, color2 } = useParams();
    return (
        <div style={{ backgroundColor: color1 }}>
            {
                <h1 style={{ color: color2 }}> Your Word is: {word}</h1>
            }
        </div>
    );
};