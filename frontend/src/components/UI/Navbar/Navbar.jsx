import React from 'react';
import {Link} from "react-router-dom";

const Navbar = () => {
    return (
        <div className="navbar">
            <div className="navbar__links">
                <Link to="/admin-panel" style={{paddingLeft: '5px'}}>Админка</Link>
                <Link to="/tasks" style={{paddingLeft: '5px'}}>Задачи</Link>
                <Link to="/statistics" style={{paddingLeft: '5px'}}>Статистика</Link>
                <Link to="/about" style={{paddingLeft: '5px'}}>О сайте</Link>
            </div>
        </div>
    );
};

export default Navbar;