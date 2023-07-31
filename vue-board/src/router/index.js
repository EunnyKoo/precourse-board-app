import { createRouter, createWebHistory } from 'vue-router'
import boardMain from "@/views/BoardMain.vue"
import PostsLayout from "@/views/PostsLayout.vue";
import PostsNew from "@/components/PostsNew.vue";
import PostsDetail from "@/components/PostsDetail.vue";

const routes = [
    {path: '/', component: boardMain},
    {
        path: '/posts',
        component: PostsLayout,
        children: [
            {
                path: 'new',
                component: PostsNew,
            },
            {
                path: ':id',
                name: 'detail',
                component: PostsDetail,
            },
        ],
    },
]

const router = createRouter({
    history: createWebHistory('/app'),
    routes,
})

export {router}