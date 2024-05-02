import { useState } from "react";

export const PersonCard = (prop) => {
    const { firstName, lastName, age, hairColor } = prop;

    const [ageDisplay, setAgeDisplay] = useState(age);

    const increaseAge = () => {
        setAgeDisplay(ageDisplay + 1);
    };

    return (

        <div>
            <h3>Person card for {firstName} {lastName}</h3>
            <h5>Age: {ageDisplay}</h5>
            <h5>Hair color:{hairColor}</h5>
            <button onClick={() => alert("Haha you wish pal!")}>Decrease your age</button>
            <button onClick={() => increaseAge()}>Increase your age</button>

        </div>
    );
};
