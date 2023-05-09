import React, {useEffect, useState} from 'react';
import UserStatisticsService from "../API/UserStatisticsService";
import MyInput from "../components/UI/input/MyInput";

const StatisticsPage = () => {
    const [userId, setUserId] = useState('');
    const [personalStats, setPersonalStats] = useState([]);
    const [comparativeStats, setComparativeStats] = useState([]);

    function isNonNegativeInteger(str) {
        return /^\d+$/.test(str);
    }

    useEffect(() => {
        if (!isNonNegativeInteger(userId)) {
            setPersonalStats([])
            setComparativeStats([])
        } else {
            fetchStats();
        }
    }, [userId]);

    const fetchPersonalStats = async () => {
        const response = await UserStatisticsService.getPersonalStatsByUserId(userId);
        setPersonalStats(response);
    }

    const fetchComparativeStats = async () => {
        const response = await UserStatisticsService.getComparativeStatsByUserId(userId);
        setComparativeStats(response);
    }

    const fetchStats = async () => {
        try {
            await fetchPersonalStats()
            await fetchComparativeStats()
        } catch (error) {
            console.error('Error fetching statistics:', error);
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        fetchStats();
    };

    return (
        <div>
            <h2 style={{textAlign: 'center', margin: '20px 20px'}}>Пользовательская статистика</h2>
            <form onSubmit={handleSubmit}>
                <MyInput
                    style={{width: 800}}
                    type="text"
                    placeholder="Введите id пользователя"
                    value={userId}
                    onChange={(e) => setUserId(e.target.value)}
                />
            </form>
            <div>
                <h2>Персональная статистика:</h2>
                {Object.keys(personalStats).length ? (
                    <div>
                        {Object.keys(personalStats).map((key) =>
                            <h3 key={key}>Вы выполнили {personalStats[key]} задач категории {key}</h3>
                        )}
                    </div>
                ) : <div>Нет данных</div>}
                <hr style={{margin: '15px 0'}}/>
                <h2>Сравнительная статистика:</h2>
                {Object.keys(comparativeStats).length ? (
                    <div>
                        {Object.keys(comparativeStats).map((key) => (
                            <div key={key}>
                                <div>
                                    <h3>В сравнении с пользователем с ID = {key}:</h3>
                                    <ul>
                                        {Object.keys(comparativeStats[key]).map((innerKey) => (
                                            <li style={{fontSize: 18}} key={innerKey}>
                                                В категории {innerKey} вы выполнили
                                                {comparativeStats[key][innerKey]
                                                    ? ' на ' + comparativeStats[key][innerKey] + ' задач больше'
                                                    : ' одианковое количество задач'}
                                            </li>
                                        ))}
                                    </ul>
                                </div>
                            </div>
                        ))}
                    </div>
                ) : (
                    <div>Нет данных</div>
                )}
            </div>
        </div>
    );
};

export default StatisticsPage;
