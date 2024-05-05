import React, { useState } from 'react';

export const Form = (props) => {
    const [item, setItem] = useState("");
    const [completed, setCompleted] = useState(false);

    const createTask = (e) => {
        e.preventDefault();
        const newTask = {
            item,
            completed
        };
        props.addTask(newTask);
        setItem("");
    };

    return (
        <form onSubmit={createTask}>
            <input type="text" value={item} onChange={(e) => { setItem(e.target.value); }} />
            <button>Create Task</button>
        </form>
    );
};
