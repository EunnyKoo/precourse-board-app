const userStore = {
    namespaced: true,
    state: {
        user: {}
    },
    mutations: {
        setUserInfo(state, value) {
            state.user = value;
        },
    },
    getters: {
        getUserInfo(state, getters, rootState) {
            return state.user;
        }
    },
}

export default userStore