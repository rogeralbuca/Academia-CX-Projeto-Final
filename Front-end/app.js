const username = sessionStorage.getItem("login") 
if(username){
    document.getElementById("username").value = username;
    
}else{
    location.href= "index.html"
}

async function cepRetorno(){
    const inputValueCep = document.getElementById("cep").value;
    if(inputValueCep !== ""){
        const apiUrl = `http://viacep.com.br/ws/${inputValueCep}/json/`;
        fetch(apiUrl).then(response => {
            response.json().then(teste => {
                document.getElementById("rua").value = teste.logradouro
                document.getElementById("bairro").value = teste.bairro
                document.getElementById("cidade").value = teste.localidade
                document.getElementById("estado").value = teste.uf
            })
        })
    }
}

async function cadastrar(){
    const inputValueCep2 = document.getElementById("cep").value;
    const inputValueNome = document.getElementById("username").value;
    const inputValueRua = document.getElementById("rua").value;
    const inputValueBairro = document.getElementById("bairro").value;
    const inputValueCidade = document.getElementById("cidade").value;
    const inputValueEstado = document.getElementById("estado").value;
    const inputValueNumero = document.getElementById("numero").value;

    fetch("http://localhost:5050/endereco", {method: "POST", headers:{'Content-Type' : 'application/json'}, body: JSON.stringify({
        cep : inputValueCep2,
        cidade :inputValueCidade,
        bairro : inputValueBairro,
        username : inputValueNome,
        numero : inputValueNumero,
        rua : inputValueRua,
        estado : inputValueEstado
    })}).then(alert("Cadastrado com sucesso!"))

}
