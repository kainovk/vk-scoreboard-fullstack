import React, {useState} from 'react';
import MyInput from "./UI/input/MyInput";
import MyButton from "./UI/button/MyButton";

const TaskForm = ({create}) => {
    const [categoryId, setCategoryId] = useState('')

    const [task, setTask] = useState({
        name: '',
        description: '',
        deadlineDt: ''
    })

    const addNewTask = (e) => {
        e.preventDefault()
        console.log('создание задачи: ' + JSON.stringify(task, categoryId))
        const newTask = {
            ...task/*, id: Date.now()*/
        }
        create(newTask, categoryId)
        setTask({name: '', description: '', deadlineDt: ''})
        setCategoryId('')
    }

    return (
        <form>
            <MyInput
                type="text"
                placeholder="Название задачи"
                value={task.name}
                onChange={e => setTask({...task, name: e.target.value})}
            />
            <MyInput
                type="text"
                placeholder="Описание..."
                value={task.description}
                onChange={e => setTask({...task, description: e.target.value})}
            />
            <MyInput
                type="datetime-local"
                placeholder="Дата и время дедлайна"
                value={task.deadlineDt}
                onChange={e => setTask({...task, deadlineDt: e.target.value})}
            />
            <MyInput
                type="text"
                placeholder="id категории задачи"
                value={categoryId}
                onChange={e => setCategoryId(e.target.value)}
            />
            <MyButton onClick={addNewTask}>Создать</MyButton>
        </form>
    );
};

export default TaskForm;