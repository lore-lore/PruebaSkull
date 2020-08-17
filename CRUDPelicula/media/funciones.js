$(document).ready(function(){
	llenar();
});
//mostrar el formlario para agregar nuevo
$('#btnAbrirAgregar').click(function(){
	$('#modalAgregar').modal('show');
});//mostrar nuevo

//mostrar el formlario para editar
$('#tbody').on('click', '.btn-info', function(){
	var id = $(this).attr('data');
	$('#idU').val(id);
	$('#modalEditar').modal('show');
	var json ={"id":id};
	$.ajax({
		type : 'ajax',
		method : 'post',
		url : 'http://localhost:9002/CrudPelicula/crudPelicula/Pelicula/buscar',
		data : JSON.stringify(json),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		success: function(datos)
		{
			console.log("bien:"+JSON.stringify(datos));
			$('#nombreU').val(datos.nombre);
			$('#estrenoU').val(datos.estreno);
			$('#generoU').val(datos.genero);
			$('#duracionU').val(datos.duracion);
			$('#idU').val(datos.id);

		},
		error: function(error){
			console.log("mal="+JSON.stringify(error));
		}
	});//cierr ajax
});//formulario editar

//mostra el formulario para eliminar
$('#tbody').on('click', '.btn-danger', function(){
	var id = $(this).attr('data');
	$('#idD').val(id);
	$('#modalEliminar').modal('show');
});

//limpiar las cajas de texto
function limpiar(){
	$('#nombre').val('');
	$('#estreno').val('');
	$('#genero').val('');
	$('#duracion').val('');
}//limpiar

//Llenar tabla con los datos de la DB
function llenar(){
	$.ajax({
		type : 'ajax',
		method : 'get',
		url : 'http://localhost:9002/CrudPelicula/crudPelicula/Pelicula/mostrar',
		contentType : 'application/json; charset=utf-8',
		async : false,
		dataType : 'json',
		success: function(datos){
		console.log("bien:"+JSON.stringify(datos));
			var cuerpo;
			for(var i=0; i<datos.length; i++){
				cuerpo += '<tr>'+
                  '<td>'+datos[i].nombre+'</td>'+
                  '<td>'+datos[i].estreno+'</td>'+
                  '<td>'+datos[i].genero+'</td>'+ 
                  '<td>'+datos[i].duracion+'</td>'+
                  '<td>'+
				  '<a href="javascript:;" class="btn btn-block btn-info edi " data="'+datos[i].id+'"><i class="fa fa-fw fa-edit"></i></i></a>'+
				  '</td>'+
				  '<td>'+
				  '<a href="javascript:;" class="btn btn-block btn-danger edi" data="'+datos[i].id+'"><i class="fa fa-fw fa-remove"></i></a>'+
				  '</td>'+
                  '</tr>'

			}
			$('#tbody').html(cuerpo);
		},
		error: function(error){
			console.log("mal="+JSON.stringify(error));
		}
	});//cierr ajax
}//llenar

//Insertar un dato en la base de datos
$('#btnGuardar').click(function(){
	var nombre = $("#nombre").val();
	var estreno = $('#estreno').val();
	var genero = $('#genero').val();
	var duracion = $('#duracion').val();

	if(nombre==''){
		alert("Falta ingresar el nombre");
	}else if(estreno==''){
		alert('falta ingresar año de estreno');
	}else if(genero==''){
		alert("falta ingresar genero");
	}else if(duracion==''){
		alert("falta ingresar duracion de la pelicula");
	}else{
		var json = {"nombre": nombre, "estreno":estreno, "genero":genero, "duracion":duracion};
		$.ajax({
			type : 'ajax',
			method : 'post',
			url : 'http://localhost:9002/CrudPelicula/crudPelicula/Pelicula/insertar',
			data : JSON.stringify(json),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success: function(datos)
			{
				console.log("bien:"+JSON.stringify(datos));
				if(datos.mensaje == "Guardado"){
					llenar();
					limpiar();
					$('.alert-success').html('El registro se agrego').fadeIn().delay(4000).fadeOut('snow');
					$('#modalAgregar').modal('hide');
				}
			},
			error: function(vegeta){
				console.log("mal="+JSON.stringify(veg));
			}
		});//cierr ajax
	}//cierra else
});//btn guardar

//Editar una pelicula
$('#btnEditar').click(function(){
	var id = $("#idU").val();
	var nombre = $("#nombreU").val();
	var estreno = $('#estrenoU').val();
	var genero = $('#generoU').val();
	var duracion = $('#duracionU').val();

	if(nombre==''){
		alert("Falta ingresar el nombre");
	}else if(estreno==''){
		alert('falta ingresar año de estreno');
	}else if(genero==''){
		alert("falta ingresar genero");
	}else if(duracion==''){
		alert("falta ingresar duracion de la pelicula");
	}else{
		var json = {"id":id, "nombre": nombre, "estreno":estreno, "genero":genero, "duracion":duracion};
		$.ajax({
			type : 'ajax',
			method : 'post',
			url : 'http://localhost:9002/CrudPelicula/crudPelicula/Pelicula/editar',
			data : JSON.stringify(json),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success: function(datos)
			{
				console.log("bien:"+JSON.stringify(datos));
				if(datos.mensaje == "Editado"){
					llenar();
					$('.alert-info').html('El registro se edito').fadeIn().delay(4000).fadeOut('snow');
					$('#modalEditar').modal('hide');
				}
			},
		error: function(error){
			console.log("mal="+JSON.stringify(error));
		}
	});//cierr ajax 
	}//cierra else
});

//Eliminar registro de la DB
$('#btnEliminar').click(function(){
	var id = $('#idD').val();

	var json ={"id":id};
	$.ajax({
		type : 'ajax',
		method : 'post',
		url : 'http://localhost:9002/CrudPelicula/crudPelicula/Pelicula/eliminar',
		data : JSON.stringify(json),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		success: function(datos)
		{
			console.log("bien:"+JSON.stringify(datos));
			if(datos.mensaje == "Eliminado"){
				llenar();
				$('.alert-danger').html('El registro se elimino').fadeIn().delay(4000).fadeOut('snow');
				$('#modalEliminar').modal('hide');
			}
		},
		error: function(error){
			console.log("mal="+JSON.stringify(error));
		}
	});//cierr ajax 
});//btn eliminar
