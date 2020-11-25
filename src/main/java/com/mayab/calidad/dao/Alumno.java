package com.mayab.calidad.dao;

public class Alumno {
	
	private int id;
	private String nombre;
	private int edad;
	private int calificacion;
	private String correo;
	
	public Alumno(int id, String nombre , int edad , int calificacion, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.calificacion = calificacion;
		this.correo = correo;
	}
	
	//Aquí van los getters
	
	

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getCalificacion() {
		return calificacion;
		
	}
	
	public String getCorreo() {

		return correo;
	}
	
	
	//setters 
	
	public void setId(int id) {
		this.id = id;
		}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;

	}
		
}
