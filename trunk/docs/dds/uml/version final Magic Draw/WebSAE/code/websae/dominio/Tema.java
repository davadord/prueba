/**
 * @(#) Tema.java
 */

package websae.dominio;

public class Tema{
	/**
	 * indicador de estado
	 */
	private int estado;
	
	
	private Integer id_tema;
	
	
	private String nombre;
	
	public Tema( ){
		
	}
	
	public void cr_Tema( ){
		
	}
	
	public void fin_Tema( ){
		
	}
	
	/**
	 * Referencia al tipo de objeto maestro Convocatoria.
	 */
	public Convocatoria ref_convocatoria;
	
	/**
	 * Referencia al tipo de objeto dependiente Tema_Articulo.
	 */
	public java.util.List<Tema_Articulo> ref_tema_articulo;
	
	
}
