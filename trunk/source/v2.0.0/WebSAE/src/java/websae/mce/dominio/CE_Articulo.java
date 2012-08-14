// 
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : WebSAE
//  @ File Name : CE_Articulo.java
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
import websae.mac.eventos.Mostrar_Usuario;
import websae.mae.dominio.AE_Conferencista_Evento_Articulo;
import websae.mae.dominio.AE_Evento;

public class CE_Articulo {

    // <editor-fold defaultstate="collapsed" desc="Objeto maestro">
    public AE_Evento ref_evento;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Objetos dependientes">
    public List<AE_Conferencista_Evento_Articulo> ref_conferencista_evento_articulo;
    public List<CE_Autor_Articulo> ref_autor_articulo;
    public List<CE_Tema_Articulo> ref_tema_articulo;
    public List<CE_Archivo> ref_archivo;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private BigDecimal ar_id_articulo;
    private String ar_titulo;
    private String ar_resumen;
    private String ar_estado;
    // </editor-fold>

    public CE_Articulo() {
        this.ref_evento = new AE_Evento();
        this.ref_archivo = new LinkedList<CE_Archivo>();
        this.ref_autor_articulo = new LinkedList< CE_Autor_Articulo >();
        this.ref_tema_articulo = new LinkedList< CE_Tema_Articulo >();
    }

    // <editor-fold defaultstate="collapsed" desc="Setters & Getters">
    public String getAr_estado() {
        return ar_estado;
    }

    public void setAr_estado(String ar_estado) {
        this.ar_estado = ar_estado;
    }

    public BigDecimal getAr_id_articulo() {
        return ar_id_articulo;
    }

    public void setAr_id_articulo(BigDecimal ar_id_articulo) {
        this.ar_id_articulo = ar_id_articulo;
    }

    public String getAr_resumen() {
        return ar_resumen;
    }

    public void setAr_resumen(String ar_resumen) {
        this.ar_resumen = ar_resumen;
    }

    public String getAr_titulo() {
        return ar_titulo;
    }

    public void setAr_titulo(String ar_titulo) {
        this.ar_titulo = ar_titulo;
    }
    // </editor-fold>

    public void cr_CE_Articulo(Table objeto) {
        this.ar_id_articulo = Funciones.getBigDecimal(objeto.get("ar_id_articulo"));
        this.ar_titulo = (String) objeto.get("ar_titulo");
        this.ar_resumen = (String) objeto.get("ar_resumen");
        this.ar_estado = (String) objeto.get("ar_estado");
        
        this.ref_evento.setEv_id_evento( Funciones.getBigDecimal( objeto.get("ref_evento") ) );
    }
    
    // <editor-fold defaultstate="collapsed" desc="Gestion de Autores.">
    public String agregar_autor( CE_Autor_Articulo autor_articulo ) {
        autor_articulo.ref_usuario_perfil.ref_usuario = Mostrar_Usuario.buscar_usuario_por_email( autor_articulo.ref_usuario_perfil.ref_usuario.getUs_email() );
        if (autor_articulo.ref_usuario_perfil.ref_usuario != null) {
            int indice = buscar_indice_autor( autor_articulo.ref_usuario_perfil.ref_usuario );
            if (indice == -1) {
                this.ref_autor_articulo.add( autor_articulo );
                return "OK:exitoso";
            }
            return "ERROR:repetido";
        }
        return "ERROR:no existe";
    }
    
    public String modificar_autor( CE_Autor_Articulo autor_articulo ) {
        int indice = buscar_indice_autor( autor_articulo.ref_usuario_perfil.ref_usuario );
        if (indice != -1) {
            CE_Autor_Articulo autor = this.ref_autor_articulo.get(indice);
            autor.setAa_autor_principal( autor_articulo.getAa_autor_principal() );
            this.ref_autor_articulo.remove( indice );
            return "OK:exitoso";
        }
        return "ERROR:modificar";
    }
    
