import React from 'react';

export const Task = (props) => {
    const { task } = props;

    return (
        <div>
            <div>
                {task.completed ? <p style={{ textDecoration: "line-through" }}>{task.item}</p> : <p>{task.item}</p>}
            </div>
            <p><input type="checkbox" checked={task.completed} onChange={() => props.completeTask(props.index)} /> Completed?</p>
            <p><button onClick={() => props.deleteTask(props.index)}>Delete task</button></p>
        </div>
    );
};
