import React, {useEffect, useState} from 'react';
import MyButton from "../components/UI/button/MyButton";
import TaskService from "../API/TaskService";
import TaskList from "../components/TaskList";
import MyInput from "../components/UI/input/MyInput";

const Tasks = () => {
    const [tasks, setTasks] = useState([])
    const [completedTasks, setCompletedTasks] = useState([])
    const [userId, setUserId] = useState('')

    useEffect(() => {
        fetchTasks()
    }, [])

    async function fetchTasks() {
        const tasks = await TaskService.getAll()
        setTasks(tasks)
    }

    async function fetchCompletedTasks() {
        const completedTasks = await TaskService.getCompletedTasksByUserId(userId)
        console.log(JSON.stringify(completedTasks))
        setCompletedTasks(completedTasks)
        setUserId('')
    }

    return (
        <div className="App">
            <TaskList tasks={tasks} title="Список задач"/>
            <hr style={{margin: '15px 0'}}/>
            <MyInput
                type="text"
                placeholder="Введите id пользователя, чтобы получить список завршенных им задач"
                value={userId}
                onChange={e => setUserId(e.target.value)}
            />
            <MyButton onClick={fetchCompletedTasks}>Отправить запрос</MyButton>
            <TaskList tasks={completedTasks} title="Список завершенных задач" completed={true}/>
        </div>
    );
};

export default Tasks;