/**
 * @(#) Cargo.java
 */

package websae.dominio;

import websae.informacion.*;

public class Cargo{
	/**
	 * indicador de estado
	 */
	private int estado;
	
	
	private Integer id_cargo;
	
	
	private String nombre;
	
	
	private String cargo;
	
	public Cargo( ){
		
	}
	
	public void cr_Cargo( ){
		
	}
	
	public void fin_Cargo( ){
		
	}
	
	/**
	 * Referencia al tipo de objeto dependiente Empresa_Usuario.
	 */
	public java.util.List<Empresa_Usuario> ref_empresa_usuario;
	
	/**
	 * Referencia al tipo de objeto dependiente Tipo_Empresa_cargo.
	 */
	public java.util.List<Tipo_Empresa_Cargo> ref_tipo_empresa_cargo;
	
	
}
