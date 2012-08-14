//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE - Sistema de Administración de Eventos
//  @ File Name : AC_Perfil.java
//  @ Date : 28/03/2009
//  @ Author : Guillermo Pizarro
//  @ Version : v1.0.0
//
//
package websae.mac.dominio;

import java.math.BigDecimal;
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
import websae.informacion.Funciones;

public class AC_Perfil {

    // <editor-fold defaultstate="collapsed" desc="Objetos dependientes">
    public List<AC_Perfil_Opcion> ref_perfil_opcion;
    public List<AC_Usuario_Perfil> ref_usuario_perfil;
    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Atributos estáticos">
    public static String ADMINISTRADOR_GENERAL = "1";
    public static String ADMINISTRADOR = "2";
    public static String SUSCRIPTOR = "3";
    public static String REVISOR = "4";
    public static String AUTOR = "5";
    public static String VISITANTE = "6";
    public static String CONFERENCISTA = "7";
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private BigDecimal pe_id_perfil;
    private String pe_nombre;
    private String pe_estado;
    // </editor-fold>

    public AC_Perfil() {
    }

    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public String getPe_estado() {
        return pe_estado;
    }

    public void setPe_estado(String pe_estado) {
        this.pe_estado = pe_estado;
    }

    public BigDecimal getPe_id_perfil() {
        return pe_id_perfil;
    }

    public void setPe_id_perfil(BigDecimal pe_id_perfil) {
        this.pe_id_perfil = pe_id_perfil;
    }

    public String getPe_nombre() {
        return pe_nombre;
    }

    public void setPe_nombre(String pe_nombre) {
        this.pe_nombre = pe_nombre;
    }
    // </editor-fold>

    public void cr_AC_Perfil(Table objeto) {
        this.pe_id_perfil = Funciones.getBigDecimal( objeto.get("pe_id_perfil") );
        this.pe_nombre = (String) objeto.get("pe_nombre");
        this.pe_estado = (String) objeto.get("pe_estado");
    }

    public void cr_AC_Perfil(BigDecimal id_perfil, String nombre, String estado) {
        this.pe_id_perfil = id_perfil;
        this.pe_nombre = nombre;
        this.pe_estado = estado;
    }

    public static List<AC_Perfil> mostrar_perfiles() {
        List<AC_Perfil> perfiles = new LinkedList<AC_Perfil>();

        Datos datos = new Datos("WebSAE");
        Registro registros = datos.consulta("SELECT * FROM ac_perfil WHERE pe_id_perfil <> '" + AC_Perfil.VISITANTE + "';");
        for (int i = 0; i < registros.size(); i++) {
            Table objeto = (Table) registros.get(i);
            AC_Perfil perfil = new AC_Perfil();
            perfil.cr_AC_Perfil(new BigDecimal(objeto.get("pe_id_perfil").toString()), (String) objeto.get("pe_nombre"), (String) objeto.get("pe_estado"));
            perfiles.add(perfil);
        }
        return perfiles;
    }

    public static JSONObject toJSON(List<AC_Perfil> perfiles) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator<AC_Perfil> it = perfiles.iterator(); it.hasNext();) {
                jsonItems.put(toJSONObject(it.next()));
            }
            json.put("perfiles", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(AC_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSONObject(AC_Perfil perfil) {
        JSONObject json = new JSONObject();
        try {
            json.put("id_perfil", perfil.getPe_id_perfil());
            json.put("nombre", perfil.getPe_nombre());
            json.put("estado", perfil.getPe_estado());
        } catch (Exception ex) {
            Logger.getLogger(AC_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}
