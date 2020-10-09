import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Home2 from "../views/Home2.vue";
import Login from "../views/Login.vue";
import SignUp from "../views/SignUp.vue";
import Users from "../views/Users.vue";
import Index from "../views/Index.vue";
import BuscarProjetos from "../views/BuscarProjetos.vue";
import ShowProject from "../views/ShowProject.vue";


import UserInsert from "../views/UserInsert.vue";
import UserEdit from "../views/UserEdit.vue";
import CadastrarProjeto from "../views/CadastrarProjeto.vue";



Vue.use(VueRouter);

const routes = [{
        path: "*",
        component: Home,
    },
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/index",
        name: "Index",
        component: Index,
    },
    {
        path: "/buscarProjetos",
        name: "BuscarProjetos",
        component: BuscarProjetos
    },
    {
        path: "/showproject",
        name: "showproject",
        component: ShowProject,
    },
    {
        path: "/home2",
        name: "Home2",
        component: Home2,
    },
    {
        path: "/login",
        name: "Login",
        component: Login,
    },
    {
        path: "/signup",
        name: "SignUp",
        component: SignUp,
    },
    {
        path: "/users",
        name: "Users",
        component: Users,
    },
    {
        path: "/users/insert",
        name: "UserInsert",
        component: UserInsert,
    },
    {
        path: "/cadastrarprojeto",
        name: "CadastrarProjeto",
        component: CadastrarProjeto,
    },
    {
        path: "/users/edit/:id",
        name: "UserEdit",
        component: UserEdit,
        props: true,
    },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;