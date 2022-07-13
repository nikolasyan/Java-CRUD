<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CRUD Estacionamento</title>
<link rel="icon" href="imagens/iconeParking.png">
<link rel="stylesheet" href="style.css">
<!-- CSS e JS do bootstrap -->
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>Editar dados</h1>
	<form name="frmDados" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="EspacoID" readonly 
value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			
			<tr>
				<td><input type="text" maxlength="50" name="nome"
value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" maxlength="11" name="telefone"
value="<%out.print(request.getAttribute("telefone"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" maxlength="11" name="cpf"
value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" maxlength="50" name="modeloVeiculo"
value="<%out.print(request.getAttribute("modeloVeiculo"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" maxlength="50" name="marcaVeiculo"
value="<%out.print(request.getAttribute("marcaVeiculo"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" maxlength="7" name="placaVeiculo"
value="<%out.print(request.getAttribute("placaVeiculo"));%>"></td>
			</tr>


		</table>
		<input class="btn btn-success" type="button" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>