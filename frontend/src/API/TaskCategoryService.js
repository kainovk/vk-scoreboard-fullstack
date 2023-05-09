import axios from "axios";

const BASE_URL = 'http://localhost:9090/api'

export default class TaskCategoryService {
    static async create(category) {
        await axios.post(BASE_URL + '/categories', category)
        console.log('Категория создана с данными: ' + JSON.stringify(category))
    }

    static async getAll() {
        const response = await axios.get(BASE_URL + '/categories')
        return response.data
    }
}