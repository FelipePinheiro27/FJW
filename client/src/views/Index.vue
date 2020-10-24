<template>
  <div class="img_fundo">
    <div v-if="logged == false">
      <nav class="navbar navbar-expand-lg bg-dark">
        <router-link to="#">
          <a class="mb-1" id="logo">Plataforma DivPro</a>
        </router-link>
        <router-link to="/Login" id="entrar">
          <a> Entrar</a>
        </router-link>
        <router-link to="/signup">
          <a id="cadastrar"> Registrar</a>
        </router-link>
      </nav>
    </div>
    <div v-if="logged == true">
      <nav class="navbar navbar-expand-lg bg-dark">
        <router-link to="#">
          <a class="mb-1" id="logo">Plataforma DivPro</a>
        </router-link>
        <div id="entrar">
          <a style="color: silver"> {{ login }}</a>
        </div>
        <router-link to="#">
          <a id="cadastrar" @click="logout"> Logout</a>
        </router-link>
      </nav>
    </div>

    <div class="d-flex" id="wrapper">
      <div class="bg-dark">
        <div class="bg-dark" id="sidebar-wrapper">
          <div class="list-group list-group-flush">
            <!-- <router-link to="/">
              <a class="list-group-item list-group-item-action bg-dark">
                <label class="navWords" for="">Home</label>
              </a>
            </router-link> -->
            <div id="meio">
              <router-link to="/cadastrarprojeto">
                <a class="list-group-item list-group-item-action bg-dark">
                  <label class="navWords" for="">Cadastrar Projeto</label>
                </a>
              </router-link>
              <router-link to="/BuscarProjetos">
                <a
                  href="#"
                  class="list-group-item list-group-item-action bg-dark"
                >
                  <label class="navWords" for="">Procurar Projetos</label>
                </a>
              </router-link>

              <a
                href="#"
                class="list-group-item list-group-item-action bg-dark"
              >
                <label class="navWords" for="">Meus Projetos</label>
              </a>
              <a href="#" class="list-group-item list-group-item-action bg-dark"
                ><label class="navWords" for="">Favoritos</label>
              </a>
              <a href="#" class="list-group-item list-group-item-action bg-dark"
                ><label class="navWords" for="">Eventos</label>
              </a>
               <router-link to="/perfil">
                  <a href="#" class="list-group-item list-group-item-action bg-dark"
                    ><label class="navWords" for="">Perfil</label>
                  </a>
              </router-link>
              <router-link to="/projectEdit">
              <a href="#" class="list-group-item list-group-item-action bg-dark"
                ><label class="navWords" for="">Alterar Dados da Conta</label>
              </a>
              </router-link>
            </div>
          </div>
        </div>
      </div>

      <div class="text-left" id="page-content-wrapper">
        <div id="faixa">
          <h4 id="title">
            <b>
              Pesquise por trabalhos e projetos desenvolvidos nas faculdades de
              Crateús
            </b>
          </h4>
        </div>
        <div>
          <div class="form-group inputs_ind">
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  :src="imageUECE"
                  @click="teste"
                  class="form-control faculades_ind d-inline UECE"
                  type="Image"
                  name="UECE"
                />
              </div>
            </router-link>
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  @click="teste"
                  class="form-control faculades_ind d-inline UFC"
                  type="Image"
                  name="UFC"
                  :src="imageUFC"
                />
              </div>
            </router-link>
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  @click="teste"
                  class="form-control faculades_ind d-inline IFCE"
                  type="Image"
                  name="IFCE"
                  :src="imageIFCE"
                />
              </div>
            </router-link>
          </div>
          <div id="espacamento">
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  @click="teste"
                  class="form-control faculades_ind d-inline FPO"
                  type="Image"
                  name="FPO"
                  :src="imageFPO"
                />
              </div>
            </router-link>
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  @click="teste"
                  class="form-control faculades_ind d-inline Unopar"
                  type="Image"
                  name="Unopar"
                  :src="imageUnopar"
                />
              </div>
            </router-link>
            <router-link to="/BuscarProjetos">
              <div class="logos">
                <input
                  @click="teste"
                  class="form-control faculades_ind d-inline IVA"
                  type="Image"
                  name="IVA"
                  :src="imageIVA"
                />
              </div>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
///Mudar depois para o caminho do arquivo para imagens, não sei pq não ta pegando o path relative
//import imageUECE from "./public/Imagens/UECE.png";
import imageUECE from "../../public/Imagens/UECE.png";
import imageIFCE from "../../public/Imagens/IFCE.png";
import imageUFC from "../../public/Imagens/UFC.png";
import imageFPO from "../../public/Imagens/FPO.png";
import imageUnopar from "../../public/Imagens/Unopar.png";
import imageIVA from "../../public/Imagens/IVA.png";

export default {
  name: "Index",

  data() {
    return {
      imageUECE: imageUECE,
      imageUFC: imageUFC,
      imageIFCE: imageIFCE,
      imageFPO: imageFPO,
      imageUnopar: imageUnopar,
      imageIVA: imageIVA,
      logged: false,
      login: "",
      users: [],
      projects: [],
      baseURI: "http://localhost:8080/api/users",
    };
  },
  mounted: function () {
    if (this.$session.exists()) {
      this.logged = true;
    }
  },
  created: function () {
    if(this.$session.exists()){
    var jsonUser = this.$session.get("user");
    var user = JSON.parse(jsonUser);
      this.login = user.login;
    }
  },
  methods: {
    logout: function () {
      this.$session.destroy();
      location.reload();
    },
    //Modelo de função para depois linkar
    teste: function () {},
  },
};
</script>

<style>
#title {
  color: black;
}
.logos {
  width: 30%;
  display: inline-block;
  margin-right: 2%;
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

.faculades_ind {
  width: 100%;
  height: 25%;
  margin: 5px;
  margin-left: 5px;
}
.inputs_ind {
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
#meio {
  text-align: center;
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

#espacamento {
  margin-left: 5%;
  margin-top: 6%;
}

#faixa {
  /* background-color: white; */
  margin-left: 3%;
  margin-right: 3%;
  text-align: center;
  /* margin-top: -7%; */
}
</style>