<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Conta</title>

<script src="resources/js/jquery.min.js"></script>

<script type="text/javascript">

function deuCerto(id, dadosDaReposta) {
  console.log("id = " + id);
  //alert("Conta paga com sucesso");
  $("#conta_" + id).html("Paga");
  $("#conta_paga").html("");
}

function pagaAgora(id) {
  $.post("pagaConta?id=" + id, deuCerto(id));  
}

</script>

</head>
<body>
  <table>
    <tr>
      <th>Código</th>
      <th>Descrição</th>
      <th>Valor</th>
      <th>Tipo</th>
      <th>Paga?</th>
      <th>Data de Pagamento</th>
    </tr>

    <c:forEach items="${contas}" var="conta">
      <tr>
        <td>${conta.id}</td>
        <td>${conta.descricao}</td>
        <td>${conta.valor}</td>
        <td>${conta.tipo}</td>
        <c:if test="${conta.paga eq true}">
          <td id="conta_${conta.id}">Conta paga</td>
        </c:if>
        <c:if test="${conta.paga eq false}">
          <td id="conta_${conta.id}">Conta não paga</td>
        </c:if>
        <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" /></td>
        <td><a href="removeConta?id=${conta.id}">Deletar</a> | </td>
        <td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
        <c:if test="${conta.paga eq false}">
          <td id="conta_paga"><a href="#" onClick="pagaAgora(${conta.id})"> | Pagar </a></td>
        </c:if>
      </tr>
    </c:forEach>

  </table>
</body>
</html>