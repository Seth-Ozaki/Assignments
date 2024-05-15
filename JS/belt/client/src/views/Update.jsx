import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { update, getOne } from "../services/mealService";
import { Navbar } from "../components/Navbar";


export const Update = (props) => {

    const [mealState, setMealState] = useState({
        dish: "",
        time: "",
        directions: "",
        ingredientOne: "",
        ingredientTwo: "",
        ingredientThree: "",
    });

    const handleChange = (e) => {
        let newValue;

        if (e.target.type === "checkbox") {
            newValue = e.target.checked;
        } else {
            newValue = e.target.value;
        }
        setMealState((prevState) => ({
            ...prevState,
            [e.target.name]: newValue
        }));
    };

    const [errors, setErrors] = useState({});
    const { id } = useParams();
    const nav = useNavigate();

    useEffect(() => {
        getOne(id)
            .then((res) => {
                setMealState(res);
            })
            .catch((err) => console.log(err));
    }, []);

    const updateMeal = (e) => {
        e.preventDefault();
        update(mealState)
            .then(res => {
                nav("/");
            })
            .catch(err => {
                setErrors(err.response.data.errors);
            });

    };

    return (
        <div>
            <Navbar name={'update'} id={id} />
            <div>
                <h1 style={{ fontWeight: "lighter" }}> Update {mealState.dish}</h1>
            </div>
            <div>
                <form onSubmit={updateMeal}>
                    <div style={{ display: "flex" }}>
                        <div>
                            <h3>Meal</h3>
                            <div>
                                <p>Dish Name:</p>
                                {errors.dish === undefined ?
                                    <input type="text" value={mealState.dish} name="dish" onChange={handleChange} />
                                    : <>
                                        <input style={{ border: "2px solid red", background: "transparent" }} type="text" value={mealState.dish} name="dish" onChange={handleChange} />
                                        {errors.dish && <p style={{ color: "red" }}>{errors.dish.message}</p>}
                                    </>
                                }
                            </div>
                            <div>
                                <p>Cook Time:</p>
                                {errors.time === undefined ?
                                    <input type="text" value={mealState.time} name="time" onChange={handleChange} />
                                    : <>
                                        <input style={{ border: "2px solid red", background: "transparent" }} type="text" value={mealState.time} name="time" onChange={handleChange} />
                                        {errors.time && <p style={{ color: "red" }}>{errors.time.message}</p>}
                                    </>
                                }
                            </div>
                            <div>
                                <p>Directions:</p>
                                {errors.directions === undefined ?
                                    <input type="text" value={mealState.directions} name="directions" onChange={handleChange} />
                                    : <>
                                        <input style={{ border: "2px solid red", background: "transparent" }} type="text" value={mealState.directions} name="directions" onChange={handleChange} />
                                        {errors.directions && <p style={{ color: "red" }}>{errors.directions.message}</p>}
                                    </>
                                }
                            </div>
                        </div>
                        <div>
                            <h3>Ingredients (optional)</h3>
                            <div>
                                <p>One:</p>
                                <input type="text" value={mealState.ingredientOne} name="ingredientOne" onChange={handleChange} />
                            </div>
                            <div>
                                <p>Two:</p>
                                <input type="text" value={mealState.ingredientTwo} name="ingredientTwo" onChange={handleChange} />
                            </div>
                            <div>
                                <p>Three:</p>
                                <input type="text" value={mealState.ingredientThree} name="ingredientThree" onChange={handleChange} />
                            </div>
                        </div>
                    </div>
                    <button>Submit</button>
                </form>
            </div >
        </div >
    );
};

