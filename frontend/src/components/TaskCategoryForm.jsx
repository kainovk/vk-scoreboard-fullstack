import React, {useState} from 'react';
import MyInput from "./UI/input/MyInput";
import MyButton from "./UI/button/MyButton";

const TaskCategoryForm = ({create}) => {
    const [category, setCategory] = useState({name: ''})

    const addNewCategory = (e) => {
        e.preventDefault()
        const newCategory = {
            ...category/*, id: Date.now()*/
        }
        create(newCategory)
        setCategory({name: ''})
    }

    return (
        <form>
            <MyInput
                type="text"
                placeholder="Название категории"
                value={category.name}
                onChange={e => setCategory({...category, name: e.target.value})}
            />
            <MyButton onClick={addNewCategory}>Создать</MyButton>
        </form>
    );
};

export default TaskCategoryForm;