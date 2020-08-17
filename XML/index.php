<?php 
	$datos = simplexml_load_file("datos.xml");
	$ns = $datos->getNamespaces(true);
	$datos->registerXPathNamespace('cfdi', $ns['cfdi']);
	$datos->registerXPathNamespace('t', $ns['tfd']);
	$file = fopen("archivo.txt", "w");
	foreach ($datos->xpath('//cfdi:Comprobante//cfdi:Emisor') as $Emisor){ 
		echo "<h3>Emisor:</h3>";
		echo "<div><label>Nombre: ".$Emisor['Nombre']."</label></div>";
		fwrite($file, "Nombre: ".$Emisor['Nombre']."\r\n");
	    echo "<div><label>RFC: ".$Emisor['Rfc']."</label></div>";
	    fwrite($file, "RFC: ".$Emisor['Rfc']."\r\n");
     }
    foreach ($datos->xpath('//t:TimbreFiscalDigital') as $Timbre) {
	    echo "<h3>Timbre Fiscal Digital:</h3>";
		echo "<div><label>FechaTimbrado: ".$Timbre['FechaTimbrado']."</label></div>";
		fwrite($file, "FechaTimbrado: ".$Timbre['FechaTimbrado']."\r\n");
	    echo "<div><label>UUID: ".$Timbre['UUID']."</label></div>";
	    fwrite($file, "UUID: ".$Timbre['UUID']."\r\n");
	} 
	fclose($file);
	echo "<h2>Se genero el archivo.txt en la ruta '..\xml\archivo.txt' </h2> ";
?>