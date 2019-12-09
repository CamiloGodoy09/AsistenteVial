<%-- 
    Document   : Menu
    Created on : 23/10/2019, 02:34:08 PM
    Author     : junior
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DaoTaller"%>
<%@page import="VO.BeanTaller"%>
<%@page import="VO.PropietarioVO"%>


<%
    HttpSession miSesion = (HttpSession) request.getSession();
    PropietarioVO propietariovo = (PropietarioVO) miSesion.getAttribute("pvo");

%>

<%    DaoTaller dao = new DaoTaller();
    ArrayList<BeanTaller> talleres = dao.BuscarTalleres(propietariovo.getIdPropietario());
%>


<%    if (miSesion.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

%>



<!doctype html>
<html class="no-js" lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Asistente vial</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/metisMenu.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/slicknav.min.css">
        <!-- amchart css -->
        <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
        <!-- others css -->
        <link rel="stylesheet" href="assets/css/typography.css">
        <link rel="stylesheet" href="assets/css/default-css.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <!-- modernizr css -->
        <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
        <link rel="stylesheet" href="assets/css/responsive.css">
        <script src="assets/js/validaciones/validaciones.js" type="text/javascript"></script>
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
    </head>

    <body>


        <div id="preloader">
            <div class="loader"></div>
        </div>
        <!-- preloader area end -->
        <!-- page container area start -->
        <div class="page-container">
            <!-- sidebar menu area start -->
            <div class="sidebar-menu">
                <div class="sidebar-header">
                    <div class="logo">
                        <a href="menuTaller.jsp"><img src="assets/images/logo/n.png" alt="logo"></a>
                    </div>
                </div>
                <div class="main-menu">
                    <div class="menu-inner">
                        <nav>
                            <ul class="metismenu" id="menu">
                                <li><a href="menuTaller.jsp"><i class="ti-menu" style="color:orange"></i> <span>Menu</span></a></li>
                                <li>
                                    <a href="javascript:void(0)" aria-expanded="true"><i class="ti-dashboard" style="color:orange"></i><span>Talleres</span></a>
                                    <ul class="collapse">
                                        <li><a href="registroTaller.jsp">Registrar nuevo Taller</a></li>
                                        <li><a href="actualizarTaller.jsp">Actualizar Talleres</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="javascript:void(0)" aria-expanded="true"><i class="ti-layout-sidebar-left" style="color:orange"></i><span>Mapa
                                        </span></a>
                                    <ul class="collapse">
                                        <li><a href="alarmas.jsp">Revisar Alarmas</a></li>
                                        <li><a href="reporteAlarmas.jsp">Generar Reporte</a></li>
                                        <li><a href="menu_taller.jsp"> Alarmas entrantes </a></li>
                                    </ul>
                                </li>

                                <li><a href="procedimiento.jsp"><i class="ti-info" style="color:orange"></i> <span>Procedimientos</span></a></li>


                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- sidebar menu area end -->
            <!-- main content area start -->
            <div class="main-content">
                <!-- header area start -->

                <!-- header area end -->
                <!-- page title area start -->
                <div class="page-title-area">
                    <div class="row align-items-center">
                        <div class="col-sm-6">

                            <div class="breadcrumbs-area clearfix">

                                <% if (request.getAttribute("mensajeError") != null) { %>
                                <div class="alert alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡ERROR!</strong> Revise los datos e intente actualizar Nuevamente.
                                </div>

                                <%
                                } else if (request.getAttribute("mensajeExito") != null) {
                                %>
                                <div class="alert alert alert-success alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡Correcto!</strong>Se actualizó el taller correctamente.
                                </div>
                                <% }%>
                            </div>
                            <div class="nav-btn pull-left">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </div>
                        <div class="col-sm-6 clearfix">
                            <div class="user-profile pull-right" style="background: orange">
                                <img class="avatar user-thumb" src="assets/images/author/avatar.png" alt="avatar">
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"><%= propietariovo.getUsuario()%> ><i class="fa fa-angle-down"></i></h4>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="actualizarPropietario.jsp">Configuración</a>
                                    <form method="post" action="close">
                                        <input type="hidden" name="opcion" value="2">
                                        <button  class="dropdown-item" >Cerrar sesión</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container"> 
                        <div class="card-body"> 
                            <h3> Actualizar talleres </h3>

                        </div>

                        <div card-body>


                            <form method="post" action="actualizarTaller">
                                <label for="exampleInputPassword2">Nit Taller</label>
                                <input type="number" placeholder="Ingrese el nit de su taller" name="txtid"class="form-control"  required>
                                <input type="hidden" value="<%= propietariovo.getIdPropietario()%>" name="identificacion">
                                <i class=""></i>
                                <input type="hidden" name="opcion" value="2">
                                <br>

                                <div class="form-group col-lg-6 col-sm-6 col-6 control-label" >
                                    <button class="btn btn-warning btn-block" id="btnregistrar">Buscar</button>
                                </div>                          
                            </form>


                            <% if (request.getAttribute("usuarioInvalido") != null) { %>
                            <div class="alert alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡ERROR!</strong> Ese taller no existe.
                            </div>

                            <% } %>

                            <%

                                BeanTaller VO = (BeanTaller) request.getAttribute("VoLleno");
                                if (VO != null) {

                            %>
                            <br>
                            <h3>Actualizar Datos</h3>
                            <br>
                            <form method="post" action="actualizarTaller" class="needs-validation">
                                <div class="row ">
                                    <div class="col-lg-6 mt-6">
                                        <input type="hidden"   name="identificacion" value="<%= VO.getNiTaller()%>">
                                        <label>Taller</label>  
                                        <input type="text" class="form-control" name="txtnombretaller"  value="<%=VO.getNombreTaller()%>">
                                    </div>

                                    <div class="col-lg-6 mt-6">
                                      
                                        <label>Teléfono</label>
                                        <input type="number" class="form-control" name="txttelefono" value="<%=VO.getTelefono()%>">
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="col-lg-6 mt-6">
                                        <label> Correo</label>
                                        <input type="email" class="form-control" name="txtcorreo" value="<%=VO.getCorreo()%>">
                                    </div>

                                    <div class="col-lg-6 mt-6">                                   
                                        <label> Dirección </label>
                                        <input type="text"  class="form-control" name="txtdireccion" value="<%=VO.getDireccion()%>">
                                    </div>
                                </div>
                                <label>categoria</label><br>
                                <select name="txtcategoria" class="form-control" >
                                    <option value="<%=VO.getCategoria()%>"> <%=VO.getCategoria()%> </option>
                                    <option value="Taller"> Mecánica General </option> 
                                    <option value="Electricos"> Eléctricos </option> 
                                    <option value="Reparación de llantas"> Reparación de llantas </option> 
                                    <option value="Servicio y lubricacion"> Servicio y lubricacion </option> 
                                </select>    <br><br>
                                <input type="hidden" class="form-control" name="txtcalificacion" value="<%=VO.getCalificacion()%>">

                                <input type="hidden" name="img" value="<%= VO.getLogo()%>">
                                <input type="hidden" name="opcion" value="1">
                                <div class="row">
                                    <div class="form-group col-lg-6 col-sm-6 col-6 control-label" >
                                        <button class="btn btn-warning btn-block" id="btnregistrar">Actualizar</button>
                                    </div>
                                </div>
                            </form>
                            <% } %>

                        </div>
                        <div class="col-lg-6 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="header-title">¿Mis talleres?</h4>
                                    <button type="button" class="btn btn-warning btn-flat btn-lg mt-3" data-toggle="modal" data-target="#tabla">Consultar</button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="tabla">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title"> Sus talleres </h5>
                                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                                </div>
                                                <div class="modal-body">

                                                    <table border="1px solid" class="table table-striped table-bordered" id="example">
                                                        <thead class="table-dark">
                                                            <tr>
                                                                <th>Nombre</th>
                                                                <th>Telefono</th>
                                                                <th>dirección taller</th>
                                                                <th>NitTaller</th>

                                                            </tr>
                                                        </thead>

                                                        <%for (int i = 0; i < talleres.size(); i++) {%>
                                                        <tbody>
                                                            <tr>
                                                                <td><%=talleres.get(i).getNombreTaller()%></td>
                                                                <td><%=talleres.get(i).getTelefono()%></td>
                                                                <td><%=talleres.get(i).getDireccion()%></td>
                                                                <td><%=talleres.get(i).getNiTaller()%></td>

                                                            </tr>
                                                        </tbody>
                                                        <% }%>
                                                    </table>

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


    <script>
        var longitud, latitud;
        window.addEventListener('load', obtener, false);
        function obtener() {
            longitud = document.getElementById("longi");
            latitud = document.getElementById("lat");
            navigator.geolocation.getCurrentPosition(mostrar, gestionarErrores);
        }
        function mostrar(posicion) {
            if (navigator.geolocation) {

                var lat = posicion.coords.latitude;
                var lng = posicion.coords.longitude;
                longitud.value = lng;
                latitud.value = lat;

            }
        }
        function gestionarErrores(error) {
            alert('Error: ' + error.code + ' ' + error.message + '\n\nPor favor compruebe que está conectado ' +
                    'a internet y habilite la opción permitir compartir ubicación física');

        }
    </script>

</div>

</div>
<!-- page title area end -->

</div>
<!-- main content area end -->
<!-- footer area start-->
<footer>
    <div class="footer-area">
        <p>© Copyright 2018. All right reserved. Template by <a href="https://colorlib.com/wp/">Colorlib</a>.</p>
    </div>
</footer>
<!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<div class="offset-area">
    <div class="offset-close"><i class="ti-close"></i></div>
    <ul class="nav offset-menu-tab">
        <li><a class="active" data-toggle="tab" href="#activity">Activity</a></li>
        <li><a data-toggle="tab" href="#settings">Settings</a></li>
    </ul>

    <!-- offset area end -->
    <!-- jquery latest version -->
    <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/jquery.slimscroll.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>

    <!-- start chart js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <!-- start highcharts js -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <!-- start zingchart js -->
    <script src="https://cdn.zingchart.com/zingchart.min.js"></script>
    <script>
        zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
        ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "ee6b7db5b51705a13dc2339db3edaf6d"];
    </script>
    <!-- all line chart activation -->
    <script src="assets/js/line-chart.js"></script>
    <!-- all pie chart -->
    <script src="assets/js/pie-chart.js"></script>
    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
</body>

</html>
