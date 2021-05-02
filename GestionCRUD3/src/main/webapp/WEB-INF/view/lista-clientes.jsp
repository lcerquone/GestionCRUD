<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>Hemos llegado a la lista de futuros clientes!!!</h1>

	<br>

	<table>

		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Modificar</th>
			<th>Eliminar</th>
		</tr>

		<c:forEach var="clienteTemp" items="${clientes }">
			<!-- Link para actualizar -->
			<c:url var="linkActualizar" value="/cliente/formularioActualizar">
				<c:param name="clienteId" value="${clienteTemp.id}"></c:param>
			</c:url>
			<!-- Link para eliminar -->
			<c:url var="linkEliminar" value="/cliente/eliminar">
				<c:param name="clienteId" value="${clienteTemp.id}"></c:param>
			</c:url>
			<tr>
				<td>${clienteTemp.id }</td>
				<td>${clienteTemp.nombre }</td>
				<td>${clienteTemp.apellido }</td>
				<td>${clienteTemp.email }</td>
				<td><a href="${linkActualizar }"><input type="button"
						value="Modificar"></a></td>
				<td><a href="${linkEliminar }"><input type="button"
						value="Eliminar" onclick="if(!(confirm('Vas a eliminar el registro seleccionado. ¿Estás seguro?'))) return false"></a></td>
			</tr>

		</c:forEach>

	</table>

	<br />
	<input type="button" value="Agregar Cliente"
		onclick="window.location.href='formularioAgregar'; return false;" id="button1" />

</body>
</html>