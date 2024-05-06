import { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [pokemon, setPokemon] = useState([{ name: "test" }]);
  const getPokemon = (props) => {

    axios.get("https://pokeapi.co/api/v2/pokemon?limit=807")
      .then((res) => {
        setPokemon(res.data.results);
      }).catch((err) => {
        console.log(err);
      });
  };
  return (
    <>
      {getPokemon()}
      <h1>Pokemon API</h1>
      <div>
        {pokemon.map((p, idx) => {
          return <li key={idx}>{p.name}</li>;
        })
        }
      </div>
    </>
  );
}

export default App;
