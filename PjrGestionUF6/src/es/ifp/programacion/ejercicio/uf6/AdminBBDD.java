package es.ifp.programacion.ejercicio.uf6;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminBBDD {
	
	//Inicializaciones
    final String DBURL="jdbc:postgresql://localhost:5432/empresaDB";
	Connection conexion = null;
	ResultSet rs=null;
	Statement stmt=null;
	PreparedStatement ps;
	int numFilas;
	String nombre,apellidos;
	int empleadoid;
	int salario;
		
	
	//Operaciones de BBDD
	
	/**
	 * Se conecta a la BBDD empresadb creada en postgreSQL.
	 * @return true si la conexion fue satisfactoria, false si no.
	 */
	public boolean connectToDB()  throws SQLException{
	
       try {

          conexion = DriverManager.getConnection(DBURL,"postgres","IFPifp23");
          ps = conexion.prepareStatement("");
          System.out.println("Conexión establecida correctamente");
       
          return true;
       }
       
       catch(SQLException e) {
       System.out.println(e.getMessage());
       System.out.println("Error al establecer la conexión:" + e.getMessage());
       return false;
       
       }
	}
	
       /**
   	 * Cierra todos los recursos relativos a la BBDD
   	 * @return true si la operacion fue correcta, false si no.
   	 */
   	public boolean closeResources () throws SQLException {
   	try {
   	 if (rs != null) {    
    rs.close(); 
   	 }
	 if (ps != null) {  		 
	 }
   	ps.close();
   	if (conexion != null) {  		
   	}
   	conexion.close();
    return true;
    
    } catch(SQLException e) {   	
    	System.out.println("Error al cerrar la conexión:" + e.getMessage());
    	return false;
    }
   	}

   	
/**
 * A partir de un objeto empleado, inserta todos sus datos en la tabla empleados.
 * @param emp Objeto de tipo empleado
 * @return 0 si no se ha insertado valor alguno. En caso contrario, el numero de filas insertadas.
 * @throws SQLException 
 */
public int insertarEmpleado(Empleado empleado) throws SQLException {
	PreparedStatement ps = conexion.prepareStatement(ConsultasSQL.SQL_INSERT);
	int numFilas = 0;
	 try {
     ps.setInt(1, empleado.getEmpleadoId());
	 ps.setString(2, empleado.getNombre());
     ps.setString(3, empleado.getApellidos());
     ps.setInt(4, empleado.getSalario());
     numFilas = ps.executeUpdate();
     System.out.println("Se ha insertado el empleado con id " + empleado.getEmpleadoId() + " " + empleado.getNombre() + " " + empleado.getApellidos());
	System.out.println("Número de filas insertadas:"+numFilas);
	
	 
	 } catch (SQLException e) {
	        System.out.println("Error al insertar empleado:" + e.getMessage());
	
	 }
	return numFilas;
	}    


/**
 * Borra el registro de la tabla asociado al objeto emp pasado como parametro
 * @param emp objeto Empleado que se elimina de la BBDD
 * @return true si el borrado fue correcto, false sino.
 */
public boolean deleteEmpleado(Empleado empleado) throws SQLException {
	 try {
	       PreparedStatement ps = conexion.prepareStatement(ConsultasSQL.SQL_DELETE);
	        ps.setInt(1, empleado.getEmpleadoId());
	        int numFilas = ps.executeUpdate();
	        if (numFilas > 0) {
	        	 System.out.println("Se ha eliminado el empleado con id " + empleado.getEmpleadoId() + " " + empleado.getNombre() + " " + empleado.getApellidos());
	            return true;
	        } else {	            
	            return false;
	        }
	    } catch (SQLException e) {   
	    	System.out.println("Error al eliminar el empleado");
	        return false;
	    }
	}


/**
 * Obtiene todos los registros de la tabla empleados
 * @return un ArrayList de objetos de tipo Empleado mapeados a los registros de la tabla.
 * @throws SQLException 
 */
public ArrayList<Empleado> getAllEmpleados() throws SQLException {


	 ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	 PreparedStatement ps = conexion.prepareStatement(ConsultasSQL.SQL_GETALL);   
	 ResultSet rs = ps.executeQuery();
try {
	while (rs.next()) {
		nombre=rs.getString("nombre");
		apellidos=rs.getString("apellidos");
		empleadoid=rs.getInt("empleadoid");
		salario=rs.getInt("salario");
		System.out.println("=============================================");
		System.out.println("EMPLEADO:idEmpleado:"+empleadoid);
		System.out.println("Nombre:"+nombre);
		System.out.println("Apellidos:"+apellidos);
		System.out.println("Salario:"+salario);
		System.out.println("=============================================");
		
	}
} catch (SQLException e) {
	System.out.println("Error al mostrar los empleados:" + e.getMessage());
}
return empleados;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
}
	
	
	

