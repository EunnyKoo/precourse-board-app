import Axios from "axios";

const URL = {
    ROOT: 'http://localhost:8080/api',
}

const axios = Axios.create({
    baseURL: URL.ROOT,
    timeout: 1000,
    headers: {'Content-Type': 'application/json'}
});
axios.interceptors.request.use(
    function (config) {
        return config
    },
    function (error) {
        return Promise.reject(error)
    }
);
axios.interceptors.response.use(
    function (response) {
        console.log(response)
        return response
    },
    function (error) {
        return Promise.reject(error)
    }
);

export default {
    healthCheck: () => axios.get(`/ping`),
    getBoard: (type) => axios.get(`/${type}/board`),
    getPost: (param, type) => axios.get(`/${type}/board/${param}`),
    savePost: (payload, type) => axios.post(`/${type}/board`, payload),
    updatePost: (param, payload, type) => axios.put(`/${type}/board/${param}`, payload),
    deletePost: (param, type) => axios.delete(`/${type}/board/${param}`),
}