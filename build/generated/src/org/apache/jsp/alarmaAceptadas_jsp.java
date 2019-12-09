package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import VO.ClienteVO;
import java.util.ArrayList;
import VO.BeanTaller;
import DAO.DaoTaller;

public final class alarmaAceptadas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession miSesion1 = (HttpSession) request.getSession();
    ClienteVO clienteVO = (ClienteVO) miSesion1.getAttribute("clievo");

      out.write("\n");
      out.write("\n");
      out.write("\n");
    if (miSesion1.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


      out.write('\n');
    DaoTaller dao = new DaoTaller();
    ArrayList<BeanTaller> list = dao.historialAlarmasAceptadas(miSesion1.getAttribute("idusuario").toString());



      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html class=\"no-js\" lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Asistente Vial | consulta</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://unpkg.com/leaflet@1.0.3/dist/leaflet.css\" />\n");
      out.write("        <link href=\"assets/css/cssAlarma/gh-fork-ribbon.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"http://unpkg.com/leaflet@1.0.3/dist/leaflet.js\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/crearAlertaMaps.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/alerta.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/jquery-2.2.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@8\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/leaflet-providers.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/jquery-3.4.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>Consultar</title>\n");
      out.write("        <style>\n");
      out.write("            #map{\n");
      out.write("                height: 400px;\n");
      out.write("                width: 100%;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>      \n");
      out.write("        ");
      out.write("  \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"assets/images/icon/favicon.ico\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/themify-icons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/metisMenu.css\">\n");
      out.write("        <!-- <script src=\"https://cdn.jsdelivr.net/npm/promise-polyfill@8/dist/polyfill.js\"></script> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/slicknav.min.css\">\n");
      out.write("        <!-- amchart css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.amcharts.com/lib/3/plugins/export/export.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!-- others css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/typography.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/default-css.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/styles.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/responsive.css\">\n");
      out.write("        <!-- modernizr css -->\n");
      out.write("        <script src=\"assets/js/vendor/modernizr-2.8.3.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/alarma/buscadorAlarmasAceptadas.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            <!-- sidebar menu area start -->\n");
      out.write("            <div class=\"sidebar-menu\">\n");
      out.write("                <div class=\"sidebar-header\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"menu.jsp\"><img src=\"assets/images/logo/n.png\" alt=\"logo\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"main-menu\">\n");
      out.write("                    <div class=\"menu-inner\">\n");
      out.write("                        <nav>\n");
      out.write("                            <ul class=\"metismenu\" id=\"menu\">\n");
      out.write("                                <li><a href=\"menu.jsp\"><i class=\"ti-menu\" style=\"color: orange\"></i><span>Menu</span></a></li>\n");
      out.write("                                <li >\n");
      out.write("                                    <a href=\"javascript:void(0)\" aria-expanded=\"true\"><i class=\"ti-dashboard\" style=\"color:orange\"></i><span>Vehiculo</span></a>\n");
      out.write("                                    <ul class=\"collapse\">\n");
      out.write("                                        <li><a href=\"registroVehiculo.jsp\">Registrar nuevo Vehiculo</a></li>\n");
      out.write("                                        <li><a href=\"actualizarVehiculo.jsp\">Actualizar el vehiculo</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"javascript:void(0)\" aria-expanded=\"true\"><i class=\"ti-layout-sidebar-left\" style=\"color:orange\"></i><span>Soporte\n");
      out.write("                                        </span></a>\n");
      out.write("                                    <ul class=\"collapse\">\n");
      out.write("                                        <li><a href=\"soporte.jsp\">Revisar soporte</a></li>\n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li><a href=\"alarma.jsp\"><i class=\"ti-map-alt\" style=\"color:orange\"></i> <span>Alarma</span></a></li>\n");
      out.write("                                <li><a href=\"alarmaAceptadas.jsp\"><i class=\"fa fa-bell\" style=\"color:orange\"></i> <span>Alarmas aceptadas</span></a></li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"main-content\">\n");
      out.write("                <!-- header area start -->\n");
      out.write("\n");
      out.write("                <!-- header area end -->\n");
      out.write("                <!-- page title area start -->\n");
      out.write("                <div class=\"page-title-area\">\n");
      out.write("                    <div class=\"row align-items-center\">\n");
      out.write("                        <div class=\"col-sm-6\">\n");
      out.write("                            <div class=\"breadcrumbs-area clearfix\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <h3>Alarma</h3>\n");
      out.write("                                ");
 if (request.getAttribute("mensajeError") != null) { 
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-danger alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡ERROR!</strong> Revise los datos e intente nuevamente.\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                ");

                                } else if (request.getAttribute("mensajeExito") != null) {
                                
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-success alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡Correcto!</strong> Su vehiculo se registro correctamente.\n");
      out.write("                                </div>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"nav-btn pull-left\">\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                            <span></span>\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-6 clearfix\">\n");
      out.write("                            <div class=\"user-profile pull-right\" style=\"background: orange\">\n");
      out.write("                                <img class=\"avatar user-thumb\" src=\"assets/images/author/avatar.png\" alt=\"avatar\">\n");
      out.write("                                <h4 class=\"user-name dropdown-toggle\" data-toggle=\"dropdown\"> ");
      out.print(  clienteVO.getUsuario() );
      out.write(" <i class=\"fa fa-angle-down\"></i></h4>\n");
      out.write("                                <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"actualizarUsuario.jsp\">Configuración</a>\n");
      out.write("                                   <form method=\"post\" action=\"close\">\n");
      out.write("                                        <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("                                        <button  class=\"dropdown-item\" >Cerrar sesión</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <h4 class=\"header-title\">Alarmas a talleres</h4>\n");
      out.write("                        <p class=\"text-muted font-14 mb-4\">Pensado en todos los imprevistos que se pueden presentar en un auto \n");
      out.write("                            a la hora de viajar, se diseñó ésta alarma, para poder contactar con los talleres mas cercanos a su localización\n");
      out.write("                            y poder solucionar de manera rápida su imprevisto.\n");
      out.write("                        </p>\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(miSesion1.getAttribute("idusuario"));
      out.write("\" id=\"idusuario\"/> \n");
      out.write("                        <div class=\"col-lg-12 mt-5\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h3>Alarmas Aceptadas por Talleres</h3>\n");
      out.write("\n");
      out.write("                                    <table border=\"1px solid\" class=\"table\">\n");
      out.write("                                        <thead class=\"table-dark\">\n");
      out.write("                                            <tr>\n");
      out.write("\n");
      out.write("                                                <th>Taller</th>\n");
      out.write("                                                <th>Dirección taller</th>\n");
      out.write("                                                <th>Fecha</th>\n");
      out.write("                                                <td></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            ");
for (int i = 0; i < list.size(); i++) {
      out.write("\n");
      out.write("\n");
      out.write("                                            <tr>\n");
      out.write("\n");
      out.write("                                                <td>");
      out.print(list.get(i).getNombreTaller());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(list.get(i).getDireccion());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(list.get(i).getFecha());
      out.write("</td>\n");
      out.write("                                                <td><button onclick=\"buscarMap(");
      out.print(list.get(i).getLatitud());
      out.write(',');
      out.print(list.get(i).getLongitud());
      out.write(")\" type=\"button\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#exampleModal\">\n");
      out.write("                                                        Ver Distancia\n");
      out.write("                                                    </button>\n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("                                    <div id=\"map\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                                    <script>\n");
      out.write("                                        \n");
      out.write("\n");
      out.write("                                        var longitud, latitud;\n");
      out.write("                                        window.addEventListener('load', obteners, false);\n");
      out.write("                                        function obteners() {\n");
      out.write("                                            navigator.geolocation.getCurrentPosition(mostrars, gestionarErroress);\n");
      out.write("                                        }\n");
      out.write("                                        function mostrars(posicion) {\n");
      out.write("                                            if (navigator.geolocation) {\n");
      out.write("                                                longitud = posicion.coords.latitude;\n");
      out.write("                                                latitud = posicion.coords.longitude;\n");
      out.write("                                            }\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        }\n");
      out.write("                                        function gestionarErroress(error) {\n");
      out.write("                                            alert('Error: ' + error.code + ' ' + error.message + '\\n\\nPor favor compruebe que está conectado ' +\n");
      out.write("                                                    'a internet y habilite la opción permitir compartir ubicación física');\n");
      out.write("                                        }\n");
      out.write("                                        var polylines;\n");
      out.write("                                        var contador = 0;\n");
      out.write("                                        var map = L.map('map');\n");
      out.write("                                        function buscarMap(cordenadasLa, cordenadasLon) {\n");
      out.write("\n");
      out.write("                                            var coords = [\n");
      out.write("                                                L.latLng(cordenadasLa, cordenadasLon),\n");
      out.write("\n");
      out.write("                                                L.latLng(longitud, latitud),\n");
      out.write("                                            ];\n");
      out.write("                                            L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n");
      out.write("                                                attribution: '© <a target=\"_parent\" href=\"http://www.openstreetmap.org\">OpenStreetMap</a> and contributors, under an <a target=\"_parent\" href=\"http://www.openstreetmap.org/copyright\">open license</a>',\n");
      out.write("                                                center: [4.5700001, -74.1167465],\n");
      out.write("                                                zoom: 18,\n");
      out.write("                                                zoomControl: true\n");
      out.write("                                            }).addTo(map);\n");
      out.write("                                            if (contador > 0) {\n");
      out.write("                                                map.removeLayer(polylines);\n");
      out.write("                                            }\n");
      out.write("                                            var line = L.polyline(coords);\n");
      out.write("                                            map.fitBounds(line.getBounds());\n");
      out.write("                                            map.addLayer(line);\n");
      out.write("                                            polylines = line;\n");
      out.write("                                            contador++;\n");
      out.write("                                        }\n");
      out.write("\n");
      out.write("                                    </script>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <!-- main content area end -->\n");
      out.write("                                <!-- footer area start-->\n");
      out.write("                                <footer>\n");
      out.write("                                    <div class=\"footer-area\">\n");
      out.write("                                        <p>© Copyright 2018. All right reserved. Template by <a href=\"https://colorlib.com/wp/\">Colorlib</a>.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </footer>\n");
      out.write("                                <!-- footer area end-->\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"offset-area\">\n");
      out.write("                                <div class=\"offset-close\"><i class=\"ti-close\"></i></div>\n");
      out.write("                                <ul class=\"nav offset-menu-tab\">\n");
      out.write("                                    <li><a class=\"active\" data-toggle=\"tab\" href=\"#activity\">Activity</a></li>\n");
      out.write("                                    <li><a data-toggle=\"tab\" href=\"#settings\">Settings</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <!-- offset area end -->\n");
      out.write("                                <!-- jquery latest version -->\n");
      out.write("                                <script src=\"assets/js/vendor/jquery-2.2.4.min.js\"></script>\n");
      out.write("                                <!-- bootstrap 4 js -->\n");
      out.write("                                <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("                                <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("                                <script src=\"assets/js/owl.carousel.min.js\"></script>\n");
      out.write("                                <script src=\"assets/js/metisMenu.min.js\"></script>\n");
      out.write("                                <script src=\"assets/js/jquery.slimscroll.min.js\"></script>\n");
      out.write("                                <script src=\"assets/js/jquery.slicknav.min.js\"></script>\n");
      out.write("\n");
      out.write("                                <!-- start chart js -->\n");
      out.write("                                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\n");
      out.write("                                <!-- start highcharts js -->\n");
      out.write("                                <script src=\"https://code.highcharts.com/highcharts.js\"></script>\n");
      out.write("                                <!-- start zingchart js -->\n");
      out.write("                                <script src=\"https://cdn.zingchart.com/zingchart.min.js\"></script>\n");
      out.write("                                <script>\n");
      out.write("                                        zingchart.MODULESDIR = \"https://cdn.zingchart.com/modules/\";\n");
      out.write("                                        ZC.LICENSE = [\"569d52cefae586f634c54f86dc99e6a9\", \"ee6b7db5b51705a13dc2339db3edaf6d\"];\n");
      out.write("                                </script>\n");
      out.write("                                <!-- all line chart activation -->\n");
      out.write("                                <script src=\"assets/js/line-chart.js\"></script>\n");
      out.write("                                <!-- all pie chart -->\n");
      out.write("                                <script src=\"assets/js/pie-chart.js\"></script>\n");
      out.write("                                <!-- others plugins -->\n");
      out.write("                                <script src=\"assets/js/plugins.js\"></script>\n");
      out.write("                                <script src=\"assets/js/scripts.js\"></script>\n");
      out.write("                                </body>\n");
      out.write("                                </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
