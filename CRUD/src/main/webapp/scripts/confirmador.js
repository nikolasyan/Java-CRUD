function confirmar (id){
	let resposta = confirm("Confirma a exclusao?")
	if (resposta === true){
		window.location.href = "delete?id=" + id
	}
}