import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Cadastro from '../views/Cadastro.vue'
import CadastroProjeto from '../views/CadastrarProjeto.vue'
import ProcurarProjeto from '../views/ProcurarProjeto.vue'



Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
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
        path: '/ProcurarProjeto',
        name: 'ProcurarProjeto',
        component: ProcurarProjeto
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router