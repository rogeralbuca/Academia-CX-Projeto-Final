const inputUsername = document.getElementById("username");
const inputPassword = document.getElementById("password");
const btn = document.getElementById("btn");
const erroLogin = document.querySelector("#erro-login");

    btn.addEventListener("click", login);

    function login(e) {
        e.preventDefault();

        const username = inputUsername.value;
        const password = inputPassword.value;

        buscaUsuario(username, password);

        if (username === "" || password === "") {
            erroLogin.innerText = "Necessário informar username e senha";
        }else
            {
                window.location.href = `http://localhost:8090/address/app?username=${username}`
            }
        }

        function buscaUsuario(username, password) {
            fetch(`http://localhost:8090/user`)
                .then((response) => response.text())
                .then((username) => {
                    document.getElementById("nome").value = username;
                });
        }




