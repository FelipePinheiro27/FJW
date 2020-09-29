<template>

  <!-- <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand h1 mb-0" href="index.html">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSite">
                <a class="nav-link" style="color: darkgray;" href="">Cadastrar Projeto</a>
                <a class="nav-link" style="color: darkgray;" href="#">Visualizar Projetos</a>
            </div>
        </nav>
    </div> -->

  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <router-link to="/Index">
      <a class="navbar-brand h3 mb-0" id="home"><h3>DivPro</h3></a>
      </router-link>
      <div class="collapse navbar-collapse" id="navbarSite">
        <router-link to="/CadastroProjeto">
                <a class="nav-link" style="color: white">Cadastrar Projeto</a>
        </router-link>
                <a class="nav-link" style="color: white;" href="#">Visualizar Projetos</a>
                <router-link to="/Login" id="first">
                <a class="nav-link" style="color: cornflowerblue"><h6>Entrar</h6></a>
                </router-link>
                <router-link to="/Cadastro">
                <a class="nav-link" style="color: cornflowerblue"><h6>Registrar</h6></a>
                </router-link>
          </div>
      <!-- <a class="mb-1" id="logo" href="index.html">Plataforma DivPro</a> -->
    </nav>
    <div class="alinhamento">
    <div class="d-flex" id="wrapper">


      <!-- <div class="bg-dark">
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
      </div> -->

      <div class=" allInfo text-left" id="page-content-wrapper">
        <div class="xx">
          <div>
            <h2 class="text-center top">Cadastrar Projeto</h2>
          </div>
          <form action="/action_page.php">
            <div class="form-group">
              <label for="title">Título:</label>
              <input type="text" class="form-control" id="titulo" />
            </div>
            <div class="form-group">
              <label>Descrição:</label>
              <textarea class="form-control" id="desc"></textarea>
            </div>
            <div class="form-group">
              <label>Palavras Chaves :</label>
              <input type="text" class="form-control" id="pChaves" />
            </div>
            <div class="form-group">
              <label>Tipo de Projeto:</label>
              <select name="projetos" id="opc" class="form-control">
                <option value="ext">Projeto de Extensão</option>
                <option value="TCC">TCC</option>
                <option value="BIA">BIA</option>
                <option value="BIA">NPDS</option>
                <option value="BIA">PIBID</option>
                <option value="BIA">PIBIC</option>
              </select>
            </div>
            <div class="form-group">
              <input type="file" id="ficheiro" />
            </div>
            <div class=" text-center submit">
              <button
                type="button"
                class="btn btn-primary"
                onclick="adicionar()"
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>

#first{
  margin-left: 55%;
}

#home h3{
  color: cornflowerblue;
}

.top {
  color:cornflowerblue;
}
.putInfo {
  color: white;
  padding-top: 5%;
}
.allInfo{
      padding-top: 2%;
}
.form-control{
    width: 90%;
}

button{
  margin-bottom: 2%;
}

.alinhamento{
  background-color: white;
  margin-top: 3%;
  margin-bottom: 3%;
  margin-left: 5%;
  margin-right: 5%;
}
/* .home img{
 cursor: pointer;
}
.cabecalho{
    margin-top: 5%;
    margin-left: 10%;
    color: crimson;
}

.container{
    margin-top: 50px;
    margin-bottom: 50px;
    height: 800px;
    background-color: white;
}
.container label{
    margin-top: 40px;
}
#desc{
    height: 80px;
    max-height: 140px;
}
#ficheiro{
    margin-top: 40px;
}
.submit{
    float: right;
    margin-top: 40px;
}

#opc{
    width: 20%;
} */
</style>