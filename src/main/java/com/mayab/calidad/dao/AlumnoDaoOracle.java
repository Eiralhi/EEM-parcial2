package com.mayab.calidad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDaoOracle {
	
	public Connection getConnection(){
		
		Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dbunit","dbunit");  
        }catch(Exception e)
       {
        	System.out.println(e);
        	}  
        return con;  
        


}

public boolean addAlumno(Alumno a) {
	
	
	Connection conexion = getConnection();
	PreparedStatement ps;
	
	try {
		ps = conexion.prepareStatement("insert INTO alumno(id, nombre,edad, calificacion, email) values (?, ?, ?, ?, ?)");
		
		ps.setInt(1, a.getId());
		ps.setString(2, a.getNombre());
		ps.setInt(3, a.getEdad());
		ps.setInt(4, a.getCalificacion());
		ps.setString(5, a.getCorreo());
		ps.executeUpdate();
		conexion.close();
		
	} catch (SQLException exep) {
		
		System.out.println(exep);
	}
	
	
	return false;
}

public boolean deleteAlumno(Alumno a) {
	
	Connection conexion = getConnection();
	PreparedStatement ps;
	
	
	try {
		ps = conexion.prepareStatement("Delete from alumno WHERE  id = ?");
		ps.setInt(1, a.getId());
		ps.executeUpdate();
		conexion.close();
		
	} catch (SQLException exep) {
		System.out.println(exep);
	}
	
	return false;
}


public Alumno getAlumno(int id) {	
	Connection conexion = getConnection();
	PreparedStatement ps;
	ResultSet rs;
	Alumno alumnor = null;
	
	try {
		ps = conexion.prepareStatement("SELECT * from alumno WHERE id = ?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		rs.next();
		
		int alumnoId = rs.getInt(1);
		String alumnoNombre = rs.getString(2);
		int alumnoEdad = rs.getInt(3);
		int AlumnoCal= rs.getInt(4);
		String AlumnoCorreo = rs.getString(5);
			
		alumnor = new Alumno(alumnoId, alumnoNombre, alumnoEdad, AlumnoCal, AlumnoCorreo);
		
		rs.close();
		ps.close();
		conexion.close();
		
	} catch (SQLException exep) {
		System.out.println(exep);
	}
	
	return alumnor;
}

public boolean updatePromedio(Alumno a, int calificacionNueva) {
	Connection conexion = getConnection();
	PreparedStatement ps;
	
	try {
		ps = conexion.prepareStatement("UPDATE alumno set grade = ? WHERE  id = ?");
		ps.setInt(1, calificacionNueva);
		ps.setInt(2, a.getId());
		 ps.executeUpdate();
		conexion.close();
		
	} catch (SQLException exep) {
		System.out.println(exep);
	}
	
	return false;
}

}

