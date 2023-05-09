import React from 'react';
import {useNavigate} from "react-router-dom";
import MyButton from "./UI/button/MyButton";
import {stringifyLocalDateTime} from "../utils/date-formatter";

const TaskItem = ({number, task, completed}) => {
    const router = useNavigate()

    const formatDateTime = (dt) => {
        return stringifyLocalDateTime(dt, 'ru-RU')
    }

    return (
        <div className={completed? "task__completed" : "task"}>
            <div className="task__content">
                <strong>{number}. {task.name}</strong>
                <div>Описание: {task.description}</div>
                <div>Дедлайн: {formatDateTime(task.deadlineDt)}</div>
            </div>
            <div className="task__btns">
                <MyButton onClick={() => router(`/tasks/${task.id}`)}>
                    Открыть
                </MyButton>
            </div>
        </div>
    );
};

export default TaskItem;