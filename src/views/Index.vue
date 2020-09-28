<template>
  <div>
    <nav class="navbar navbar-expand-lg bg-dark">
      <a class="mb-1" id="logo" href="index.html">Plataforma DivPro</a>
      <a id="entrar" href="login.html"> Entrar</a>
      <a id="cadastrar" href="cadastro.html"> Cadastrar</a>
    </nav>
    <!-- <router-link to="/">Home</router-link> | -->
    <div class="d-flex" id="wrapper">
      <div class="bg-dark">
        <div class="bg-dark" id="sidebar-wrapper">
          <div class="list-group list-group-flush">
            <a
              href="index.html"
              class="list-group-item list-group-item-action bg-dark"
            >
              <label class="navWords" for="">Home</label>
            </a>
            <a
              href="cadastro_entidade.html"
              class="list-group-item list-group-item-action bg-dark"
            >
              <label class="navWords" for="">Cadastrar Projeto</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark">
              <label class="navWords" for="">Procurar Projetos</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark">
              <label class="navWords" for="">Meus Projetos</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark"
              ><label class="navWords" for="">Favoritos</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark"
              ><label class="navWords" for="">Eventos</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark"
              ><label class="navWords" for="">Perfil</label>
            </a>
            <a href="#" class="list-group-item list-group-item-action bg-dark"
              ><label class="navWords" for="">Alterar Dados da Conta</label>
            </a>
          </div>
        </div>
      </div>

      <div class="text-left" id="page-content-wrapper">
        <h3 id="title">
          Pesquise por trabalhos e projetos desenvolvidos nas faculdades
          públicas de Crateús
        </h3>
        <div class="form-group">
          <div class="logos">
            <input
              :src="imageUECE"
              @click="teste"
              class="form-control d-inline UECE"
              type="Image"
              name="UECE"
            />
          </div>
          <div class="logos">
            <input
              @click="teste"
              class="form-control d-inline UFC"
              type="Image"
              name="UFC"
              :src="imageUFC"
            />
          </div>
          <div class="logos">
            <input
              @click="teste"
              class="form-control d-inline IFCE"
              type="Image"
              name="IFCE"
              :src="imageIFCE"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
///Mudar depois para o caminho do arquivo para imagens, não sei pq não ta pegando o path relative
//import imageUECE from "./public/Imagens/UECE.png";
import imageUECE from "./UECE.png";
import imageIFCE from "./IFCE.jpeg";
import imageUFC from "./UFC.png";

export default {
  name: "Index",

  data() {
    return {
      imageUECE: imageUECE,
      imageUFC: imageUFC,
      imageIFCE: imageIFCE,
    };
  },
  methods: {
    //Modelo de função para depois linkar
    teste: function () {
      console.log("Teste");
    },
  },
};
</script>

<style>
#title{
  color: black;
}
.logos {
  width: 30%;
  display: inline-block
}

#entrar {
  margin-left: 80%;
  padding-right: 1%;
}
#logo,
#entrar,
#cadastrar {
  text-align: right;
  color: cornflowerblue;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 19px;
}

.form-control {
  width: 30%;
  height: 25%;
}
.form-group {
  padding-top: 5%;
  padding-left: 5%;
}
h3 {
  padding-top: 5%;
  padding-left: 5%;
  color: white;
}
.navWords {
  color: white;
}
#wrapper {
  overflow-x: hidden;
}

#sidebar-wrapper {
  min-height: 100vh;
  margin-left: -5%;
  -webkit-transition: margin 0.25s ease-out;
  -moz-transition: margin 0.25s ease-out;
  -o-transition: margin 0.25s ease-out;
  transition: margin 0.25s ease-out;
}

#sidebar-wrapper .sidebar-heading {
  padding: 1;
  font-size: 1.2rem;
}

#sidebar-wrapper .list-group {
  width: 15rem;
}

#page-content-wrapper {
  min-width: 100%;
}

#wrapper.toggled #sidebar-wrapper {
  margin-left: 0;
}

#sidebar-wrapper {
  margin-left: 0;
}

#page-content-wrapper {
  min-width: 0;
  width: 100%;
}

#wrapper.toggled #sidebar-wrapper {
  margin-left: -5%;
}
</style>