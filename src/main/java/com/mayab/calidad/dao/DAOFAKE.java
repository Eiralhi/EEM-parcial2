package com.mayab.calidad.dao;
import java.util.HashMap;


public class DAOFAKE {
 		
		private HashMap<Integer, Alumno> base = new HashMap<Integer, Alumno>();

		public boolean addAlumno(Alumno a) {
			return false;
		}

		
		public boolean deleteAlumno(Alumno a) {
			return false;
		}

		
		public boolean updatePromedio(Alumno a, double nuevoPromedio) {
			return false;
		}

		

		
		public Alumno getAlumno(int id) {
			return null;
		}
		
		public HashMap<Integer, Alumno> getBase(){
			return base;
		}
	}



