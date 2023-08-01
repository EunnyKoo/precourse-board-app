import {createRouter, createWebHistory} from 'vue-router'
import SpringBoard from "@/views/board/SpringBoard.vue"
import NodeBoard from "@/views/board/NodeBoard.vue"
import ReactBoard from "@/views/board/ReactBoard.vue"
import SpringPosts from "@/views/post/SpringPosts.vue";
import NodePosts from "@/views/post/NodePosts.vue";
import ReactPosts from "@/views/post/ReactPosts.vue";
import PostsNew from "@/components/post/PostsNew.vue";
import PostsUpdate from "@/components/post/PostsUpdate.vue";
import PostsDetail from "@/components/post/PostsDetail.vue";
import BoardTable from "@/components/BoardTable.vue";
import BoardMain from "@/views/BoardMain.vue";
import LoginForm from "@/views/auth/LoginForm.vue";
import SignupForm from "@/views/auth/SignupForm.vue";

const routes = [
    {
        path: '/',
        component: BoardMain,
    },
    {
        path: '/login',
        component: LoginForm,
    },
    {
        path: '/signup',
        component: SignupForm,
    },
    {
        path: '/spring',
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