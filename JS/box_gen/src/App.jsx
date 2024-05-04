import { useState } from 'react';
import './App.css';
import { Box } from './components/Box';
import { Form } from './components/Form';

function App() {
  const [boxes, setBoxes] = useState([
    {
      color: "rebeccapurple",
      size: "100"
    },
  ]);

  const addBoxToState = (newBox) => {
    setBoxes([...boxes, newBox]);
  };

  const deleteBox = (deleteIndex) => {
    const filteredBoxes = boxes.filter((box, idx) => {
      return idx != deleteIndex;
    });
    setBoxes(filteredBoxes);
  };

  return (
    <>
      <Form addBoxToState={addBoxToState} />
      <div style={{ display: "flex", gap: "20px" }}>
        {
          boxes.map((box, idx) => {
            return <Box box={box} key={idx} index={idx} deleteBox={deleteBox} />;
          })
        }
      </div>
    </>
  );
}

export default App;
