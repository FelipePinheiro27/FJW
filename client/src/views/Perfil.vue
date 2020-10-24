<template>
<div class="img_fundo">
  <div class="container">
        <div class="dados">
            <h1 id="titulo">Perfil do Usuário</h1>
            <img id="img_perfil" src="Imagens/perfil.png" alt="" /> </br>

            <label for="#">Nome:</label> </br>
            <label for="#">Instituição:</label></br>
            <label for="#">Meus Projetos</label></br>
            <label for="#">Ver Favoritos</label></br>
            <a href="">Modificar Dados</a>
        </div>
    </div>
  </div>

</template>


<script>
export default {};
</script>

<style>

.dados {
    padding: 50px 200px 40px; 
}
.container {
  border-radius: 5px;
}

#img_perfil {
  width: 15%;
  margin-top: 5%;
  margin-left: 40%;
  margin-bottom: 5%;
}
</style>