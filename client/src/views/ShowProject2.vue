<template>
  <div class="container" >
    <div >
             
        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">INFORMAÇÕES DO PROJETO:</b>
        </nav>
        <div v-for="projeto in projects" :key="projeto.id" >
          <div v-for="user in users" :key="user.id">
            <div v-if="user.id == projeto.user_id && projeto.id == id_projeto">
        <b>Autor: {{user.login}} </b><br>
        <b>palavras_chaves: {{projeto.palavras_chaves}}</b> <br>
        <b>Área do Projeto: {{user.curso}}</b>

        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">TÍTULO: </b>
        </nav>
        <label for="">
         <h4>  {{projeto.titulo}}</h4>
        </label>
        

        <nav class="navbar navbar-light" style=" background-color: #446088;">
                <b style="color: white">DESCRIÇÃO: </b>
        </nav>
        <b>
            {{projeto.descricao}}
            </b>
        <nav class="navbar navbar-light" style="background-color: #446088;">
                <b style="color: white">CORPO EM ANEXO: </b>
        </nav>
        BAIXAR ARQUIVO... 
         <a id="baixar" :href="'uploads/user/'+projeto.id + '.pdf'" download="pdf">{{projeto.id}}.pdf</a><br>
        <br> <br> <br> <br>

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
      users: [],
      projects: [],
      baseURI: "http://localhost:8086/api/projects",
      baseURI2: "http://localhost:8086/api/users",
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
methods:{
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
}

};  
</script>

<style>
.info b{
  float: left;
}
template {
    background-color: white;
}
.navbar navbar-light{
    text-emphasis-color: white;
    text-align: left;
}

#last{
  margin-bottom: 5%;
}