import { Routes, Route, Link } from 'react-router-dom';
import { Home } from './views/Home';
import { OneBook } from './views/OneBook';
import { Navbar } from './components/Navbar';
import { AddBook } from './views/AddBook';
import './App.css';

function App() {

  return (
    <>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/books/:id" element={<OneBook />} />
          <Route path="/Create" element={<AddBook />} />
        </Routes>

      </div>
    </>
  );
}

export default App;
