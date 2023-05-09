import React from 'react';
import cl from './MyModal.module.css'

const MyModal = ({children, visible, setVisible, title}) => {

    const rootClasses = [cl.myModal]
    if (visible) {
        rootClasses.push(cl.active)
    }

    return (
        <div className={rootClasses.join(' ')} onClick={() => setVisible(false)}>
            <div className={cl.myModalContent} onClick={e => e.stopPropagation()}>
                <h2 style={{textAlign: 'center'}}>{title}</h2>
                {children}
            </div>
        </div>
    );
};

export default MyModal;