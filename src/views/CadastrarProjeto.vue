<template>
  <div>
    <nav class="navbar navbar-expand-lg bg-dark">
      <a class="mb-1" id="logo" href="index.html">Plataforma DivPro</a>
      <a id="entrar" href="login.html"> Entrar</a>
      <a id="cadastrar" href="cadastro.html"> Cadastrar</a>
    </nav>
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

      <div class=" allInfo text-left" id="page-content-wrapper">
        <div class="container bg-dark putInfo">
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
</template>

<script>
export default {};
</script>

<style>
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