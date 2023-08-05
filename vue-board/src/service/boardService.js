import Axios from "axios";
import Cookies from 'js-cookie';

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
        const accessToken = Cookies.get('accessToken')
        if(accessToken !== undefined) config.headers.Authorization = accessToken;
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
    // axios.defaults.headers.common['Access-Token']
    healthCheck: () => axios.get(`/ping`),
    getBoard: (type) => axios.get(`/${type}/board`),
    getPost: (param, type) => axios.get(`/${type}/board/${param}`),
    savePost: (payload, type) => axios.post(`/${type}/board`, payload),
    updatePost: (param, payload, type) => axios.put(`/${type}/board/${param}`, payload),
    deletePost: (param, type) => axios.delete(`/${type}/board/${param}`),

    login: (param) => axios.post(`/auth/login`, param),
    signup: (param) => axios.post(`/auth/signup`, param)
}