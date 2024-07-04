package es.ifp.programacion.ejercicio.uf6;

public class Empleado {


		//Definicion de atributos de la clase Empleado
		private String nombre;
		private String apellidos;
		private int empleadoid;
		private int salario;

		
		//Constructor de Empleado
		 /**
		   * @param nombre
		   * @param apellidos	
		   * @param idEmpleado
		   * @param salario
		   */	
		public Empleado(int empleadoid,String nombre,String apellidos,int salario) {              	
			this.empleadoid=empleadoid;
			this.nombre=nombre;
			this.apellidos=apellidos;						
			this.salario=salario;	
			}
	
		//Metodos:

		 /**
		* Metodo get que retorna el nombre del empleado correspondiente
		* @return
		*/
		public String getNombre() {
			return nombre;
		}

		 /**
		* Metodo set que con el nombre del empleado correspondiente
		* @return
		*/
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Metodo get que retorna los apellidos del empleado correspondiente
		 * @return
		 */
		public String getApellidos() {
			return apellidos;
		}

		/**
		 * Metodo ser que con los apellidos del empleado correspondiente
		 * @return
		 */
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		/**
		 * Metodo get que retorna el Id del empleado correspondiente
		 * @return
		 */
		public int getEmpleadoId() {
			return empleadoid;
		}
		
		/**
		 * Metodo get que retorna el salario del empleado correspondiente
		 * @return
		 */
		public int getSalario() {
			return salario;
		}

		/**
		 * Metodo set con el salario del empleado correspondiente
		 * @return
		 */
		public void setSalario(int salario) {
			this.salario = salario;
		}

	    /**
	     * Metodo toString que muestra los datos de empleado correspondiente
	     */
        public String  toString() {
				
			
			return "Nombre:"+getNombre()+"\n"+
	               "Apellidos:"+this.getApellidos()+"\n"+
		           "IdEmpleado:"+this.getEmpleadoId()+"\n"+
		           "Salario:"+this.getSalario()+"\n";
	
	
}	
	
	
	
}
