<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Introdução ao jQuery</title>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/estilos.css">
    
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    
    <script type="text/javascript">

        $(document).ready(function() {
            
            $('#campo-nome').blur(function(){
                var value = $(this).val();
                console.log(value)
                $("#texto-copiado").html(value);
                
            });
        
    	});
    
    </script>
</head>
<body class="container">

    <h1>Hello World</h1>

    <label>Digite seu nome:</label>
    <input id="campo-nome"/>
    <input id="botao-copiar" type="button" value="copiar"/>
    
    <h2 id="texto-copiado"></h2>
    
</body>
</html>