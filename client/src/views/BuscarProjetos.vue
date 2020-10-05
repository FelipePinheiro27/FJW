<template>
  <div>
      
    <div>
        <NavBar/>
    </div>
    <div class="container">
          <div class="top_cp" >
          <br>
          <h2 class="text-center" >
              Projetos desenvolvidos na faculdades de Crateús
          </h2>
        </div>

  
    <div class="left">
  <!-- CODIGO AQUI -->
<p> Digite seu nome:</p>  <input type="text">
    </div>







<br> <br> <br>
        <div class="text-center">
          <div class="btn-buscar">
            <button class="btn btn-primary">Consultar</button>
          </div>
          <div class="btn-limpar">
            <button type="reset" class="btn btn-danger">Limpar</button>
          </div>
        </div>
    </div>



    <div>
       ***** Tabela *****
    </div>
    </div>
</template>

<script>

import NavBar from "./NavBar";
export default {
  name: 'BuscarProjetos',
  components: {
    NavBar,
  },
  data(){
    return{
       }
  },
}
</script>

<style>
.container {
  background-color: white;
}

.left input, p, label{
    float: left;
}

.btn-buscar,
.btn-limpar {
  display: inline-block;
  margin-right: 1%;
  margin-bottom: 2%;
}

</style>