import React, {useState} from 'react';
import MyButton from "../components/UI/button/MyButton";
import MyModal from "../components/UI/MyModal/MyModal";
import TaskCategoryForm from "../components/TaskCategoryForm";
import UserForm from "../components/UserForm";
import TaskForm from "../components/TaskForm";
import UserService from "../API/UserService";
import TaskService from "../API/TaskService";
import TaskCategoryService from "../API/TaskCategoryService";

const AdminPage = () => {
    const [modalCategoryVisible, setModalCategoryVisible] = useState(false)
    const [modalUserVisible, setModalUserVisible] = useState(false)
    const [modalTaskVisible, setModalTaskVisible] = useState(false)
    const [categories, setCategories] = useState([])
    const [users, setUsers] = useState([])
    const [tasks, setTasks] = useState([])

    const createTaskCategory = async (newCategory) => {
        const createdCategory = await TaskCategoryService.create(newCategory)
        setCategories([...categories, createdCategory])
        setModalCategoryVisible(false)
    }

    const createUser = async (newUser) => {
        const createdUser = await UserService.create(newUser)
        setUsers([...users, createdUser])
        setModalUserVisible(false)
    }

    const createTask = async (newTask, categoryId) => {
        const createdTask = await TaskService.create(newTask, categoryId)
        setTasks([...tasks, createdTask])
        setModalTaskVisible(false)
    }

    return (
        <div>
            <h2 style={{textAlign: 'center', marginTop: 20}}>Создание</h2>
            <MyButton style={{marginTop: 15}} onClick={() => setModalCategoryVisible(true)}>
                Создать категорию задач
            </MyButton>
            <MyModal
                visible={modalCategoryVisible}
                setVisible={setModalCategoryVisible}
                title="Создание категории задачи"
            >
                <TaskCategoryForm create={createTaskCategory}/>
            </MyModal>

            <MyButton style={{marginTop: 15}} onClick={() => setModalUserVisible(true)}>
                Создать пользователя
            </MyButton>
            <MyModal
                visible={modalUserVisible}
                setVisible={setModalUserVisible}
                title="Создание пользователя"
            >
                <UserForm create={createUser}/>
            </MyModal>

            <MyButton style={{marginTop: 15}} onClick={() => setModalTaskVisible(true)}>
                Создать задачу
            </MyButton>
            <MyModal
                visible={modalTaskVisible}
                setVisible={setModalTaskVisible}
                title="Создание задачи"
            >
                <TaskForm create={createTask}/>
            </MyModal>
        </div>
    );
};

export default AdminPage;