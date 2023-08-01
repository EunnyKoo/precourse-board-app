import axios from "axios";

const URL = {
    ROOT: 'http://localhost:8080/api',
}

export default {
    healthCheck: () => axios.get(`${URL.ROOT}/ping`),
    getTestData: () => axios.get(`${URL.ROOT}/test/board`),
    getSpringBoard: () => axios.get(`${URL.ROOT}/ping`),
}