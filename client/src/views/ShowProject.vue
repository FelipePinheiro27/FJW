<template>
  <div class="box">
    <div >
        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">INFORMAÇÕES DO PROJETO:</b>
        </nav>
        <div v-for="projeto in projects" :key="projeto.id" >
          <div v-for="user in users" :key="user.id">
            <div v-if="user.id == projeto.user_id && projeto.id == id_projeto">
        <b>Autor: {{user.login}} </b><br>
        <b>palavras_chaves:{{projeto.palavras_chaves}}</b> <br>
        <b>Área do Projeto:{{user.curso}}</b>

        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">TÍTULO: </b>
        </nav>
        <label for="">
          {{projeto.titulo}}
        </label>
        

        <nav class="navbar navbar-light" style=" background-color: #446088;">
                <b style="color: white">DESCRIÇÃO:</b>
        </nav>
          <label for="">
            {{projeto.descricao}}
            </label>
        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">CORPO EM ANEXO:</b>
        </nav>
        BAIXAR ARQUIVO..
        </div>
        </div>
    </div>
    </div>
  </div>
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
      users: [],
      projects: [],
      baseURI: "http://localhost:8085/BD/api/projects",
      baseURI2: "http://localhost:8085/BD/api/users"
    };
  },
    created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
            console.log(this.projects)
    });
    this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      console.log(this.users)
    });
    var strObj = localStorage.getItem("id_projeto");

    var myObj = JSON.parse(strObj); 
    this.id_projeto = myObj.id_projeto
},
  get: function (){
    var strObj = localStorage.getItem("id_projeto");

    var myObj = JSON.parse(strObj); 
    console.log(myObj.id_projeto)
    return myObj.id_projeto
},
methods:{

}

};  
</script>

<style>
.info b{
  float: left;
}
.box {
  background-color: white;
  /* margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%; */
}
.navbar navbar-light{
    text-emphasis-color: white;
    text-align: left;
}
