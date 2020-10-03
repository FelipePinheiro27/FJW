<template>
  <div>
    <div>
      <NavBar />
    </div>
    <div>
      <form class="box" action="">
        <br />
        <div class="top_cp container">
          <br />
          <h2 id="logo_cp" class="text-center">Dados do Projeto</h2>
          <br />
        </div>
        <div class="text-left inputs_cp">
          <div class="form-group border_input_cp">
            <label class="" for="title">Título:</label>
            <label for="">EFEITO E SEGURANÇA DE6,7-DIMETOXI-3-NITROCUMARINA (COMPOSTO SEMISSINTÉTICO MODIFICADO A PARTIR
                 DA 6,7- DIMETOXICUMARINA OBTIDA DO CAULE DE Platymiscium floribundum Vog) EM UM MODELO DE PERIODONTITEEM
                  RATAS</label>
          </div>
          <div class="form-group">
            <label>Descrição:</label>
            
            <label for="">
A Periodontite é uma inflamação dos tecidos de suporte dos dentes com perda progressiva da inserção e destruição óssea como
resultado da resposta do hospedeiro à presença de uma microbiota disbiótica. Assim, este estudo teve como objetivo avaliar a
atividade anti-reabsortiva e a segurança da 6,7-dimetoxi-3-nitrocumarina, modificada a partir de 6,7-dimetoxicumarina obtida
do caule de Platymiscium floribundum Vog na periodontite induzida por ligadura em ratas e o envolvimento da via HO-1 em seu
mecanismo de ação.A periodontite foi induzida pela colocação de uma ligadura de fio de náilon estéril (3.0) ao redor dos segundos
molares superiores esquerdos. As ratas receberam  (gavagem oral) uma vez por dia, durante 11 dias 6,7-dimetoxi-3-nitrocumarina
(0,01,0,1 ou 1 mg /kg) ou veículo (solução salina a 0,9%+ etanol a 0,1%).6,7-dimetoxi-3-nitrocumarina (0,1 ou 1 mg /kg)
reduziu a perda óssea alveolar (1,88±0,15;1,05±0,24, respec tivamente),quando comparada ao grupo tratado com veículo
(3,05±0,30).6,7-dimetoxi-3-nitrocumarina (1 mg /kg) reduziu os níveis de RNAm de TNF-ɑ(2,33±0,56) e IL-1β(19,87±2,9), enquanto 
aumentou os níveis de RNAm de HO-1(43,40±1,05) e atividade da catalase (46,42±4,59),quando comparado ao grupo tratado com veículo 
(46,29±8,43;37,83±4,38;1,58±0,11;8,93±1,86,respectivamente). Não foram observadas diferenças estatísticas (P>0,05) nos parâmetros
bioquímicos séricos (creatinina, FAT, ALT, AST) entre os grupos.6,7-dimetoxi-3-nitrocumarina diminuiu a perda óssea inflamatória 
na periodontite induzida por ligaduras em ratas e a ativação da via HO-1 contribui pelo menos parcialmente para seus efeitos
protetores
            </label>
          </div>
          <div class="form-group">
            <label>Palavras Chaves :</label>
            <input
              type="text"
              class="form-control"
              id="palavrasChaves"
              name="palavrasChaves"
              v-model="palavras_chaves"
            />
          </div>
          <div class="form-group">
            <label>Tipo de Projeto:</label>
            <select
              name="projetos"
              id="opc"
              class="form-control"
              v-model="tipo"
            >
              <option value="Projeto de Conclusão de Curso">
                Projeto de Conclusão de Curso
              </option>
              <option value="TCC">TCC</option>
              <option value="BIA">BIA</option>
              <option value="NPDS">NPDS</option>
              <option value="PIBID">PIBID</option>
              <option value="PIBIC">PIBIC</option>
            </select>
          </div>
          <div class="form-group">
            <input class="form-control ficheiro_cp" type="file" id="ficheiro" />
          </div>
        </div>

        <div class="text-center">
          <br /><br />
          <button
            type="button"
            @click="postRegisterProject"
            class="btn butoes_cp btn-primary"
          >
            Cadastrar
          </button>
          <button type="reset" id="limpar_cp" class="btn butoes_cp btn-danger">
            Limpar
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import NavBar from "./NavBar";
export default {
  name: "CadastrarProjeto",
  data: function () {
    return {
      user_id: "4",
      titulo: "",
      descricao: "",
      palavras_chaves: "",
      tipo: "",
      baseURI: "http://localhost:8080/BD/api/projects",
    };
  },
  methods: {
    fetchFuncionariorById: function () {
      let obj = {
        id: this.id,
        name: this.name,
        cargo: this.cargo,
        dataNasc: this.dataNasc,
        dataEmp: this.dataEmp,
      };
      if (this.id != "") {
        this.$http
          .get(this.baseURI + "/" + this.id)
          .then((result) => {
            this.funcionario = result.data;
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        alert("Digite um Id para essa função");
      }
    },
  },
  components: {
    NavBar,
  },
};
</script>

<style>
.titulo_cp {
  width: 95%;
}
.top_cp {
  width: 100%;
  background-color: cornflowerblue;
  color: white;
}
.box {
  background-color: white;
  margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%;
}
.butoes_cp {
  margin-bottom: 2%;
  width: 10%;
}
.inputs_cp {
  margin-left: 1%;
  margin-right: 1%;
}
#limpar_cp {
  margin-left: 1%;
}
#logo_cp {
  padding-top: 1%;
  padding-bottom: 1%;
}
.ficheiro_cp {
  width: 30%;
}
</style>