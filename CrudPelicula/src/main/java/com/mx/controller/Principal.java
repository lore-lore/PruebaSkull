package com.mx.controller;

import com.mx.dao.PeliculaDao;
import com.mx.entidad.Pelicula;

public class Principal {

	public static void main(String[] args) {
		//Pelicula peli = new Pelicula("Mentes poderosas", 2018, "Ciencia ficcion", "1h 43m");
		PeliculaDao dao = new PeliculaDao();
		Pelicula peliB = new Pelicula(6);
		//dao.guardar(peli);
		peliB = (Pelicula) dao.buscar(peliB); 
		System.out.println("Pelicila encontrada:"+peliB);
		/*peliB.setNombre("Deadpool 2");
		peliB.setGenero("Accion");
		dao.editar(peliB);*/
		dao.eliminar(peliB);
		System.out.println(dao.mostrar());
	}

}
