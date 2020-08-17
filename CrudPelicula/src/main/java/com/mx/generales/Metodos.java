package com.mx.generales;

import java.util.List;

public interface Metodos {
	public String guardar(Object obj);
	public String editar(Object obj);
	public String eliminar(Object obj);
	public List<?> mostrar();
	public Object buscar (Object obj);
}
