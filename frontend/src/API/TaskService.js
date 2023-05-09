import axios from "axios";

const BASE_URL = 'http://localhost:9090/api'

export default class TaskService {
    static async create(task, categoryId) {
        await axios.post(BASE_URL + '/tasks/' + categoryId, task)
        console.log('Задача создана с данными: ' + JSON.stringify(task) + ' categoryId: ' + categoryId)
    }

    static async getAll() {
        const response = await axios.get(BASE_URL + '/tasks')
        return response.data
    }

    static async getCompletedTasksByUserId(userId) {
        const response = await axios.get(BASE_URL + `/users/${userId}/tasks`)
        return response.data
    }
}