import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const peopleURL = "https://swapi.dev/api/people/";

export const Character = (props) => {

    const [character, setCharacter] = useState(null);

    const nav = useNavigate();

    const { characterid } = useParams();

    useEffect(() => {
        axios.get(peopleURL + characterid)
            .then(res => {
                console.log(res.data);
                setCharacter(res.data);
            })
            .catch(err => {
                console.log("error", err);
                nav("/error");
            });
    }, []);

    return (
        <div>
            {
                character ? <>
                    <div>
                        <h2>{character.name}</h2>
                        <ul>
                            <li>Height: {character.height}</li>
                            <li>Mass: {character.mass}</li>
                            <li>Hair: {character.hair_color}</li>
                            <li>Skin: {character.skin_color}</li>
                            <li>Eyes: {character.eye_color}</li>
                            <li>Birth year: {character.birth_year}</li>
                        </ul>
                    </div>
                </> : <h2>Loading...</h2>
            }
        </div>
    );
};
