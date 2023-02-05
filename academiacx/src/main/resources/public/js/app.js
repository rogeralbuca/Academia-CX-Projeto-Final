const enderecoForm = $("#enderecoForm");

$(document).ready(() => {
    const currentUrlParams = new URLSearchParams(window.location.search);
    const username = currentUrlParams.get("username");
    const url = document.querySelector('.cadastro');
    url.href = `app.html?username=${username}`;
    $("input[name='nome']").val(username);
});


const validateNumber = numero => numero.match(/[Nn]?\.?\s?º?\s?\d+/);

const validateCep = value => {
    let uf = document.getElementById("uf");

    getEndereco();

    return uf.value.length !== 0;
}


const cepMask = cepField => {
    let text = cepField.value;

    if (isNaN(text[text.length-1])) {
        cepField.value = text.substring(0, text.length - 1);
        return;
    }

    cepField.setAttribute("maxlength", "9");
    if (text.length === 5) cepField.value += "-";
    if (text.length === 6 && text[5] !== "-") cepField.value = text.substring(0, 5) + "-" + text.substring(5, 6);
    if (text.length === 9) getEndereco();
}


const getEndereco = () => {

    let cep = $("#cep");
    let url = "http://viacep.com.br/ws/" + cep.val() + "/json/";

    let logradouro = $("#logradouro");
    let bairro = $("#bairro");
    let cidade = $("#cidade");
    let uf = $("#uf");

    if (!cep.val().match(/\d{5}-\d{3}/)) {
        logradouro.val("");
        bairro.val("");
        uf.val("");
        cidade.val("");
        return;
    }

    fetch(url, {method: 'GET'})
        .then(response => {
            response.json()
                .then(data => {
                    if (!data.logradouro || !data.bairro || !data.uf || !data.localidade) {
                        logradouro.val("");
                        bairro.val("");
                        uf.val("");
                        cidade.val("");
                        return;
                    }
                    logradouro.val(data.logradouro);
                    bairro.val(data.bairro);
                    uf.val(data.uf);
                    cidade.val(data.localidade);
                });
        });
}



enderecoForm.validate({
    rules: {
        numero: {
            required: true,
            numeroValido: true
        },

        cep: {
            required: true,
            cepValido: true
        }
    },

    messages: {
        numero: {
            required: "<b style='color: red'>Por favor insira um número</b>",
            numeroValido: "<b style='color: red'>Por favor insira um número válido</b>"
        },

        cep: {
            required: "<b style='color: red'>Por favor insira um CEP</b>",
            cepValido: "<b style='color: red'>Por favor insira um CEP válido</b>"
        }
    }
});


enderecoForm.submit(event => {
    event.preventDefault();

    let cep = $("#cep").val();
    let nome = $("#nome").val();
    let rua = $("#logradouro").val();
    let bairro = $("#bairro").val();
    let cidade = $("#cidade").val();
    let estado = $("#uf").val();
    let numero = $("#numero").val();

    if (!cep || !rua || !bairro || !cidade || !estado || !numero) {
        return false;
    }

    let requestBody = {
        "cep": cep,
        "logradouro": rua,
        "bairro": bairro,
        "cidade": cidade,
        "uf": estado,
        "numero": numero,
        "usuario": {
            "username": nome
        }
    };

    $.ajax({
        url: "http://localhost:8080/endereco/inserir",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(requestBody),
        success: data => {
            let parametros = `${data.logradouro},+${data.numero},+${data.bairro},+${data.cidade},+${data.uf}`;
            let link = `https://www.google.com/maps/search/?api=1&query=${parametros}`;
            $("#bottomError").text("");
            $("#bottomSuccess").html(`Endereço adicionado com sucesso! <a href="${link}" target="_blank">ver no Google Maps</a>`)
        },
        error: error => {
            $("#bottomError").text(error.responseJSON.titulo);
            $("#bottomSuccess").text("");
        }
    });
});

