/**
 * @(#) Tipo_Empresa.java
 */
package websae.dominio;

import websae.informacion.*;

public class Tipo_Empresa {

    /**
     * Referencia al tipo de objeto dependiente Empresa.
     */
    public java.util.List<Empresa> ref_empresa;
    /**
     * Referencia al tipo de objeto dependiente Tipo_Empresa_cargo.
     */
    public java.util.List<Tipo_Empresa_Cargo> ref_tipo_empresa_cargo;
    /**
     * indicador de estado
     */
    private int estado;
    private Integer id_tipo_empresa;
    private String nombre;
    private String descripcion;

    public Tipo_Empresa() {
    }

    public void cr_Tipo_Empresa() {
    }

    public void fin_Tipo_Empresa() {
    }
}
