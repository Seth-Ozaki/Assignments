import { useState } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from '/vite.svg';
import './App.css';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>

      <h1>Hello world!</h1>
      <h3>Things I need to do:</h3>
      <div >
        <ul>
          <li>Learn React</li>
          <li>Climb Mt. Everest</li>
          <li>Run a Marathon</li>
          <li>Feed the dogs</li>
        </ul>
      </div>
    </>
  );
}

export default App;
