<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

    <form action="efetuaLogin" method="POST">
        Login: <input type="text" name="login"/>
        <br/>
        Senha: <input type="text" name="senha"/>
        <br/>
        <br/>
        <input type="submit" value="Entrar na lista de contas"/>
    </form>

</body>
</html>