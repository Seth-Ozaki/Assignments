import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { getAll } from '../services/mealService';
import { Navbar } from '../components/Navbar';


export const Home = (props) => {
    const [meals, setMeals] = useState([]);

    useEffect(() => {
        getAll()
            .then((res) => {
                setMeals(res);
            })
            .catch(err => console.log(err));
    }, []);

    return (
        <>
            <Navbar name={'home'} />
            <div>
                <h1 style={{ fontWeight: "lighter" }}> Find inspiration with these delicious meals!</h1>
            </div>
            <div style={{ display: "flex", justifyContent: "center" }}>
                <table style={{ borderCollapse: "collapse" }}>
                    <thead>
                        <tr>
                            <th>Meal</th>
                            <th>Cook time</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            meals.map((meal) => {
                                return <tr key={meal._id}>
                                    <td>{meal.dish}</td>
                                    <td>{meal.time}</td>
                                    <td><Link to={`/meals/${meal._id}/details`}>Details</Link> | <Link to={`/meals/${meal._id}/edit`}>Edit</Link></td>
                                </tr>;
                            })
                        }
                    </tbody>
                </table>
            </div>
        </>
    );
};