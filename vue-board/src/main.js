import {createApp} from 'vue'
import App from './App.vue'
import {router} from "@/router";
import axios from 'axios';

// Vuetify
import 'vuetify/styles'
import '@mdi/font/css/materialdesignicons.css'
import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as labsComponents from 'vuetify/labs/components'
import * as directives from 'vuetify/directives'

const vuetify = createVuetify({
    components: {
        ...components,
        ...labsComponents,
    },
    directives,
    theme: {
        defaultTheme: 'dark'
    }
})

const app = createApp(App)

app.config.globalProperties.axios = axios;

app.use(router).use(vuetify).mount('#app')
