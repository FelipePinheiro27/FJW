<template>
  <div class="container">
    <div>
      <nav class="navbar navbar-light" style="background-color: #446088">
        <b style="color: white">TÍTULO: </b>
      </nav>
      <label for="">
        <h4>{{ projeto.titulo }}</h4>
      </label>

      <nav class="navbar navbar-light" style="background-color: #446088">
        <b style="color: white">DESCRIÇÃO: </b>
      </nav>
      <b>
        {{ projeto.descricao }}
      </b>
      <nav class="navbar navbar-light" style="background-color: #446088">
        <b style="color: white">CORPO EM ANEXO: </b>
      </nav>
      BAIXAR ARQUIVO...
      <a
        id="baixar"
        :href="'uploads/user/' + projeto.id + '.pdf'"
        download="pdf"
        >{{ projeto.id }}.pdf</a
      ><br />
      <br />
      <br />
      <br />
      <br />
    </div>
  </div>
  <!-- </div> -->
  <!-- </div> -->
  <!-- </div> -->
</template>

<script>
import NavBar from "./NavBar";

export default {
  components: {
    NavBar,
  },
  data() {
    return {
      id_projeto: "",
      id_user: "",
      nome: "",
      area: "", 
      user: {},
      projeto: {},
      baseURI: "http://localhost:8086/api/projects",
      baseURI2: "http://localhost:8086/api/users",
    };
  },
  created: function () {
    this.id_projeto = localStorage.getItem("id_projeto");

    this.$http
      .get(this.baseURI + "/" + localStorage.getItem("id_projeto"))
      .then((result) => {
        this.projeto = result.data;
        this.id_user = this.projeto.id_user;
        // console.log("Projeto: " + this.projeto);
        // console.log("ID user: " + this.id_user)
      });
    this.$http
      .get(this.baseURI2 + "/" + this.id_user)
      .then((result) => {
        this.user = result.data;
        this.nome = this.user.login;
        this.area = this.user.curso;
        // console.log("user: " + this.user);
      });
  },
  methods: {
    //   postRegisterProject: function () {
    //     this.marcado = true;
    //     let obj = {
    //       user_id: this.user_id,
    //       project_id: this.id_projeto
    //     };
    //     this.$http.post(this.baseURI3, obj).then((result) => {
    //       this.favoritos = result.data;
    //       this.id_favorito = this.favoritos.id;
    //       alert("Dentro do post: " + this.id_favorito);
    //     });
    // },
    // deleteProjectById: function (resul) {
    //   alert("Resul: " + resul);
    //   this.$http.delete(this.baseURI3 + "/" + resul).then((result) => {
    //     this.marcado = false;
    //     location.reload();
    //   });
    // }
  },
};
</script>

<style>
.info b {
  float: left;
}
template {
  background-color: white;
}
.navbar navbar-light {
  text-emphasis-color: white;
  text-align: left;
}

#last {
  margin-bottom: 5%;
}
