<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
  <h3>Alterar Conta</h3>
  <form action="alteraConta" method="post">
    Descrição: <br />
    <textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea>
    <br /> Valor: <br /> <input type="text" name="valor" value="${conta.valor}" /> Tipo: <br /> <select name="tipo">
      <option value="ENTRADA" ${conta.tipo=='ENTRADA' ? 'selected':''}>Entrada</option>
      <option value="SAIDA" ${conta.tipo=='SAIDA' ? 'selected':''}>Saída</option>
    </select> <br /> Pago? <input type="checkbox" name="paga" ${conta.paga?'checked':''} /> <br /> Data de Pagamento: <input
      type="text" name="dataPagamento"
      value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" />" /> <br /> <input
      type="hidden" name="id" value="${conta.id}" /> <input type="submit" value="Alterar" />
  </form>
</body>
</html>