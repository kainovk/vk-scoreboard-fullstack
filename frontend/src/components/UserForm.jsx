import React, {useState} from 'react';
import MyInput from "./UI/input/MyInput";
import MyButton from "./UI/button/MyButton";

const UserForm = ({create}) => {
    const [user, setUser] = useState({name: ''})

    const addNewUser = (e) => {
        e.preventDefault()
        const newUser = {
            ...user/*, id: Date.now()*/
        }
        create(newUser)
        setUser({name: ''})
    }

    return (
        <form>
            <MyInput
                type="text"
                placeholder="Псевдоним пользователя"
                value={user.name}
                onChange={e => setUser({...user, name: e.target.value})}
            />
            <MyButton onClick={addNewUser}>Создать</MyButton>
        </form>
    );
};

export default UserForm;