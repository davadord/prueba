/**
 * @(#) Cargo.java
 */

package websae.dominio;

import websae.informacion.*;

public class Cargo{
	private Integer id_cargo;
	
	private String nombre;
	
	/**
	 * indicador de estado
	 */
	private int estado;
	
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
