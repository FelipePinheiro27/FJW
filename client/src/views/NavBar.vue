<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <router-link to="/">
        <a class="navbar-brand h3 mb-0" id="home"
          ><h3 class="logo">DivPro</h3></a
        >
      </router-link>
      <div class="collapse navbar-collapse" id="navbarSite">
        <router-link to="/CadastroProjeto">
          <a class="nav-link" style="color: white">Cadastrar Projeto</a>
        </router-link>
        <a class="nav-link" style="color: white" href="#">Procurar Projetos</a>
        <router-link to="/Login" id="first">
          <a class="nav-link" style="color: cornflowerblue"><h6>Entrar</h6></a>
        </router-link>
        <router-link to="/Cadastro">
          <a class="nav-link" style="color: cornflowerblue"
            ><h6>Registrar</h6></a
          >
        </router-link>
      </div>
    </nav>
  </div>
</template>

<script>
export default {};
</script>

<style>
#home {
  margin-left: 10%;
}
#first {
  margin-left: 65%;
}
.logo {
  color: cornflowerblue;
}
</style>