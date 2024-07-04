package es.ifp.programacion.ejercicio.uf6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ACTIVIDAD EVALUABLE UF6
 * Implementación de una gestion para una base de datos en Postgresql,llamada empresaDB.
 * Almacena informacion de empleados(idempleado,nombre,apellidos y salario).
 * Se ha creado una Java Class Empleado,almacenando en ella la clase,atributos,constructores y metodos.
 * Se ha creado una Java Class AdminBBDD,almacenando en ella los metodos de gestion de BBDD.
 * Se ha creado una Java Class ConsultasSQL,almacenando en ella las consultas a la BBDD.
 * En la clase AdminBBDD también se establece una ArrayList que almacena los empleados de la tabla de la BBDD.
 * En ProgramaPrincipal se crean los objetos tipo empleado y se realiza una serie de operaciones.
 *  */


public class ProgramaPrincipal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	
		// instancia de AdminBBDD
        AdminBBDD admin = new AdminBBDD();
		
        try {
        //conexion a la BBDD
        boolean conectado = admin.connectToDB();
       
		
		//se insertan registros en la BBDD
		Empleado empleado1 = new Empleado(1,"Juan","Cuesta",3000);
		 admin.insertarEmpleado(empleado1);
		 
		Empleado empleado2 = new Empleado(2,"Andrés","Guerra",2400);
		 admin.insertarEmpleado(empleado2);

		Empleado empleado3 = new Empleado(3,"Mariano","Delgado",1900);
		 admin.insertarEmpleado(empleado3);
		 
		 
		//se muestran todos los registros de la BBDD
		admin.getAllEmpleados();
		
		
		//se elimina uno de los registros de la BBDD
		admin.deleteEmpleado(empleado1);
		
		
		//se muestran todos los registros de la BBDD
		admin.getAllEmpleados();
       
        } catch (SQLException e) {
			System.out.println("Error en la gestión de operaciones de la BBDD: " + e.getMessage());
			
        } finally {		
	    //se cierran los recursos
	    admin.closeResources();
	
	
	
	
	
	}
		
		
		
		
		
		
		
		
		
	}
		
		
}	
		
		
		
		
		
	


