<?php

if (!$_POST){
	header("Location: index.html");
};
$tex=$_POST['texto'];
  
function palindromo($texto){
	//Eliminar espacios en blanco y hacer toda la frase en minusculas
	$frase = str_replace(' ', '', $texto);
	//tamaño de cadena
	$tam = strlen($frase);
	//cambiamos la frase al reves
	$nueva_frase = "";
	for ($i=1; $i <= $tam ; $i++) { 
		$nueva_frase .= substr($frase, (-1*$i), 1);
	}
	//compara si las cadenas son iguales
	if (strcasecmp($frase, $nueva_frase) == 0) {
		$resultado = true;
	}else{
		$resultado = false;
	}
	return $resultado;
}

?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
  <title>Palindromo</title>
</head>

<body>
	<div class="row">
		<div class="container my-class">
			<div class="titulo">
				<div class="col-sm-12" style="margin-bottom: 10px;">
					<h3>Verificar si es palindromo</h3>
				</div>
			</div>
			<div class="cuerpo">
				<form role="form"  action="index.html" method="post" class="">
					<div class="input-group" style="margin-bottom: 20px;">
	                    <label>
	                    <?php
	                    	$resp = palindromo($tex);
	                    	if ($resp == true) {
	                    		echo "Si es palindromo";
	                    	} else {
	                    		echo "No es palindromo";
	                    	}
	                    	
	                    ?>
	                    </label>
	                </div>
					<button type="submit" class="btn mybtn" name="enviar">Nuevo</button>
				</form>
			</div>
		</div>
	</div>		

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>