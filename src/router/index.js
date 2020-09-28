import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Index from '../views/Index.vue'
import Login from '../views/Login.vue'
import Cadastro from '../views/Cadastro.vue'
import CadastroProjeto from '../views/CadastrarProjeto.vue'



Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/Index',
        name: 'Index',
        component: Index
    },
    {
        path: '/Login',
        name: 'Login',
        component: Login
    },
    {
        path: '/Cadastro',
        name: 'Cadastro',
        component: Cadastro
    },
    {
        path: '/CadastroProjeto',
        name: 'CadastroProjeto',
        component: CadastroProjeto
    },
    {
        path: '/about',
        name: 'About',
        component: function() {
            return import ( /* webpackChunkName: "about" */ '../views/About.vue')
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router