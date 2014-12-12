<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Introdução ao jQuery</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body class="container">
    <h1>Treinamentos</h1>
    <ul id="lista">
        <li>Lógica de Programação</li>
        <li>Dando os primeiros passos na web com HTML e CSS</li>
        <li>Banco de dados e SQL</li>
        <li>Ruby on Rails: do zero com deploy</li>
        <li>NodeJS e Socket I/O</li>
    </ul>
    <label>Novo treinamento:</label>
    <input id="treinamento">
    <input id="botao-adiciona" type="button" value="adicionar"/>
    <script src="resources/js/jquery.js"></script>
    <script>
        $(document).ready(function() {

            $('#lista').on('click', 'li', function(){
                alert($(this).text())
            });

            $('#botao-adiciona').click(function(){
                var treinamento = $('#treinamento')
                var value = treinamento.val();
                treinamento.val('');
                var il = $('<li>').text(value);
                $('#lista').append(il)
            });
            
        });
    </script>
</body>
</html>