    public String eliminar_autor( AC_Usuario usuario ) {
        int indice = buscar_indice_autor( usuario );
        if (indice != -1) {
            this.ref_autor_articulo.remove( indice );
            return "OK:exitoso";
        }
        return "ERROR:eliminar";
    }
    
    public int buscar_indice_autor(AC_Usuario usuario) {
        for (int indice=0; indice<this.ref_autor_articulo.size(); indice++) {
            CE_Autor_Articulo objeto = this.ref_autor_articulo.get(indice);
            if (objeto.ref_usuario_perfil.ref_usuario.getUs_email().compareTo( usuario.getUs_email() ) == 0)
                return indice;
        }
        return -1;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Gestion de Temas.">
    public String agregar_tema(CE_Tema tema) {
        int indice = buscar_indice_tema(tema);
        if (indice == -1) {
            CE_Tema_Articulo elemento = new CE_Tema_Articulo();
            elemento.ref_tema = tema;
            this.ref_tema_articulo.add( elemento );
            return "OK:exitoso";
        }
        return "ERROR:agregar";
    }
    
    public String eliminar_tema(CE_Tema tema) {
        int indice = buscar_indice_tema(tema);
        if (indice != -1) {
            this.ref_tema_articulo.remove(indice);
            return "OK:exitoso";
        }
        return "ERROR:eliminar";
    }

    public int buscar_indice_tema(CE_Tema tema) {
        for (int i=0; i<this.ref_tema_articulo.size(); i++) {
            CE_Tema_Articulo objeto = this.ref_tema_articulo.get(i);
            if (objeto.ref_tema.getTe_id_tema().compareTo( tema.getTe_id_tema() ) == 0)
                return i;
        }
        return -1;
    }
    // </editor-fold>
    
    public static List< CE_Articulo > buscar_articulo(AC_Usuario usuario, String id_evento) {
        String sql = "SELECT * FROM V_Articulo WHERE ref_evento = "+id_evento+" AND us_id_usuario = "+usuario.getUs_id_usuario()+";";
        return articulos( sql, false );
    }

    public static List<CE_Articulo> articulos_evaluador(BigDecimal id_usuario) {
        String sql = "{call ce_articulos_evaluador("+id_usuario+")}";
        return articulos( sql, true );
    }
    
    public static List< CE_Articulo > articulos( String sql, Boolean estado_por_evaluador ) {
        List< CE_Articulo > elementos = new LinkedList< CE_Articulo >();
        
        Datos datos = new Datos("WebSAE");
        Registro registros = datos.consulta( sql );
        for (int i = 0; i < registros.size(); i++) {
            Table objeto = registros.get(i);
            CE_Articulo elemento = new CE_Articulo();
            elemento.cr_CE_Articulo( objeto );
            if (estado_por_evaluador)
                elemento.setAr_estado( (String) objeto.get("et_estado") );
            elemento.ref_archivo = CE_Archivo.mostrar_archivos_por_articulo( elemento.getAr_id_articulo() );
            elemento.ref_autor_articulo = CE_Autor_Articulo.mostrar_autores_articulo( elemento.getAr_id_articulo() );
            elemento.ref_tema_articulo = CE_Tema_Articulo.mostrar_temas_articulo( elemento.getAr_id_articulo() );
            elementos.add( elemento );
        }
        return elementos;
    }
    
    public static CE_Articulo buscar_articulo(AC_Usuario usuario, String id_evento, String id_articulo) {
        String sql = "SELECT * FROM V_Articulo WHERE ar_id_articulo = "+id_articulo+" AND ref_evento = "+id_evento+" AND us_id_usuario = "+usuario.getUs_id_usuario()+" AND aa_autor_principal = "+Boolean.TRUE+";";
        return obtener_articulo( sql );
    }

    public static CE_Articulo buscar_articulo(String id_articulo, String lang) {
        String sql = "SELECT * FROM V_Articulo WHERE ar_id_articulo = "+id_articulo+";";
        CE_Articulo articulo = obtener_articulo( sql );
        if (lang != null)
            articulo.ref_evento = AE_Evento.buscar_evento(articulo.ref_evento.getEv_id_evento().toString(), lang);
        return articulo;
    }
    
    public static CE_Articulo articulo_asignado(AC_Usuario usuario, String id_evento, String id_articulo) {
        String sql = "SELECT * FROM V_Articulo WHERE ar_id_articulo = "+id_articulo+";";
        return obtener_articulo( sql );
    }

    private static CE_Articulo obtener_articulo (String sql) {
        CE_Articulo elemento = new CE_Articulo();
        
        Datos datos = new Datos("WebSAE");
        Registro registros = datos.consulta( sql );
        for (int i = 0; i < registros.size(); i++) {
            elemento.cr_CE_Articulo( registros.get(i) );
            elemento.ref_archivo = CE_Archivo.mostrar_archivos_por_articulo( elemento.getAr_id_articulo() );
            elemento.ref_autor_articulo = CE_Autor_Articulo.mostrar_autores_articulo( elemento.getAr_id_articulo() );
            elemento.ref_tema_articulo = CE_Tema_Articulo.mostrar_temas_articulo( elemento.getAr_id_articulo() );
        }
        return elemento;
    }
    
    public static List< CE_Articulo > mostrar_articulos_recibidos( String id_evento ) {
        String sql = "SELECT * FROM CE_Articulo WHERE ref_evento = "+id_evento+" ORDER BY ar_titulo;";
        return mostrar_articulos( sql );
    }
    
    public static List< CE_Articulo > mostrar_articulos_por_estado( String id_evento, String estado ) {
        String sql = "SELECT * FROM CE_Articulo WHERE ref_evento = "+id_evento+" AND ar_estado = '"+estado+"' ORDER BY ar_titulo;";
        return mostrar_articulos( sql );
    }
    
    public static List< CE_Articulo > mostrar_articulos( String sql ) {
        List< CE_Articulo > elementos = new LinkedList< CE_Articulo >();
        
        Datos datos = new Datos("WebSAE");
        Registro registros = datos.consulta( sql );
        for (int i = 0; i < registros.size(); i++) {
            CE_Articulo elemento = new CE_Articulo();
            elemento.cr_CE_Articulo( registros.get(i) );
            elemento.ref_archivo.add( CE_Archivo.archivo_por_articulo( elemento.getAr_id_articulo() ) );
            elementos.add( elemento );
        }
        return elementos;
    }
    
    public static JSONObject toJSON(List< CE_Articulo > elementos) {
        JSONObject json = new JSONObject();
        try {
            JSONArray jsonItems = new JSONArray();
            for (Iterator< CE_Articulo > it = elementos.iterator(); it.hasNext();)
                jsonItems.put( toJSONObject( it.next() ) );
                
            json.put("items", jsonItems);
        } catch (JSONException ex) {
            Logger.getLogger(CE_Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static JSONObject toJSONObject(CE_Articulo elemento) {
        JSONObject json = new JSONObject();
        try {
            json.put("id", elemento.getAr_id_articulo() );
            json.put("titulo", elemento.getAr_titulo() );
            json.put("resumen", elemento.getAr_resumen() );
            json.put("estado", elemento.getAr_estado() );
            json.put("autor_articulo", CE_Autor_Articulo.toJSON( elemento.ref_autor_articulo ) );
            json.put("tema_articulo", CE_Tema_Articulo.toJSON( elemento.ref_tema_articulo ) );
            json.put("archivo", CE_Archivo.toJSON( elemento.ref_archivo ) );
            json.put("evento", AE_Evento.toJSONObject( elemento.ref_evento ) );
        } catch (Exception ex) {
            Logger.getLogger(CE_Articulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}