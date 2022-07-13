<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("dadoss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Estacionamento</title>
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
<link rel="icon" href="imagens/iconeParking.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 style="text-align: center;">Estacionamento</h1>
	<h3>Aqui você pode cadastrar, alterar, excluir e visualizar todos
		os clientes do estacionamento.</h3>
	<br>
	<div class="d-grid gap-2 col-6 mx-auto">
		<a class="btn btn-primary" role="button" href="novo.html">Novo
			cadastro</a>
	</div>
	<br>
	<table id="tabela" class="table table-dark table-striped table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>CPF</th>
				<th>Modelo do Veículo</th>
				<th>Marca do Veiculo</th>
				<th>Placa do Veiculo</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getTelefone()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getModeloVeiculo()%></td>
				<td><%=lista.get(i).getMarcaVeiculo()%></td>
				<td><%=lista.get(i).getPlacaVeiculo()%></td>
				<td><a class="btn btn-info" role="button"
					href="select?id=<%=lista.get(i).getId()%>">Editar</a> <a
					class="btn btn-danger" role="button"
					href="javascript: confirmar(<%=lista.get(i).getId()%>)">Excluir</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>