import {createStore} from "vuex"
import createPersistedState from "vuex-persistedstate"
import userStore from "./modules/userStore";

const store = createStore({
    modules: {
        userStore,
    },
    plugins : [ createPersistedState({
        paths: ['userStore'],
        storage: {
            getItem(key) {
                console.log(key)
                if(key === 'vuex') {
                    const user = window.localStorage.getItem('user');
                    if(user !== '' && user !== null && user !== undefined) {
                        userStore.state.user = JSON.parse(user)
                    }
                }
            },
            setItem(key, value) {
                const user = JSON.parse(value);
                if(key === 'vuex') {
                    window.localStorage.setItem('user', JSON.stringify(user.userStore.user))
                }
            },
            removeItem(key) {
            },
        }
    })
    ],
})

export default store
