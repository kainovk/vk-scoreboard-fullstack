import React from 'react';
import {useParams} from "react-router-dom";

const PostIdPage = () => {
    const {id} = useParams()

    return (
        <div>
            <h1>
                Вы открыли страницу задачи с ID = {id}
            </h1>
            <div>Не реализовано</div>
        </div>
    );
};

export default PostIdPage;