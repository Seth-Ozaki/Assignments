import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const planetURL = "https://swapi.dev/api/planets/";

export const Planet = (props) => {

    const [planet, setPlanet] = useState(null);

    const nav = useNavigate();

    const { planetid } = useParams();

    useEffect(() => {
        axios.get(planetURL + planetid)
            .then(res => {
                setPlanet(res.data);
            })
            .catch(err => {
                console.log("error", err);
                nav("/error");
            });
    }, [planetid]);

    return (
        <div>
            {
                planet ? <>
                    <div>
                        <h2>{planet.name}</h2>
                        <ul>
                            <li>Climate: {planet.climate}</li>
                            <li>Terrain: {planet.terrain}</li>
                            <li>Diameter: {planet.diameter}</li>
                            <li>Gravity: {planet.gravity}</li>
                            <li>Orbit: {planet.orbital_period} days</li>
                            <li>Population: {planet.population}</li>
                        </ul>
                    </div>
                </> : <h2>Loading...</h2>
            }
        </div>
    );
};
