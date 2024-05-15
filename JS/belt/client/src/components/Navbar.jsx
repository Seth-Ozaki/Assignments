import { useNavigate } from "react-router-dom";;


export const Navbar = (props) => {

    const nav = useNavigate();

    const where = () => {
        if (props.name === 'update') {
            return <button onClick={() => nav(`/meals/${props.id}/details`)}>Meal Details</button>;
        }
        if (props.name === 'home') {
            return <button onClick={() => nav(`/meals/new`)}>New Meal</button>;
        } else {
            return <button onClick={() => nav(`/meals`)}>Back Home</button>;
        }
    };

    return (
        <div style={{ display: "flex", justifyContent: "space-between" }}>
            <div>
                <h1>Speedy Meals</h1>
            </div>
            <div>
                {where()}
            </div>
        </div>
    );
};