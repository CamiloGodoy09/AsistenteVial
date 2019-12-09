7<%-- 
    Document   : Menu
    Created on : 23/10/2019, 02:34:08 PM
    Author     : junior
--%>
<!doctype html>
<%@page import="VO.ClienteVO"%>

<%
    HttpSession miSesion1 = (HttpSession) request.getSession();
    ClienteVO clienteVO = (ClienteVO) miSesion1.getAttribute("clievo");
%>


<%    if (miSesion1.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

%>


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
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- modernizr css -->
        <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
        <script src="https://h5p.org/sites/all/modules/h5p/library/js/h5p-resizer.js" charset="UTF-8"></script>
        <script src="assets/js/validaciones/validaciones.js" type="text/javascript"></script>
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
    </head>

    <body>
        <!--[if lt IE 8]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
        <!-- preloader area start -->

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
                        <a href="menu.jsp"><img src="assets/images/logo/n.png" alt="logo"></a>
                    </div>
                </div>
                <div class="main-menu">
                    <div class="menu-inner">
                        <nav>
                            <ul class="metismenu" id="menu">
                                <li><a href="menu.jsp"><i class="ti-menu" style="color:orange"></i><span>Menu</span></a></li>
                                <li>
                                    <a href="javascript:void(0)" aria-expanded="true"><i class="ti-dashboard" style="color:orange"></i><span>Vehiculo</span></a>
                                    <ul class="collapse">
                                        <li><a href="registroVehiculo.jsp">Registrar nuevo Vehiculo</a></li>
                                        <li><a href="actualizarVehiculo.jsp">Actualizar el vehiculo</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="javascript:void(0)" aria-expanded="true"><i class="ti-layout-sidebar-left" style="color:orange"></i><span>Soporte
                                        </span></a>
                                    <ul class="collapse">
                                        <li><a href="soporte.jsp">Revisar soporte</a></li>

                                    </ul>
                                </li>

                                <li><a href="alarma.jsp"><i class="ti-map-alt" style="color:orange"></i> <span>Alarma</span></a></li>
                                <li><a href="alarmaAceptadas.jsp"><i class="fa fa-bell" style="color:orange"></i> <span>Alarmas aceptadas</span></a></li>


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

                                <h3>Soporte</h3>
                                <% if (request.getAttribute("mensajeError") != null) { %>
                                <div class="alert alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡ERROR!</strong>No se pudo enviar el comentario , intente nuevamente
                                </div>

                                <%
                                } else if (request.getAttribute("mensajeExitoso") != null) {
                                %>
                                <div class="alert alert alert-success alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡Correcto!</strong> Su Comentario fue enviado correctamente
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
                            <div class="user-profile pull-right"  style="background: orange">
                                <img class="avatar user-thumb" src="assets/images/author/avatar.png" alt="avatar">
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"> <%= clienteVO.getUsuario()%> <i class="fa fa-angle-down"></i></h4>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="actualizarUsuario.jsp">Configuración</a>
                                   <form method="post" action="close">
                                        <input type="hidden" name="opcion" value="1">
                                        <button  class="dropdown-item" >Cerrar sesión</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <h4 class="header-title">Soporte para usuarios</h4>
                        <p class="text-muted font-14 mb-4">Pensando en los nuestros futuros usuarios , hemos diseñado
                            un soporte para que los nuevos usuarios puedan entender todas las funciones que esta posee, y le saquen el mayor
                            probecho a este su ASISTENTE VIAL.
                        </p>

                    </div> 

                    <div class="card-body">

                        <iframe src="https://h5p.org/h5p/embed/670151" width="1090" height="674" frameborder="0" allowfullscreen="allowfullscreen"></iframe><script src="https://h5p.org/sites/all/modules/h5p/library/js/h5p-resizer.js" charset="UTF-8"></script>
                    </div>  



                </div>        


            </div>
            <div class="container">
                <form action="Soporte" method="post" class="needs-validation">
                    <h4 class="header-title">Comentario</h4>                                          
                    <input type="hidden" max="10000000000" min="10000000" name="idCliente"class="form-control"  value="<%= clienteVO.getIdCliente()%> ">

                    <div class="md-form ">
                        <textarea id="firstName" class="form-control" placeholder="¿Deseas comentarnos algo?" name="txtcomentario"></textarea>
                    </div>

                    <input type="hidden" name="txtUsuario" value=" <%= clienteVO.getUsuario()%>">
                    <input type="hidden" name="opcion" value="1">
                    <br>
                    <button class="btn btn-warning" id="btnregistrar">Enviar Comentario</button>

                </form>





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
