package com.mx.entidad;

public class Pelicula {
	 int id;
	 String nombre;
	 int estreno;
	 String genero;
	 String duracion;
	 String mensaje;
	 String respuesta;
	 
	public Pelicula() {
		
	}
	
	public Pelicula(int id) {
		this.id = id;
	}
	
	public Pelicula(String nombre, int estreno, String genero, String duracion) {
		this.nombre = nombre;
		this.estreno = estreno;
		this.genero = genero;
		this.duracion = duracion;
	}

	public Pelicula(int id, String nombre, int estreno, String genero, String duracion) {
		this.id = id;
		this.nombre = nombre;
		this.estreno = estreno;
		this.genero = genero;
		this.duracion = duracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstreno() {
		return estreno;
	}

	public void setEstreno(int estreno) {
		this.estreno = estreno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", estreno=" + estreno + ", genero=" + genero
				+ ", duracion=" + duracion + ", mensaje=" + mensaje + ", respuesta=" + respuesta + "]\n";
	}
	
	
	 
}
