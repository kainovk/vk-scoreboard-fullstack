import React from 'react';
import TaskItem from "./TaskItem";

const TaskList = ({tasks, title, completed}) => {

    if (!tasks.length) {
        return (
            <h1 style={{textAlign: 'center'}}>
                Задачи не найдены!
            </h1>
        )
    }

    return (
        <div>
            <h1 style={{textAlign: "center"}}>
                {title}
            </h1>
            {tasks.map((task, index) =>
                <TaskItem completed={completed} number={index + 1} key={task.id} task={task}/>
            )}
        </div>
    );
};

export default TaskList;