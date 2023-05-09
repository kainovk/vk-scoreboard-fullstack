import axios from "axios";

const BASE_URL = 'http://localhost:9090/api'

export default class UserService {
    static async create(user) {
        await axios.post(BASE_URL + '/users', user);
        console.log('Пользователь создан с данными: ' + JSON.stringify(user))
    }

    static async getAll() {
        const response = await axios.get(BASE_URL + '/users')
        return response.data
    }
}