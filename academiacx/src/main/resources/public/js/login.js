const loginForm = $("#loginForm");


loginForm.validate({
    rules: {
        username: "required",
        password: "required"
    },

    messages: {
        username: "<b class='inputError'>Por favor insira um username</b>",
        password: "<b class='inputError'>Por favor insira uma senha</b>"
    }
});


loginForm.submit(event => {
    event.preventDefault();

    let username = $("input[name='username']").val();
    let password = $("input[name='password']").val();

    if (!username || !password) {
        return false;
    }

    let requestBody = {
        "username": username,
        "password": password
    };

    $.ajax({
        url: "http://localhost:8080/usuario/login",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(requestBody),
        success: data => window.location.href = `/app.html?username=${data.username}`,
        error: error => $("#bottomError").text(error.responseJSON.titulo)
    });
});