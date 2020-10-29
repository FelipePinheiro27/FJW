import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Projects from "../views/Projects.vue";
import ProjectEdit from "../views/ProjectEdit.vue";
import Login from "../views/Login.vue";
import SignUp from "../views/SignUp.vue";
import Users from "../views/Users.vue";
import Index from "../views/Index.vue";
import MeusProjetos from "../views/MeusProjetos"
import BuscarProjetos from "../views/BuscarProjetos.vue";
import ShowProject from "../views/ShowProject.vue";
import Perfil from "../views/Perfil.vue";
import Favoritos from "../views/Favoritos.vue";
import BuscarProjetosUECE from "../views/BuscarProjetosUECE.vue"
import BuscarProjetosUFC from "../views/BuscarProjetosUFC.vue"
import BuscarProjetosIFCE from "../views/BuscarProjetosIFCE.vue"
import BuscarProjetosFPO from "../views/BuscarProjetosFPO.vue"
import BuscarProjetosIVA from "../views/BuscarProjetosIVA.vue"
import BuscarProjetosUNOPAR from "../views/BuscarProjetosUNOPAR.vue"






import UserInsert from "../views/UserInsert.vue";
import UserEdit from "../views/UserEdit.vue";
import CadastrarProjeto from "../views/CadastrarProjeto.vue";



Vue.use(VueRouter);

const routes = [{
        path: "*",
        component: Index,
    },
    {
        path: "/",
        name: "Index",
        component: Index,
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
        path: "/BuscarProjetosUECE",
        name: "BuscarProjetosUECE",
        component: BuscarProjetosUECE
    },
    {
        path: "/BuscarProjetosUFC",
        name: "BuscarProjetosUFC",
        component: BuscarProjetosUFC
    },
    {
        path: "/BuscarProjetosIFCE",
        name: "BuscarProjetosIFCE",
        component: BuscarProjetosIFCE
    },
    {
        path: "/BuscarProjetosFPO",
        name: "BuscarProjetosFPO",
        component: BuscarProjetosFPO
    },
    {
        path: "/BuscarProjetosIVA",
        name: "BuscarProjetosIVA",
        component: BuscarProjetosIVA
    },
    {
        path: "/BuscarProjetosUNOPAR",
        name: "BuscarProjetosUNOPAR",
        component: BuscarProjetosUNOPAR
    },
    {
        path: "/showproject",
        name: "showproject",
        component: ShowProject,
    },
    {
        path: "/meusprojetos",
        name: "Meusprojetos",
        component: MeusProjetos,
    },
    {
        path: "/projects",
        name: "Projects",
        component: Projects,
    },
    {
        path: "/projectEdit",
        name: "ProjectEdit",
        component: ProjectEdit,
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
        path: "/perfil",
        name: "Perfil",
        component: Perfil,
    },
    {
        path: "/favoritos",
        name: "Favoritos",
        component: Favoritos,
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