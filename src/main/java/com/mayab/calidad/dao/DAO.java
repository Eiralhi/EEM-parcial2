package com.mayab.calidad.dao;

public interface DAO {
	public boolean addAlumno(Alumno a);
	
	public boolean deleteAlumno(Alumno a);
	
	public boolean updatePromedio(Alumno a, int calificacionNueva);
	
	public Alumno getAlumno(int id);
	

}
