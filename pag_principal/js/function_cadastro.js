function buttonClear(){
    document.getElementById("titulo").value = "";
    document.getElementById("desc").value = "";
    document.getElementById("ficheiro").value = null;
}

function adicionar(){
    var titulo = document.getElementById("titulo").value;
    var desc = document.getElementById("desc").value;
    var file = document.getElementById("ficheiro").value;
    var obj = {titulo:titulo, descricao:desc, ficheiro:file};

    var preenchido = validacao();
    if(preenchido == true){
    var strObj = JSON.stringify(obj);
    localStorage.setItem("Projeto",strObj);
    buttonClear();
}
}

function validacao(){
    if(document.getElementById("titulo").value != "" && document.getElementById("desc").value != ""
    && document.getElementById("ficheiro").value != ""){
        return true;
    }
    else
    alert("Não foi possivel efetuar seu cadastro... Verifique se os campos estão preenchidos!!");
}