//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE
//  @ File Name : CE_Autor_Articulo.java
//  @ Date : 23/04/2009
//  @ Author : Guillermo Pizarro
//
//
package websae.mce.dominio;

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
import websae.mac.dominio.AC_Usuario;
import websae.mac.dominio.AC_Usuario_Perfil;

public class CE_Autor_Articulo {
    
    // <editor-fold defaultstate="collapsed" desc="Objetos maestros">
    public AC_Usuario_Perfil ref_usuario_perfil;
    public CE_Articulo ref_articulo;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private BigDecimal aa_id_articulo;
    private Boolean aa_autor_principal;
    // </editor-fold>

    public CE_Autor_Articulo() {
        this.ref_articulo = new CE_Articulo();
        this.ref_usuario_perfil = new AC_Usuario_Perfil();
        this.aa_autor_principal = false;
    }

    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public Boolean getAa_autor_principal() {
        return aa_autor_principal;
    }

    public void setAa_autor_principal(Boolean aa_autor_principal) {
        this.aa_autor_principal = aa_autor_principal;
    }
    
    public BigDecimal getAa_id_articulo() {
        return aa_id_articulo;
    }

    public void setAa_id_articulo(BigDecimal aa_id_articulo) {
        this.aa_id_articulo = aa_id_articulo;
    }
    // </editor-fold>
    
    public void cr_CE_Autor_Articulo(Table objeto) {
        this.aa_id_articulo = Funciones.getBigDecimal( objeto.get("aa_id_articulo") );
        this.aa_autor_principal = (Boolean) objeto.get("aa_autor_principal");
        
        this.ref_usuario_perfil.setUp_id_usuario_perfil( Funciones.getBigDecimal( objeto.get("ref_usuario_perfil") ) );
        this.ref_articulo.setAr_id_articulo( Funciones.getBigDecimal( objeto.get("ref_articulo") ) );
    }

    public static List< CE_Autor_Articulo > mostrar_autores_articulo(BigDecimal id_articulo) {
        List< CE_Autor_Articulo > elementos = new LinkedList< CE_Autor_Articulo >();
        
        Datos datos = new Datos("WebSAE");
        String sql = "SELECT * FROM ce_autor_articulo WHERE ref_articulo=" + id_articulo + ";";
        Registro registros = datos.consulta(sql);
        for (int i = 0; i < registros.size(); i++) {
            CE_Autor_Articulo elemento = new CE_Autor_Articulo();
            elemento.cr_CE_Autor_Articulo( (Table) registros.get(i) );
            elemento.ref_usuario_perfil.ref_usuario = AC_Usuario_Perfil.buscar_usuario( elemento.ref_usuario_perfil.getUp_id_usuario_perfil() );
            elementos.add( elemento );
        }
        return elementos;
    }

    public static JSONObject toJSON(List< CE_Autor_Articulo > elementos) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator< CE_Autor_Articulo > it = elementos.iterator(); it.hasNext();)
                jsonItems.put( toJSONObject( it.next() ) );

            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(CE_Alternativa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
    public static JSONObject toJSONObject(CE_Autor_Articulo elemento) {
        JSONObject json = new JSONObject();
        try {
            json.put("autor_principal", elemento.getAa_autor_principal() );
            if (elemento.ref_usuario_perfil.ref_usuario.getUs_id_usuario() != null)
                json.put("usuario", AC_Usuario.toJSONObject( elemento.ref_usuario_perfil.ref_usuario ) );
        } catch (Exception ex) {
            Logger.getLogger(CE_Autor_Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }    
}
