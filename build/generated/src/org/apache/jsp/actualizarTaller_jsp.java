package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import DAO.DaoTaller;
import VO.BeanTaller;
import VO.PropietarioVO;

public final class actualizarTaller_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");

    HttpSession miSesion = (HttpSession) request.getSession();
    PropietarioVO propietariovo = (PropietarioVO) miSesion.getAttribute("pvo");


      out.write('\n');
      out.write('\n');
    DaoTaller dao = new DaoTaller();
    ArrayList<BeanTaller> talleres = dao.BuscarTalleres(propietariovo.getIdPropietario());

      out.write("\n");
      out.write("\n");
      out.write("\n");
    if (miSesion.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html class=\"no-js\" lang=\"es\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Asistente vial</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"assets/images/icon/favicon.ico\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/themify-icons.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/metisMenu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/slicknav.min.css\">\n");
      out.write("        <!-- amchart css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.amcharts.com/lib/3/plugins/export/export.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <!-- others css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/typography.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/default-css.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/styles.css\">\n");
      out.write("        <!-- modernizr css -->\n");
      out.write("        <script src=\"assets/js/vendor/modernizr-2.8.3.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/responsive.css\">\n");
      out.write("        <script src=\"assets/js/validaciones/validaciones.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"preloader\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- preloader area end -->\n");
      out.write("        <!-- page container area start -->\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            <!-- sidebar menu area start -->\n");
      out.write("            <div class=\"sidebar-menu\">\n");
      out.write("                <div class=\"sidebar-header\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <a href=\"menuTaller.jsp\"><img src=\"assets/images/logo/n.png\" alt=\"logo\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"main-menu\">\n");
      out.write("                    <div class=\"menu-inner\">\n");
      out.write("                        <nav>\n");
      out.write("                            <ul class=\"metismenu\" id=\"menu\">\n");
      out.write("                                <li><a href=\"menuTaller.jsp\"><i class=\"ti-menu\" style=\"color:orange\"></i> <span>Menu</span></a></li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"javascript:void(0)\" aria-expanded=\"true\"><i class=\"ti-dashboard\" style=\"color:orange\"></i><span>Talleres</span></a>\n");
      out.write("                                    <ul class=\"collapse\">\n");
      out.write("                                        <li><a href=\"registroTaller.jsp\">Registrar nuevo Taller</a></li>\n");
      out.write("                                        <li><a href=\"actualizarTaller.jsp\">Actualizar Talleres</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"javascript:void(0)\" aria-expanded=\"true\"><i class=\"ti-layout-sidebar-left\" style=\"color:orange\"></i><span>Mapa\n");
      out.write("                                        </span></a>\n");
      out.write("                                    <ul class=\"collapse\">\n");
      out.write("                                        <li><a href=\"alarmas.jsp\">Revisar Alarmas</a></li>\n");
      out.write("                                        <li><a href=\"reporteAlarmas.jsp\">Generar Reporte</a></li>\n");
      out.write("                                        <li><a href=\"menu_taller.jsp\"> Alarmas entrantes </a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li><a href=\"procedimiento.jsp\"><i class=\"ti-info\" style=\"color:orange\"></i> <span>Procedimientos</span></a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- sidebar menu area end -->\n");
      out.write("            <!-- main content area start -->\n");
      out.write("            <div class=\"main-content\">\n");
      out.write("                <!-- header area start -->\n");
      out.write("\n");
      out.write("                <!-- header area end -->\n");
      out.write("                <!-- page title area start -->\n");
      out.write("                <div class=\"page-title-area\">\n");
      out.write("                    <div class=\"row align-items-center\">\n");
      out.write("                        <div class=\"col-sm-6\">\n");
      out.write("\n");
      out.write("                            <div class=\"breadcrumbs-area clearfix\">\n");
      out.write("\n");
      out.write("                                ");
 if (request.getAttribute("mensajeError") != null) { 
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-danger alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡ERROR!</strong> Revise los datos e intente actualizar Nuevamente.\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                ");

                                } else if (request.getAttribute("mensajeExito") != null) {
                                
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-success alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡Correcto!</strong>Se actualizó el taller correctamente.\n");
      out.write("                                </div>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"nav-btn pull-left\">\n");
      out.write("                                <span></span>\n");
      out.write("                                <span></span>\n");
      out.write("                                <span></span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-6 clearfix\">\n");
      out.write("                            <div class=\"user-profile pull-right\" style=\"background: orange\">\n");
      out.write("                                <img class=\"avatar user-thumb\" src=\"assets/images/author/avatar.png\" alt=\"avatar\">\n");
      out.write("                                <h4 class=\"user-name dropdown-toggle\" data-toggle=\"dropdown\">");
      out.print( propietariovo.getUsuario());
      out.write(" ><i class=\"fa fa-angle-down\"></i></h4>\n");
      out.write("                                <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"actualizarPropietario.jsp\">Configuración</a>\n");
      out.write("                                    <form method=\"post\" action=\"close\">\n");
      out.write("                                        <input type=\"hidden\" name=\"opcion\" value=\"2\">\n");
      out.write("                                        <button  class=\"dropdown-item\" >Cerrar sesión</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"container\"> \n");
      out.write("                        <div class=\"card-body\"> \n");
      out.write("                            <h3> Actualizar talleres </h3>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div card-body>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <form method=\"post\" action=\"actualizarTaller\">\n");
      out.write("                                <label for=\"exampleInputPassword2\">Nit Taller</label>\n");
      out.write("                                <input type=\"number\" placeholder=\"Ingrese el nit de su taller\" name=\"txtid\"class=\"form-control\"  required>\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print( propietariovo.getIdPropietario());
      out.write("\" name=\"identificacion\">\n");
      out.write("                                <i class=\"\"></i>\n");
      out.write("                                <input type=\"hidden\" name=\"opcion\" value=\"2\">\n");
      out.write("                                <br>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group col-lg-6 col-sm-6 col-6 control-label\" >\n");
      out.write("                                    <button class=\"btn btn-warning btn-block\" id=\"btnregistrar\">Buscar</button>\n");
      out.write("                                </div>                          \n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 if (request.getAttribute("usuarioInvalido") != null) { 
      out.write("\n");
      out.write("                            <div class=\"alert alert alert-danger alert-dismissable\">\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                <strong>¡ERROR!</strong> Ese taller no existe.\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            ");


                                BeanTaller VO = (BeanTaller) request.getAttribute("VoLleno");
                                if (VO != null) {

                            
      out.write("\n");
      out.write("                            <br>\n");
      out.write("                            <h3>Actualizar Datos</h3>\n");
      out.write("                            <br>\n");
      out.write("                            <form method=\"post\" action=\"actualizarTaller\" class=\"needs-validation\">\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                        <input type=\"hidden\"   name=\"identificacion\" value=\"");
      out.print( VO.getNiTaller());
      out.write("\">\n");
      out.write("                                        <label>Taller</label>  \n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"txtnombretaller\"  value=\"");
      out.print(VO.getNombreTaller());
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                      \n");
      out.write("                                        <label>Teléfono</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" name=\"txttelefono\" value=\"");
      out.print(VO.getTelefono());
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                        <label> Correo</label>\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" name=\"txtcorreo\" value=\"");
      out.print(VO.getCorreo());
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"col-lg-6 mt-6\">                                   \n");
      out.write("                                        <label> Dirección </label>\n");
      out.write("                                        <input type=\"text\"  class=\"form-control\" name=\"txtdireccion\" value=\"");
      out.print(VO.getDireccion());
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <label>categoria</label><br>\n");
      out.write("                                <select name=\"txtcategoria\" class=\"form-control\" >\n");
      out.write("                                    <option value=\"");
      out.print(VO.getCategoria());
      out.write("\"> ");
      out.print(VO.getCategoria());
      out.write(" </option>\n");
      out.write("                                    <option value=\"Taller\"> Mecánica General </option> \n");
      out.write("                                    <option value=\"Electricos\"> Eléctricos </option> \n");
      out.write("                                    <option value=\"Reparación de llantas\"> Reparación de llantas </option> \n");
      out.write("                                    <option value=\"Servicio y lubricacion\"> Servicio y lubricacion </option> \n");
      out.write("                                </select>    <br><br>\n");
      out.write("                                <input type=\"hidden\" class=\"form-control\" name=\"txtcalificacion\" value=\"");
      out.print(VO.getCalificacion());
      out.write("\">\n");
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"img\" value=\"");
      out.print( VO.getLogo());
      out.write("\">\n");
      out.write("                                <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"form-group col-lg-6 col-sm-6 col-6 control-label\" >\n");
      out.write("                                        <button class=\"btn btn-warning btn-block\" id=\"btnregistrar\">Actualizar</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6 mt-5\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h4 class=\"header-title\">¿Mis talleres?</h4>\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-warning btn-flat btn-lg mt-3\" data-toggle=\"modal\" data-target=\"#tabla\">Consultar</button>\n");
      out.write("                                    <!-- Modal -->\n");
      out.write("                                    <div class=\"modal fade\" id=\"tabla\">\n");
      out.write("                                        <div class=\"modal-dialog\">\n");
      out.write("                                            <div class=\"modal-content\">\n");
      out.write("                                                <div class=\"modal-header\">\n");
      out.write("                                                    <h5 class=\"modal-title\"> Sus talleres </h5>\n");
      out.write("                                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span>&times;</span></button>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                                                    <table border=\"1px solid\" class=\"table table-striped table-bordered\" id=\"example\">\n");
      out.write("                                                        <thead class=\"table-dark\">\n");
      out.write("                                                            <tr>\n");
      out.write("                                                                <th>Nombre</th>\n");
      out.write("                                                                <th>Telefono</th>\n");
      out.write("                                                                <th>dirección taller</th>\n");
      out.write("                                                                <th>NitTaller</th>\n");
      out.write("\n");
      out.write("                                                            </tr>\n");
      out.write("                                                        </thead>\n");
      out.write("\n");
      out.write("                                                        ");
for (int i = 0; i < talleres.size(); i++) {
      out.write("\n");
      out.write("                                                        <tbody>\n");
      out.write("                                                            <tr>\n");
      out.write("                                                                <td>");
      out.print(talleres.get(i).getNombreTaller());
      out.write("</td>\n");
      out.write("                                                                <td>");
      out.print(talleres.get(i).getTelefono());
      out.write("</td>\n");
      out.write("                                                                <td>");
      out.print(talleres.get(i).getDireccion());
      out.write("</td>\n");
      out.write("                                                                <td>");
      out.print(talleres.get(i).getNiTaller());
      out.write("</td>\n");
      out.write("\n");
      out.write("                                                            </tr>\n");
      out.write("                                                        </tbody>\n");
      out.write("                                                        ");
 }
      out.write("\n");
      out.write("                                                    </table>\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"modal-footer\">\n");
      out.write("                                                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>                                                \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        var longitud, latitud;\n");
      out.write("        window.addEventListener('load', obtener, false);\n");
      out.write("        function obtener() {\n");
      out.write("            longitud = document.getElementById(\"longi\");\n");
      out.write("            latitud = document.getElementById(\"lat\");\n");
      out.write("            navigator.geolocation.getCurrentPosition(mostrar, gestionarErrores);\n");
      out.write("        }\n");
      out.write("        function mostrar(posicion) {\n");
      out.write("            if (navigator.geolocation) {\n");
      out.write("\n");
      out.write("                var lat = posicion.coords.latitude;\n");
      out.write("                var lng = posicion.coords.longitude;\n");
      out.write("                longitud.value = lng;\n");
      out.write("                latitud.value = lat;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        function gestionarErrores(error) {\n");
      out.write("            alert('Error: ' + error.code + ' ' + error.message + '\\n\\nPor favor compruebe que está conectado ' +\n");
      out.write("                    'a internet y habilite la opción permitir compartir ubicación física');\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- page title area end -->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- main content area end -->\n");
      out.write("<!-- footer area start-->\n");
      out.write("<footer>\n");
      out.write("    <div class=\"footer-area\">\n");
      out.write("        <p>© Copyright 2018. All right reserved. Template by <a href=\"https://colorlib.com/wp/\">Colorlib</a>.</p>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<!-- footer area end-->\n");
      out.write("</div>\n");
      out.write("<!-- page container area end -->\n");
      out.write("<!-- offset area start -->\n");
      out.write("<div class=\"offset-area\">\n");
      out.write("    <div class=\"offset-close\"><i class=\"ti-close\"></i></div>\n");
      out.write("    <ul class=\"nav offset-menu-tab\">\n");
      out.write("        <li><a class=\"active\" data-toggle=\"tab\" href=\"#activity\">Activity</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#settings\">Settings</a></li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <!-- offset area end -->\n");
      out.write("    <!-- jquery latest version -->\n");
      out.write("    <script src=\"assets/js/vendor/jquery-2.2.4.min.js\"></script>\n");
      out.write("    <!-- bootstrap 4 js -->\n");
      out.write("    <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/metisMenu.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/jquery.slimscroll.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/jquery.slicknav.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- start chart js -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\n");
      out.write("    <!-- start highcharts js -->\n");
      out.write("    <script src=\"https://code.highcharts.com/highcharts.js\"></script>\n");
      out.write("    <!-- start zingchart js -->\n");
      out.write("    <script src=\"https://cdn.zingchart.com/zingchart.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        zingchart.MODULESDIR = \"https://cdn.zingchart.com/modules/\";\n");
      out.write("        ZC.LICENSE = [\"569d52cefae586f634c54f86dc99e6a9\", \"ee6b7db5b51705a13dc2339db3edaf6d\"];\n");
      out.write("    </script>\n");
      out.write("    <!-- all line chart activation -->\n");
      out.write("    <script src=\"assets/js/line-chart.js\"></script>\n");
      out.write("    <!-- all pie chart -->\n");
      out.write("    <script src=\"assets/js/pie-chart.js\"></script>\n");
      out.write("    <!-- others plugins -->\n");
      out.write("    <script src=\"assets/js/plugins.js\"></script>\n");
      out.write("    <script src=\"assets/js/scripts.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
