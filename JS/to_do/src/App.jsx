import { useState } from 'react';
import './App.css';
import { Form } from './components/Form';
import { Task } from './components/Task';


function App() {

  const [tasks, setTasks] = useState([
    {
      item: "Complete 'Todo List' assignment",
      completed: true
    },
    {
      item: "MERN black belt",
      completed: false
    }
  ]);

  const addTask = (newTask) => {
    setTasks([...tasks, newTask]);
  };

  const completeTask = (completeidx) => {
    const copyTasks = [...tasks];
    copyTasks[completeidx].completed = !copyTasks[completeidx].completed;
    setTasks(copyTasks);
  };

  const deleteTask = (deleteidx) => {
    const filteredTasks = tasks.filter((task, idx) => {
      return idx != deleteidx;
    });
    setTasks(filteredTasks);
  };

  return (
    <>
      <Form addTask={addTask} />
      <div>
        {
          tasks.map((task, idx) => {
            return <Task task={task} key={idx} index={idx} completeTask={completeTask} deleteTask={deleteTask} />;
          })
        }
      </div>

    </>
  );
}

export default App;
