import {createRouter, createWebHistory} from 'vue-router'
import SpringBoard from "@/views/SpringBoard.vue"
import NodeBoard from "@/views/NodeBoard.vue"
import ReactBoard from "@/views/ReactBoard.vue"
import SpringPosts from "@/views/SpringPosts.vue";
import NodePosts from "@/views/NodePosts.vue";
import ReactPosts from "@/views/ReactPosts.vue";
import PostsNew from "@/components/PostsNew.vue";
import PostsUpdate from "@/components/PostsUpdate.vue";
import PostsDetail from "@/components/PostsDetail.vue";
import BoardTable from "@/components/BoardTable.vue";

const routes = [
    {
        path: '/',
        component: SpringBoard,
        children: [
            {
                path: '',
                name: 'springBoard',
                component: BoardTable,
                meta: {type: 'spring'}
            },
        ],
    },
    {
        path: '/node',
        component: NodeBoard,
        children: [
            {
                path: '',
                name: 'nodeBoard',
                component: BoardTable,
                meta: {type: 'node'}
            },
        ],
    },
    {
        path: '/react',
        component: ReactBoard,
        children: [
            {
                path: '',
                name: 'reactBoard',
                component: BoardTable,
                meta: {type: 'react'}
            },
        ],
    },
    {
        path: '/spring/posts',
        component: SpringPosts,
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'spring'}
            },
            {
                path: ':id',
                name: 'springDetail',
                component: PostsDetail,
                meta: {type: 'spring'}
            },
            {
                path: ':id',
                name: 'springUpdate',
                component: PostsUpdate,
                meta: {type: 'spring'}
            },
        ],
    },
    {
        path: '/node/posts',
        component: NodePosts,
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'node'}
            },
            {
                path: ':id',
                name: 'nodeDetail',
                component: PostsDetail,
                meta: {type: 'node'}
            },
            {
                path: ':id',
                name: 'nodeUpdate',
                component: PostsUpdate,
                meta: {type: 'node'}
            },
        ],
    },
    {
        path: '/react/posts',
        component: ReactPosts,
        children: [
            {
                path: 'new',
                component: PostsNew,
                meta: {type: 'react'}
            },
            {
                path: ':id',
                name: 'reactDetail',
                component: PostsDetail,
                meta: {type: 'react'}
            },
            {
                path: ':id',
                name: 'reactUpdate',
                component: PostsUpdate,
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