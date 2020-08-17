package com.mx.servicios;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.PeliculaDao;
import com.mx.entidad.Pelicula;

@Path("Pelicula")
public class PeliculaServ {
	PeliculaDao dao = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pelicula> mostrar(){
		dao = new PeliculaDao();
		List<Pelicula> lista = dao.mostrar();
		System.out.println("datos:"+lista);
		return lista;
	}
	
	@POST
	@Path("insertar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pelicula insertar(Pelicula peli) {
		dao = new PeliculaDao();
		String resp = dao.guardar(peli);
		
		if (resp.equals("1")) {
			peli.setMensaje("Guardado");
			peli.setRespuesta(resp);
		}else {
			peli.setMensaje("Error");
			peli.setRespuesta(resp);
		}
		return peli;
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pelicula eliminar(Pelicula peli) {
		dao = new PeliculaDao();
		String resp = dao.eliminar(peli);
		
		if (resp.equals("1")) {
			peli.setMensaje("Eliminado");
			peli.setRespuesta(resp);
		}else {
			peli.setMensaje("Error");
			peli.setRespuesta(resp);
		}
		return peli;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pelicula editar(Pelicula peli) {
		dao = new PeliculaDao();
		String resp = dao.editar(peli);
		
		if (resp.equals("1")) {
			peli.setMensaje("Editado");
			peli.setRespuesta(resp);
		}else {
			peli.setMensaje("Error");
			peli.setRespuesta(resp);
		}
		return peli;
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pelicula buscar(Pelicula peli) {
		dao = new PeliculaDao();
		peli = (Pelicula) dao.buscar(peli);
		return peli;
	}
}
