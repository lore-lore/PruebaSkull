package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Pelicula;
import com.mx.generales.DataBase;
import com.mx.generales.Metodos;

public class PeliculaDao implements Metodos{
	DataBase db = new DataBase();
	Pelicula peli = null;
	public String guardar(Object obj) {

		peli = (Pelicula) obj;
		Connection conne;
		PreparedStatement pst;
		String query = "INSERT INTO PELICULAS VALUES(?, ?, ?, ?, ?)";
		String resp = null;
		
		try {
			Class.forName(db.getDriver());
			conne = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conne.prepareStatement(query);
			pst.setInt(1, autoincremento());
			pst.setString(2, peli.getNombre());
			pst.setInt(3, peli.getEstreno());
			pst.setString(4, peli.getGenero());
			pst.setString(5, peli.getDuracion());
			
			int fila = pst.executeUpdate();
			if(fila == 1) {
				resp = "1";
				System.out.println("Se inserto:" + fila);
			}else {
				resp = "0";
				System.out.println("No se inserto:" + fila);
			}
		}catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al insertar:"+e.getMessage());
		}
		return resp;
	}

	public String editar(Object obj) {
		peli = (Pelicula) obj;
		Connection conne;
		PreparedStatement pst;
		String query = "UPDATE PELICULAS SET NOMBRE=?, ANIO_ESTRENO=?, GENERO=?, DURACION=? WHERE ID=?";
		String resp = null;
		
		try {
			Class.forName(db.getDriver());
			conne = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			
			pst = conne.prepareStatement(query);
			pst.setString(1, peli.getNombre());
			pst.setInt(2, peli.getEstreno());
			pst.setString(3, peli.getGenero());
			pst.setString(4, peli.getDuracion());
			pst.setInt(5, peli.getId());
			
			int fila = pst.executeUpdate();
			
			if(fila == 1) {
			resp = "1";
			System.out.println("Se actualizo:" + fila);
			}else {
				resp = "0";
				System.out.println("No se actualizo:" + fila);
			}
			
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al actualizar:" + e.getMessage());
		}
		return resp;
	}

	public String eliminar(Object obj) {
		peli = (Pelicula) obj;
		Connection conne;
		PreparedStatement pst;
		String query = "DELETE FROM PELICULAS WHERE ID = ?";
		String resp = null;
		
		try {
			Class.forName(db.getDriver());
			conne = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conne.prepareStatement(query);
			pst.setInt(1, peli.getId());
			
			int fila = pst.executeUpdate();
			if(fila == 1) {
				resp = "1";
				System.out.println("Se elimino:"+fila);
			}else {
				resp = "0";
				System.out.println("No se elimino:"+fila);
			}
		} catch (Exception e) {
			resp = e.getMessage();
			System.out.println("Error al eliminar:"+e.getMessage());
		}
		return resp;
	}

	public List<Pelicula> mostrar() {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		ResultSet rst;
		Connection conne;
		PreparedStatement pst;
		String query = "SELECT  ID, NOMBRE, ANIO_ESTRENO, GENERO, DURACION FROM PELICULAS";
		
		try {
			Class.forName(db.getDriver());
			conne = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conne.prepareStatement(query);
			rst = pst.executeQuery();
			while(rst.next()) {
				lista.add(new Pelicula(rst.getInt("ID"), rst.getString("NOMBRE"), rst.getInt("anio_estreno"), rst.getString("GENERO"), rst.getString("DURACION")));
			}
		} catch (Exception e) {
			System.out.println("error al mostrar:" + e.getMessage());
		}
		return lista;
	}

	public Object buscar(Object obj) {
		peli = (Pelicula) obj;
		ResultSet rst;
		Connection conne;
		PreparedStatement pst;
		String query= "SELECT ID, NOMBRE, ANIO_ESTRENO, GENERO, DURACION FROM PELICULAS WHERE ID="+peli.getId();
		
		try {
			Class.forName(db.getDriver());
			conne = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = conne.prepareStatement(query);
			rst = pst.executeQuery();
			while(rst.next()) {
				peli =  new Pelicula(rst.getInt("ID"), rst.getString("NOMBRE"), rst.getInt("ANIO_ESTRENO"), rst.getString("GENERO"), rst.getString("DURACION"));
			}
		} catch (Exception e) {
			System.out.println("Error al motrar:"+e.getMessage());
		}
		return peli;
	}
	
	public int autoincremento() {
		ResultSet rst;
		Connection cone;
		PreparedStatement pst;
		String query = "SELECT MAX(ID) MAX_ID FROM PELICULAS ";
		int max = 0;

		try {
			Class.forName(db.getDriver());
			cone = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			pst = cone.prepareStatement(query);
			rst = pst.executeQuery();
			while(rst.next())
			{
				max = rst.getInt("MAX_ID");
			}
			
		} catch (Exception e) {
			System.out.println("error al mostrar:" + e.getMessage());
		}
		return max+1;
	}

}
