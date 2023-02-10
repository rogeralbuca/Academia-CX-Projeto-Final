function checkCredenciais() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const credenciaisValidas1 = (username === "Roger" && password === "senha123");
    const credenciaisValidas2 = (username === "User" && password === "teste");
    
    if (credenciaisValidas1 || credenciaisValidas2) {
      sessionStorage.clear()
      sessionStorage.setItem("login", `${username}`)
      location.href = "app.html"
    } else {
      alert("Nome ou senha incorreto");
    }
  }
  