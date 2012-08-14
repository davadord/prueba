//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE - Sistema de Administración de Eventos
//  @ File Name : Estado.java
//  @ Date : 28/03/2009
//  @ Author : Guillermo Pizarro
//  @ Version : v1.0.0
//
//

package websae.informacion;

/**
 *
 * @author Guillermo Pizarro
 */
public class Estado {
    
    /** Estado de eliminación lógica */
    public static final String ELIMINADO = "E";
    public static final String VIGENTE = "V";
    public static final String PENDIENTE = "P";
    public static final String ESPERA = "S";
    public static final String APROBADO = "A";
    public static final String CADUCADO = "C";
    public static final String RECHAZADO = "RE";
    public static final String REGISTRADO = "R";
    public static final String EN_CONSULTA = "EC";
    public static final String EN_ESPERA = "EE";
    public static final String EN_EVALUACION = "EA";
    public static final String EVALUADO = "EV";
    
    public static final String REALIZADO = "R";

    /** Estado para conocer si ha pagado o no un registro. */
    public static final Boolean NO_PAGADO = false;
    /** Estado para conocer si ha pagado o no un registro. */
    public static final Boolean PAGADO = true;
    
    public static final String APROBAR_REGISTRO = "AR";
    public static final String RECHAZAR_REGISTRO = "RR";
    public static final String APROBAR_PAGO = "AP";
    public static final String RECHAZAR_PAGO = "RP";
    public static final String PAGO_PENDIENTE = "PP";

    public Estado() {
    }

    public String getEstado(String estado) {
        if (estado.compareTo(Estado.ELIMINADO) == 0) {
            return "ELIMINADO";
        } else if (estado.compareTo(Estado.VIGENTE) == 0) {
            return "VIGENTE";
        } else if (estado.compareTo(Estado.REALIZADO) == 0) {
            return "REALIZADO";
        }
        return null;
    }
}
