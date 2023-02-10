(function () {
	'use strict'

	var forms = document.querySelectorAll('.needs-validation')

	Array.prototype.slice.call(forms)
		.forEach(function (form) {
			form.addEventListener('submit', function (event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})
})()
function getRequest(url){
	let request =  new XMLHttpRequest()
	request.open("GET",url, false)
	request.send()
	return request.responseText;
}
function preencherEndereco(endereco){
	cep = document.getElementById("cep");
	logradouro = document.getElementById("logradouro")
	numero =  document.getElementById("numero")
	bairro = document.getElementById("bairro")
	cidade = document.getElementById("cidade")
	uf = document.getElementById("uf")

	logradouro.value = endereco.logradouro
	
	bairro.value = endereco.bairro
	cidade.value = endereco.localidade
	uf.value = endereco.uf

	const finalAddress = logradouro.value +','+ bairro.value +','+ cidade.value +','+uf.value+','+cep.value;

	encontrarGeolocation(finalAddress);
}
function encontrarGeolocation(address){
	geocoder = new google.maps.Geocoder();
	var latlng = new google.maps.LatLng(-34.397, 150.644);
	var mapOptions = {
	zoom: 15,
	center: latlng
	}
	map = new google.maps.Map(document.getElementById('map'), mapOptions);


	geocoder.geocode( { 'address': address}, function(results, status) {
	if (status == 'OK') {
		map.setCenter(results[0].geometry.location);
		var marker = new google.maps.Marker({
					map: map,
					position: results[0].geometry.location
			});
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}
function encontrarCep(){
	let cep  = document.getElementById('cep').value;

	data = getRequest("http://localhost:8080/cep/" + cep)

	endereco = JSON.parse(data);

	preencherEndereco(endereco);
}
async function enviarEndereco(){
	let data = Array.from(document.querySelectorAll('#form-endereco input')).reduce((acc, input) =>({
		...acc,[input.id] : input.value}), {});
	
	user = JSON.parse(sessionStorage.getItem("user"))
	data.id = "null";
	data.user_id = user.id;
	data = JSON.stringify(data);
	
	try {
		const response = await fetch('http://localhost:8080/endereco/salvar', {
		  method: 'POST',
		  body: data,
		  headers:{
			'Content-type': 'application/json;charset=UTF-8'
		  }
		});
		const address = await response.json();

		if(address.sucess === true){
			window.location.reload();	
		}
   }
   catch (error) {
    console.error(error);
  }
}
function check_password(password){
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/;
    if (password.length >= 8 && regex.test(password)) {
        return true;
    }
}
async function login(){
	let data = Array.from(document.querySelectorAll('#form-login input')).reduce((acc, input) =>({
		...acc,[input.id] : input.value}), {});

	let password = data.password;

	if(check_password(password)){
	data = JSON.stringify(data);
			try {
				const response =  await fetch('http://localhost:8080/user/login', {
				method: 'POST',
				body: data,
				headers:{
					'Content-type': 'application/json;charset=UTF-8'
				}
				});
				const user =  await response.json();

				if(response.status === 200){
					sessionStorage.setItem("accepted", true)
					sessionStorage.setItem("user",JSON.stringify(user));
					window.location.assign("http://localhost:63342/endereco.html")
				}else{
					alert("Usuario não encontrado");
				}
		}
		catch (error) {
			console.error(error);
		}
	}
	else{
		var alert = document.getElementById("alert");
		alert.classList.remove("collapse");
	}
}
async function cadastrar(){
	let data = Array.from(document.querySelectorAll('#form-cadastro input')).reduce((acc, input) =>({
		...acc,[input.id] : input.value}), {});
	let password = data.password;

	data = JSON.stringify(data);
	if(check_password(password)){
		try {
			const response = await fetch('http://localhost:8080/user/salvar', {
			method: 'POST',
			mode: "cors",
			body: data,
			headers:{
				'Content-type': 'application/json;charset=UTF-8'
			}
			});
			const user = await response.json();
			if(response.status === 200){
				sessionStorage.setItem("accepted", true)
				sessionStorage.setItem("user",JSON.stringify(user));
				window.location.assign("http://localhost:63342/endereco.html")
			}
			else{
				window.location.reload()
			}
	}
	catch (error) {
		console.error(error);
	}
  }
  else{
	var ins = document.getElementById("instrucoes");
	var alert = document.getElementById("alert");
	ins.classList.add("collapse")
	alert.classList.remove("collapse");
  }
}
function logout(){
	sessionStorage.removeItem("user");
	sessionStorage.setItem("accepted", undefined)
	window.location.assign("http://localhost:63342/login.html")
}