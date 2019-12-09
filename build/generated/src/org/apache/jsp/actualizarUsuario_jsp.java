package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import VO.ClienteVO;

public final class actualizarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession miSesion1 = (HttpSession) request.getSession();
    ClienteVO clienteVO = (ClienteVO) miSesion1.getAttribute("clievo");

      out.write("\n");
      out.write("\n");
      out.write("\n");
    if (miSesion1.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


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
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/responsive.css\">\n");
      out.write("        <!-- modernizr css -->\n");
      out.write("        <script src=\"assets/js/vendor/modernizr-2.8.3.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/validaciones/validaciones.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!--[if lt IE 8]>\n");
      out.write("                <p class=\"browserupgrade\">You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/\">upgrade your browser</a> to improve your experience.</p>\n");
      out.write("            <![endif]-->\n");
      out.write("        <!-- preloader area start -->\n");
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
      out.write("                   <div class=\"logo\">\n");
      out.write("                        <a href=\"menu.jsp\"><img src=\"assets/images/logo/n.png\" alt=\"logo\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"main-menu\">\n");
      out.write("                    <div class=\"menu-inner\">\n");
      out.write("                        <nav>\n");
      out.write("                            <ul class=\"metismenu\" id=\"menu\">\n");
      out.write("                                <li><a href=\"menu.jsp\"><i class=\"ti-menu\" style=\"color:orange\"></i><span>Menu</span></a></li>\n");
      out.write("                                <li>\n");
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
      out.write("                            <div class=\"breadcrumbs-area clearfix\">\n");
      out.write("\n");
      out.write("                                <h3>Configuracion</h3>\n");
      out.write("                                ");
 if (request.getAttribute("mensajeError") != null) { 
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-danger alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡ERROR!</strong> No se pudo actualizar al usuario\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                ");

                                } else if (request.getAttribute("mensajeExito") != null) {
                                
      out.write("\n");
      out.write("                                <div class=\"alert alert alert-success alert-dismissable\">\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n");
      out.write("                                    <strong>¡Correcto!</strong> Usuario actualizado Correctamente.\n");
      out.write("                                </div>                                                                                        \n");
      out.write("\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"nav-btn pull-left\">\n");
      out.write("                                <span></span>\n");
      out.write("                                <span></span>\n");
      out.write("                                <span></span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-6 clearfix\">\n");
      out.write("                            <div class=\"user-profile pull-right\"  style=\"background: orange\">\n");
      out.write("                                <img class=\"avatar user-thumb\" src=\"assets/images/author/avatar.png\" alt=\"avatar\">\n");
      out.write("                                <h4 class=\"user-name dropdown-toggle\" data-toggle=\"dropdown\"> ");
      out.print(  clienteVO.getUsuario());
      out.write(" <i class=\"fa fa-angle-down\"></i></h4>\n");
      out.write("                                <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"actualizarUsuario.jsp\">Configuraci+on</a>\n");
      out.write("                                    <form method=\"post\" action=\"close\">\n");
      out.write("                                        <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("                                        <button  class=\"dropdown-item\" >Cerrar sesión</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <h4 class=\"header-title\">Actualización de datos</h4>\n");
      out.write("                        <p class=\"text-muted font-14 mb-4\"> Modifique los datos que desee\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                        <div class=\"container\">                     \n");
      out.write("\n");
      out.write("                            <form method=\"post\" action=\"Cliente\" class=\"needs-validation\">\n");
      out.write("\n");
      out.write("                                <div>\n");
      out.write("                                    <div class=\"row \">\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Nombres:</label>\n");
      out.write("                                                <input type=\"text\" name=\"txtnombre\" pattern=\"[A-Za-z ]{4-16}\"  maxlength=\"20\" min=\"4\" class=\"form-control\" value=\"");
      out.print(clienteVO.getNombre());
      out.write("\" >\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Apellidos:</label>\n");
      out.write("                                                <input type=\"text\" pattern=\"[A-Za-z ]{4-16}\" name=\"txtapellidos\" maxlength=\"20\" min=\"4\" class=\"form-control\" value=\"");
      out.print(clienteVO.getApellidos());
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row \">\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Fecha de nacimiento:</label>\n");
      out.write("                                                <input type=\"date\"  min=\"1930-01-01\" max=\"2003-12-31\" name=\"fecha\" class=\"form-control\" value=\"");
      out.print(clienteVO.getFechaNacimiento());
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Genero:</label>\n");
      out.write("                                                <select name=\"txtgenero\" class=\"form-control\">\n");
      out.write("                                                    <option  value=\"Hombre\">Hombre</option>\n");
      out.write("                                                    <option  value=\"Mujer\">Mujer</option>\n");
      out.write("                                                    <option  value=\"Otro\">Otro</option> \n");
      out.write("                                                    <option  value=\"");
      out.print(clienteVO.getGenero());
      out.write('"');
      out.write('>');
      out.print(clienteVO.getGenero());
      out.write("</option> \n");
      out.write("                                                </select>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row \">\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Correo:</label>\n");
      out.write("                                                <input type=\"email\" class=\"form-control\" name=\"txtcorreo\" class=\"form-control\" value=\"");
      out.print(clienteVO.getCorreo());
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                           \n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Teléfono</label>\n");
      out.write("                                                <input type=\"text\" pattern=\"[0-9]{6-10}\" maxlength=\"10\" minlenght=\"7\"  name=\"telefono\" required class=\"form-control\" value=\"");
      out.print(clienteVO.getTelefono());
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                             <div class=\"row \">\n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Nombre de usuario</label>\n");
      out.write("                                                <input type=\"text\" pattern=\"[A-Za-z]{4-16}\" name=\"txtusuario\" maxlength=\"20\" minlenght=\"4\" class=\"form-control\" value=\"");
      out.print(clienteVO.getUsuario());
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                             \n");
      out.write("                                        <div class=\"col-lg-6 mt-6\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"control-label\">Contraseña:</label>\n");
      out.write("                                                <input type=\"text\" maxlength=\"20\" minlenght=\"8\" name=\"txtclave\" class=\"form-control\" value=\"");
      out.print(clienteVO.getClave());
      out.write("\">\n");
      out.write("                                            </div>     \n");
      out.write("                                        </div>\n");
      out.write("                                             </div>\n");
      out.write("                                            <input type=\"hidden\" value=\"3\" name=\"opcion\" class=\"form-control\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(clienteVO.getIdCliente());
      out.write("\" name=\"txtid\" class=\"form-control\">\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"form-group col-lg-6 col-sm-6 col-6\">\n");
      out.write("                                                    <button class=\"btn btn-warning btn-block\" id=\"btnregistrar\">Actualizar</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>     \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- page title area end -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- main content area end -->\n");
      out.write("            <!-- footer area start-->\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"footer-area\">\n");
      out.write("                    <p>© Copyright 2018. All right reserved. Template by <a href=\"https://colorlib.com/wp/\">Colorlib</a>.</p>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("            <!-- footer area end-->\n");
      out.write("        </div>\n");
      out.write("        <!-- page container area end -->\n");
      out.write("        <!-- offset area start -->\n");
      out.write("        <div class=\"offset-area\">\n");
      out.write("            <div class=\"offset-close\"><i class=\"ti-close\"></i></div>\n");
      out.write("            <ul class=\"nav offset-menu-tab\">\n");
      out.write("                <li><a class=\"active\" data-toggle=\"tab\" href=\"#activity\">Activity</a></li>\n");
      out.write("                <li><a data-toggle=\"tab\" href=\"#settings\">Settings</a></li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <!-- offset area end -->\n");
      out.write("            <!-- jquery latest version -->\n");
      out.write("            <script src=\"assets/js/vendor/jquery-2.2.4.min.js\"></script>\n");
      out.write("            <!-- bootstrap 4 js -->\n");
      out.write("            <script src=\"assets/js/popper.min.js\"></script>\n");
      out.write("            <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("            <script src=\"assets/js/owl.carousel.min.js\"></script>\n");
      out.write("            <script src=\"assets/js/metisMenu.min.js\"></script>\n");
      out.write("            <script src=\"assets/js/jquery.slimscroll.min.js\"></script>\n");
      out.write("            <script src=\"assets/js/jquery.slicknav.min.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- start chart js -->\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\n");
      out.write("            <!-- start highcharts js -->\n");
      out.write("            <script src=\"https://code.highcharts.com/highcharts.js\"></script>\n");
      out.write("            <!-- start zingchart js -->\n");
      out.write("            <script src=\"https://cdn.zingchart.com/zingchart.min.js\"></script>\n");
      out.write("            <script>\n");
      out.write("                zingchart.MODULESDIR = \"https://cdn.zingchart.com/modules/\";\n");
      out.write("                ZC.LICENSE = [\"569d52cefae586f634c54f86dc99e6a9\", \"ee6b7db5b51705a13dc2339db3edaf6d\"];\n");
      out.write("            </script>\n");
      out.write("            <!-- all line chart activation -->\n");
      out.write("            <script src=\"assets/js/line-chart.js\"></script>\n");
      out.write("            <!-- all pie chart -->\n");
      out.write("            <script src=\"assets/js/pie-chart.js\"></script>\n");
      out.write("            <!-- others plugins -->\n");
      out.write("            <script src=\"assets/js/plugins.js\"></script>\n");
      out.write("            <script src=\"assets/js/scripts.js\"></script>\n");
      out.write("    </body>\n");
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
