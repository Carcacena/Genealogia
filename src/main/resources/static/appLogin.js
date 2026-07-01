async function logar() {
    const login = document.getElementById("login").value;
	
    const senha = document.getElementById("senha").value;
	const response = await fetch("/auth/login", {
  //  const response = await fetch("http://localhost:8080/auth/login", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },
		
        body: JSON.stringify({
            login: login,
            senha: senha
        })
    });

	if (response.ok) {

	    const token = await response.text();

	    localStorage.setItem("token", token);

	    sessionStorage.setItem("tipo", "0");

	    console.log("TIPO SALVO:");
	    console.log(sessionStorage.getItem("tipo"));

	    window.location.href = "menu.html";

	} else {

	    alert("Login inválido");
	}
	}
