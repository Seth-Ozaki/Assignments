import { useParams } from "react-router-dom";

export const Input = (props) => {
    const { input } = useParams();
    return (
        <div>
            {
                isNaN(input) ?
                    <h1> Your Word is: {input}</h1>
                    : <h1>Your number is: {input}</h1>
            }
        </div>
    );
};
