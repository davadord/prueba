<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${param['lang'] != null}">
    <fmt:setLocale value="${param['lang']}" scope="session" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title><fmt:message key="ge.tituloProyecto" /> - <fmt:message key="adm.organizador" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <jsp:include page="/icono.jsp" />
        
        <jsp:include page="declaracion.jsp" />
    </head>

    <body class="yui-skin-sam tundra" onload="inicializar('${lang}')">
        <div id="div_body_general">
            <div id="div_cabecera">
                <jsp:include page="/menu/menu_general.jsp" />
            </div>
            <div id="div_banner_superior">
                <div class="div_menu">
                    <jsp:include page="/menu/encabezado.jsp" />
                </div>
                <jsp:include page="/vistas/logo_websae.jsp" />
            </div>

            <div id="div_contenedor_admin">
            <div id="div_info">
                <div class="div_menu_admin_titulo">
                    <fmt:message key="adm.menu_administrativo" />
                </div>
                <div class="div_menu_admin">
                    <jsp:include page="/menu/menu_administrador.jsp" />
                </div>
            </div>
            <jsp:include page="/vistas/info_usuario.jsp" />
            <div id="ubicacion">
                <span class="ubicacion"><fmt:message key="pistas.ud_esta_en" />:</span> <a href="/websae/administracion/index.jsp"><fmt:message key="pistas.administracion" /></a> ::. <a href="/websae/administracion/evento/index.jsp"><fmt:message key="even.eventos" /></a> ::. <a href="/websae/administracion/evento/administrar_evento/index.jsp"><fmt:message key="even.administrar_evento" /></a> ::. <a href="/websae/administracion/evento/opciones/index.jsp"><fmt:message key="adm.opciones_asignadas" /></a> ::. <span class="ubicacion"><fmt:message key="adm.organizador" /></span>
            </div>
            <div id="div_informacion_admin">
                <div id="opcion-menu">
                    <div id="opcion-menu-item">
                        <a href="/websae/administracion/evento/opciones/index.jsp"><img src="/websae/images/regresar.png" height="55px" alt="" /><br /><fmt:message key="ge.regresar" /></a>
                    </div>
                    <div class="clearthefloats"></div>
                </div>
                <br />
                <div id="div_form">
                    <div class="titulo-principal">${nombre_evento}</div>
                    <div class="titulo"><fmt:message key="adm.organizador" /></div>

                    <div id="tabs" style="width:350px; margin:0 auto;">
                        <div id="tab_info1">
                            <br />
                            <label class="info_organizador"><fmt:message key="adm.organizador" /></label>
                            <div id="div_organizadores"></div>
                            <label class="info_organizador">
                            <div class="clearthefloats"></div><br /><br />
                            <button dojoType="dijit.form.Button" onclick="accion_organizador('registrar','','','G','1')" style="float:right;">
                                <fmt:message key="ge.agregar" />
                            </button>
                            </label>
                        </div>
                        <div id="tab_info2">
                            <label class="info_organizador"><fmt:message key="us.tipo_empresa" /></label>
                            <div id="div_tipo_empresa"></div><br />
                            <label class="info_organizador"><fmt:message key="us.empresa_universidad" /></label>
                            <div id="div_empresa"><select id="cmb_empresa" ><option></option></select></div><br />
                            <label class="info_organizador">
                            <div class="clearthefloats"></div>
                            <button dojoType="dijit.form.Button" onclick="accion_organizador('registrar','','','E','1')" style="float:right;">
                                <fmt:message key="ge.agregar" />
                            </button>
                            </label>
                        </div>
                        <div class="clearthefloats"></div>
                    </div>
                </div>
                <div class="clearthefloats"></div><br />
                <div id="tbl_organizadores" style="width:350px; margin:0 auto;"></div>
            </div>
            </div>
            <div class="clearthefloats"></div>

            <div id="div_copyrigth">
                <jsp:include page="/pie_pagina.jsp" />
            </div>
        </div>
    </body>
</html>