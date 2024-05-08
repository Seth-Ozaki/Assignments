import { Routes, Route, Link, Navigate } from 'react-router-dom';
import { Character } from './views/Character';
import { Planet } from './views/Planet';
import { BadPath } from './views/BadPath';
import { Home } from './views/Home';
import { Error } from './views/Error';
import { Search } from './components/Search';
import './App.css';

function App() {

  return (
    <>
      <h1>StarWars Api!</h1>
      <Search />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/character/:characterid' element={<Character />} />
        <Route path='/planets/:planetid' element={<Planet />} />
        <Route path='/:number' element={<BadPath />} />
        <Route path='/error' element={<Error />} />
      </Routes>
    </>
  );
}

export default App;
