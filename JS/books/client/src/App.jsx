import { Routes, Route } from 'react-router-dom';
import { Home } from './views/Home';
import { OneBook } from './views/OneBook';
import { AddBook } from './views/AddBook';
import { Update } from './views/Update';
import './App.css';

function App() {

  return (
    <>
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/books/:id" element={<OneBook />} />
          <Route path="/Create" element={<AddBook />} />
          <Route path="update/:id" element={<Update />} />
        </Routes>

      </div>
    </>
  );
}

export default App;
