import axios from "axios";

const BASE_URL = 'http://localhost:9090/api'

export default class UserStatisticsService {
    static async getPersonalStatsByUserId(userId) {
        const response = await axios.get(BASE_URL + `/users/${userId}/rating/personal`)
        return response.data
    }

    static async getComparativeStatsByUserId(userId) {
        const response = await axios.get(BASE_URL + `/users/${userId}/rating/compare`)
        return response.data
    }
}