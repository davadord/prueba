//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE
//  @ File Name : CE_Respuesta.java
//  @ Date : 23/04/2009
//  @ Author : Guillermo Pizarro
//
//
package websae.mce.dominio;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mad.eventos.Datos;
import mad.objetos.Registro;
import mad.objetos.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import websae.informacion.Funciones;

public class CE_Respuesta {

    // <editor-fold defaultstate="collapsed" desc="Objetos Maestros">
    public CE_Evaluacion_Articulo ref_evaluacion_articulo;
    public CE_Pregunta ref_pregunta;
    public CE_Alternativa ref_alternativa;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private BigDecimal re_id_respuesta;
    private Boolean re_seleccionada;
    private String re_texto;
    // </editor-fold>

    public CE_Respuesta() {
        this.ref_alternativa = new CE_Alternativa();
        this.ref_pregunta = new CE_Pregunta();
        this.ref_evaluacion_articulo = new CE_Evaluacion_Articulo();
        this.re_seleccionada = Boolean.FALSE;
    }

    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public BigDecimal getRe_id_respuesta() {
        return re_id_respuesta;
    }

    public void setRe_id_respuesta(BigDecimal re_id_respuesta) {
        this.re_id_respuesta = re_id_respuesta;
    }

    public Boolean getRe_seleccionada() {
        return re_seleccionada;
    }

    public void setRe_seleccionada(Boolean re_seleccionada) {
        this.re_seleccionada = re_seleccionada;
    }

    public String getRe_texto() {
        return re_texto;
    }

    public void setRe_texto(String re_texto) {
        this.re_texto = re_texto;
    }
    // </editor-fold>

    public void cr_CE_Respuesta(Table objeto) {
        this.re_id_respuesta = Funciones.getBigDecimal( objeto.get("re_id_respuesta") );
        this.re_texto = (String) objeto.get("re_texto");
        this.ref_pregunta.setPr_id_pregunta( Funciones.getBigDecimal( objeto.get("ref_pregunta") ) );
        this.ref_alternativa.setAl_id_alternativa( Funciones.getBigDecimal( objeto.get("ref_alternativa") ) );
        this.ref_evaluacion_articulo.setEt_id_evaluacion_articulo( Funciones.getBigDecimal(objeto.get("ref_evaluacion_articulo")) );
        this.re_seleccionada = Funciones.getBoolean( objeto.get("re_seleccionada") );
    }

    public static CE_Respuesta respuesta(BigDecimal id_alternativa) {
        CE_Respuesta elemento = new CE_Respuesta();
        
        Datos datos = new Datos("WebSAE");
        String sql = "SELECT * FROM ce_respuesta WHERE ref_alternativa = " + id_alternativa + ";";
        Registro registros = datos.consulta( sql );
        for (int i = 0; i < registros.size(); i++)
            elemento.cr_CE_Respuesta((Table) registros.get(i));
        
        return elemento;
    }
    
    public static CE_Respuesta respuesta(String id_pregunta) {
        CE_Respuesta elemento = new CE_Respuesta();

        Datos datos = new Datos("WebSAE");
        String sql = "SELECT * FROM ce_respuesta WHERE ref_pregunta = " + id_pregunta + ";";
        Registro registros = datos.consulta( sql );
        for (int i = 0; i < registros.size(); i++)
            elemento.cr_CE_Respuesta((Table) registros.get(i));
            
        return elemento;
    }

    public static JSONObject toJSON(List<CE_Respuesta> elementos) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<CE_Respuesta> it = elementos.iterator(); it.hasNext();) {
                CE_Respuesta elemento = it.next();
                jsonItems.put(toJSONObject(elemento));
            }
            json.put("identifier", "id_respuesta");
            json.put("label", "texto");
            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(CE_Respuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSONObject(CE_Respuesta elemento) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_respuesta", elemento.getRe_id_respuesta());
            json.put("texto", elemento.getRe_texto());
            json.put("seleccionada", elemento.getRe_seleccionada());
        } catch (Exception ex) {
            Logger.getLogger(CE_Respuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
