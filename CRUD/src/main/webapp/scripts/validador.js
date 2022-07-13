/**
 * estarei utilizando o javascript para realizar a validação dos dados no formulario
 * antes de serem enviados ao banco de dados
 */

function validar() {
	let nome = frmDados.nome.value
	let telefone = frmDados.telefone.value
	let cpf = frmDados.cpf.value
	let modeloVeiculo = frmDados.modeloVeiculo.value
	let marcaVeiculo = frmDados.marcaVeiculo.value
	let placaVeiculo = frmDados.placaVeiculo.value

	if (nome === "") {
		alert('Preencha o campo nome')
		frmDados.nome.focus()
		return false
	} else if (telefone === "") {
		alert('Preencha o campo telefone')
		frmDados.telefone.focus()
		return false
	} else if (cpf === "") {
		alert('Preencha o campo cpf')
		frmDados.cpf.focus()
		return false
	} else if (modeloVeiculo === "") {
		alert('Preencha o campo Modelo do Veiculo')
		frmDados.modeloVeiculo.focus()
		return false
	} else if (marcaVeiculo === "") {
		alert('Preencha o campo marca do veiculo')
		frmDados.marcaVeiculo.focus()
		return false
	} else if (placaVeiculo === "") {
		alert('Preencha o campo placa do veiculo')
		frmDados.placaVeiculo.focus()
		return false
	} else {
		document.forms["frmDados"].submit()
	}

}
