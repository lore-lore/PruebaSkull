<?php 
function Conectarse() 
{
   if (!($link=mysqli_connect("localhost","root",""))) 
   { 
      echo "Error conectando a la base de datos."; 
      exit(); 
   } 
   if (!mysqli_select_db($link,"escuela")) 
   { 
      echo "Error seleccionando la base de datos."; 
      exit(); 
   } 
   if(!mysqli_set_charset($link,"utf8")){
     echo "Error cambio caracteres";
   }   
   return $link;
} 
?>