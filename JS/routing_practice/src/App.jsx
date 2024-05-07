import { Routes, Route, Link, Navigate } from "react-router-dom";
import { Home } from "./views/Home";
import { Input } from "./views/Input";
import { WordColor } from "./views/WordColor";
import './App.css';

function App() {


  return (
    <>
      <Routes>
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/home" element={<Home />} />
        <Route path="/:input" element={<Input />} />
        <Route path="/:word/:color1/:color2" element={<WordColor />} />
      </Routes>
    </>
  );
}

export default App;
