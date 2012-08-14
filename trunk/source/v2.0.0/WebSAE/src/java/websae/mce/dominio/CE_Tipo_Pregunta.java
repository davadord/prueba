//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE
//  @ File Name : CE_Tipo_Pregunta.java
//  @ Date : 23/04/2009
//  @ Author : Guillermo Pizarro
//
//
package websae.mce.dominio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mad.eventos.Datos;
import mad.objetos.Registro;
import mad.objetos.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CE_Tipo_Pregunta {

    public static BigDecimal SELECCION_SIMPLE = new BigDecimal(1);
    public static BigDecimal SELECCION_MULTIPLE = new BigDecimal(2);
    public static BigDecimal ABIERTA = new BigDecimal(3);
    // <editor-fold defaultstate="collapsed" desc="Objetos Dependientes">
    public List<CE_Pregunta> ref_pregunta;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private BigDecimal tp_id_tipo_pregunta;
    private String tp_nombre;
    // </editor-fold>

    public CE_Tipo_Pregunta() {
    }

    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public List<CE_Pregunta> getRef_pregunta() {
        return ref_pregunta;
    }

    public void setRef_pregunta(List<CE_Pregunta> ref_pregunta) {
        this.ref_pregunta = ref_pregunta;
    }

    public BigDecimal getTp_id_tipo_pregunta() {
        return tp_id_tipo_pregunta;
    }

    public void setTp_id_tipo_pregunta(BigDecimal tp_id_tipo_pregunta) {
        this.tp_id_tipo_pregunta = tp_id_tipo_pregunta;
    }

    public String getTp_nombre() {
        return tp_nombre;
    }

    public void setTp_nombre(String tp_nombre) {
        this.tp_nombre = tp_nombre;
    }
    // </editor-fold>

    public void cr_CE_Tipo_Pregunta(Table objeto) {
        this.tp_id_tipo_pregunta = new BigDecimal((Long) objeto.get("tp_id_tipo_pregunta"));
        this.tp_nombre = (String) objeto.get("tp_nombre");
    }
    
    public static CE_Tipo_Pregunta buscar_tipo_pregunta(BigDecimal id_tipo_pregunta) {
        CE_Tipo_Pregunta elemento = new CE_Tipo_Pregunta();
        
        Datos datos = new Datos("WebSAE");
        String sql = "SELECT * FROM ce_tipo_pregunta WHERE tp_id_tipo_pregunta = " + id_tipo_pregunta + " ;";
        Registro registros = datos.consulta(sql);
        for (int i = 0; i < registros.size(); i++) {
            Table objeto = (Table) registros.get(i);
            elemento.cr_CE_Tipo_Pregunta(objeto);
        }
        return elemento;
    }

    public static List<CE_Tipo_Pregunta> tipo_preguntas() {
        List<CE_Tipo_Pregunta> elementos = new LinkedList<CE_Tipo_Pregunta>();

        Datos datos = new Datos("WebSAE");
        Registro registros = datos.consulta( "SELECT * FROM ce_tipo_pregunta ORDER BY tp_nombre;" );
        for (int i = 0; i < registros.size(); i++) {
            CE_Tipo_Pregunta elemento = new CE_Tipo_Pregunta();
            elemento.cr_CE_Tipo_Pregunta( registros.get(i) );
            elementos.add( elemento );
        }
        return elementos;
    }

    public static JSONObject toJSON(List<CE_Tipo_Pregunta> elementos) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<CE_Tipo_Pregunta> it = elementos.iterator(); it.hasNext();) {
                CE_Tipo_Pregunta elemento = it.next();
                jsonItems.put(toJSONObject(elemento));
            }
            json.put("identifier", "id_tipo_pregunta");
            json.put("label", "nombre");
            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(CE_Tipo_Pregunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSONObject(CE_Tipo_Pregunta elemento) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_tipo_pregunta", elemento.getTp_id_tipo_pregunta());
            json.put("nombre", elemento.getTp_nombre());
        } catch (Exception ex) {
            Logger.getLogger(CE_Tipo_Pregunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
