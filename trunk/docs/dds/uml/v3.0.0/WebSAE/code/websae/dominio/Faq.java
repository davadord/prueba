/**
 * @(#) Faq.java
 */

package websae.dominio;

public class Faq{
	private Integer id_faq;
	
	/**
	 * indicador de estado
	 */
	private int estado;
	
	public Faq( ){
		
	}
	
	public void cr_Faq( ){
		
	}
	
	public void fin_Faq( ){
		
	}
	
	/**
	 * Referencia al tipo de objeto maestro Evento.
	 */
	public Evento ref_evento;
	
	/**
	 * Referencia al tipo de objeto dependiente Pregunta_Faq.
	 */
	public Pregunta_Faq ref_pregunta_faq;
	
	
}
