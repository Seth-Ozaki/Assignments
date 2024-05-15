import { useParams, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import { getOne } from "../services/mealService";
import { deleteThisMeal } from "../services/mealService";
import { Navbar } from "../components/Navbar";



export const OneMeal = () => {
    const [meal, setMeal] = useState(null);
    const { id } = useParams();
    const nav = useNavigate();
    useEffect(() => {
        getOne(id)
            .then((res) => {
                setMeal(res);
            })
            .catch((err) => console.log(err));
    }, []);

    const deleteMeal = (mealID) => {
        deleteThisMeal(mealID)
            .then((res) => {
                nav("/");
            })
            .catch((err) => console.log(err));
    };

    //usenav inside is a stack where you can pass state
    return (
        <div>
            <Navbar />
            {
                meal ? <>

                    <div style={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}>
                        <div>
                            <h1 style={{ fontWeight: "lighter" }}> {meal.dish}</h1>
                        </div>
                        <div>
                            <button onClick={() => deleteMeal(meal._id)}>Remove</button>
                        </div>
                    </div>
                    <div>
                        <table>
                            <tbody>

                                <tr>
                                    <th>Cook Time:</th>
                                    <td>{meal.time}</td>
                                </tr>
                                <tr>
                                    <th>Ingredients:</th>
                                    <td>One: {meal.ingredientOne} Two: {meal.ingredientTwo} Three: {meal.ingredientThree}</td>

                                </tr>
                                <tr>
                                    <th>Directions:</th>
                                    <td>{meal.directions}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </>
                    : <h1>...Loading</h1>
            }
        </div>
    );
};