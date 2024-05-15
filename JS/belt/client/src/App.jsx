import { Route, Routes, Navigate } from 'react-router-dom';
import { Home } from './views/Home';
import { AddMeal } from './views/AddMeal';
import { OneMeal } from './views/OneMeal';
import { Update } from './views/Update';
import './App.css';

function App() {


  return (
    <>
      <div>
        <Routes>
          <Route path='/' element={<Navigate to='/meals' />} />
          <Route path='/meals' element={<Home />} />
          <Route path='/meals/new' element={<AddMeal />} />
          <Route path='/meals/:id/details' element={<OneMeal />} />
          <Route path='/meals/:id/edit' element={<Update />} />
        </Routes>
      </div>
    </>
  );
}

export default App;
