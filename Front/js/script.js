(function () {

	'use strict'

	var forms = document.querySelectorAll('.needs-validation')

	Array.prototype.slice.call(forms)
		.forEach(function (form) {
			form.addEventListener('submit', function (event) {
				alert(form.value)
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
function postRequest(url, data){
	let request =  new XMLHttpRequest()
	request.open("POST", url, true)

	request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	
	request.send(data)
	return request.responseText;
}
function requestParam(){
	//request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	/*xhr.onload = function () {
    // do something to response
    console.log(this.responseText);
	};*/
	//xhr.send('user=person&pwd=password&organization=place&requiredkey=key');
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
function enviarEndereco(){
	let data = Array.from(document.querySelectorAll('#form-endereco input')).reduce((acc, input) =>({
		...acc,[input.id] : input.value}), {});
	
	data.id = "null";
	data.cliente_id = "1";
	data = JSON.stringify(data);
	
	data = postRequest("http://localhost:8080/endereco/salvar", data);
}
function check_password(){

	var password = document.getElementById('password')

    const UpperCase = /[A-Z]/g;
    const LowerCase = /[a-z]/g;
    const number = /[0-9]/g;
      var validated = 0;
      if (password.length >= 8) {
          validated++;
      }
      if (password.match(number)) {
          validated++;
      }
      if (password.match(UpperCase)) {
          validated++;
      }
      if (password.match(LowerCase)) {
          validated++;
      }
      if (validated == 4) {
            return true;
      }
}
function login(){
	let data = Array.from(document.querySelectorAll('#form-login input')).reduce((acc, input) =>({
		...acc,[input.id] : input.value}), {});

	if(check_password(data.password)){
	data.password = CryptoJS.SHA256(data.password);

	data = JSON.stringify(data);
	response = postRequest("http://localhost:8080/user/login", data);
	
		if(response !== null){

			//response = JSON.parse(response);

			sessionStorage.setItem('username', data.username);
			sessionStorage.setItem('email', response.email);


			window.location.assign("http://localhost:5500/endereco.html")	
		}
   }
}
