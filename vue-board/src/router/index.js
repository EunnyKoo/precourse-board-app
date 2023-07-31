import {createRouter, createWebHistory} from 'vue-router'
import SpringBoard from "@/views/SpringBoard.vue"
import NodeBoard from "@/views/NodeBoard.vue"
import ReactBoard from "@/views/ReactBoard.vue"
import SpringPostsLayout from "@/views/SpringPostsLayout.vue";
import NodePostsLayout from "@/views/NodePostsLayout.vue";
import ReactPostsLayout from "@/views/ReactPostsLayout.vue";
import PostsNew from "@/components/PostsNew.vue";
import PostsDetail from "@/components/PostsDetail.vue";

const routes = [
    {path: '/', component: SpringBoard, meta: {type: 'spring'}},
    {path: '/node', component: NodeBoard, meta: {type: 'node'}},
    {path: '/react', component: ReactBoard, meta: {type: 'react'}},
    {
        path: '/spring/posts',
        component: SpringPostsLayout,
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'spring'}
            },
            {
                path: ':id',
                name: 'detail',
                component: PostsDetail,
                meta: {type: 'spring'}
            },
        ],
    },
    {
        path: '/node/posts',
        component: NodePostsLayout,
        meta: {type: 'node'},
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'node'}
            },
            {
                path: ':id',
                name: 'detail',
                component: PostsDetail,
                meta: {type: 'node'}
            },
        ],
    },
    {
        path: '/react/posts',
        component: ReactPostsLayout,
        meta: {type: 'react'},
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'react'}
            },
            {
                path: ':id',
                name: 'detail',
                component: PostsDetail,
                meta: {type: 'react'}
            },
        ],
    },
]

const router = createRouter({
    history: createWebHistory('/app'),
    routes,
})

export {router}