<%-- 
    Document   : procedimiento.jsp
    Created on : 24/10/2019, 10:44:26 AM
    Author     : APRENDIZ
--%>

<%-- 
    Document   : Menu
    Created on : 23/10/2019, 02:34:08 PM
    Author     : junior
--%>
<%@page import="VO.PropietarioVO"%>


<%
    HttpSession miSesion = (HttpSession) request.getSession();
    PropietarioVO propietariovo = (PropietarioVO) miSesion.getAttribute("pvo");
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
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- modernizr css -->
        <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
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
                                
                                   <h4>Procedimiento</h4>
                                    <div class="breadcrumbs-area clearfix">

                            
                                 <% if (request.getAttribute("mensajeError") != null) { %>
                            <div class="alert alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡ERROR!</strong> No se pudo registrar el procedimiento.
                            </div>

                            <%
                                } else if (request.getAttribute("mensajeExitoso") != null) { 
                            %>
                             <div class="alert alert alert-success alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡Correcto!</strong>Procedimiento registrado exitosamente.
                            </div>
                                <% } %>
                            </div>
                            <div class="nav-btn pull-left">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                            </div>
                        </div>
                        <div class="col-sm-6 clearfix">
                            <div class="user-profile pull-right" style="background: orange">
                                <img class="avatar user-thumb" src="assets/images/author/avatar.png" alt="avatar">
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"><%= propietariovo.getUsuario() %> ><i class="fa fa-angle-down"></i></h4>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="actualizarPropietario.jsp">Configuracion</a>
                                     <form method="post" action="close">
                                        <input type="hidden" name="opcion" value="2">
                                        <button  class="dropdown-item" >Cerrar sesión</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                            
                    <div class="row">
                     
                        <div class="col-lg-6 mt-5">
                          
                            <form class="card-body" action="Procedimiento" method="post" class="needs-validation">
                                <div class="row" >

                                    <div class="col-md-12 mb-12">
                                        <div class="md-form ">
                                            <label for="firstName" class="" >Id</label>
                                            <input type="text" required placeholder="Ingrese el numero que identifica la alarma del cliente" id="firstName" class="form-control" name="txtid" maxlength="10" min="4"><br>
                                        </div>
                                    </div>

                                    <div class="col-md-12 mb-12">
                                        <label>Tipo</label>
                                        <select name="txtTiprocedimiento" class="form-control">
                                            <option value="cambiollantas" class="form-control" >Cambio de llantas</option>
                                            <option value="electrico" class="form-control" >Electrico</option>
                                            <option value="suspension" class="form-control" >Suspensión</option>
                                            <option value="frenos" class="form-control" >Frenos</option>
                                        </select>

                                    </div>

                                    <div class="col-md-12 mb-12">
                                        <div class="md-form ">
                                            <label for="firstName" class="" >Procedimiento</label>
                                            <textarea required id="firstName" placeholder="Ingrese el procedimiento"class="form-control" name="txtprocedimiento" ></textarea>
                                        </div>
                                    </div>

                                    <div class="col-md-12 mb-12">
                                        <div class="md-form ">
                                            <label for="firstName" class="" >Costo</label>
                                            <input required type="text" placeholder="Ingrese los costos del procedimiento" id="firstName" class="form-control" maxlength="10" min="4" name="txtcostos"><br>
                                        </div>
                                    </div>

                                    <div class="col-md-12 mb-12">

                                        <button class="btn btn-warning btn-block"  >Registrar</button>
                                        <input type="hidden"  value="1" name="opcion">
                                    </div>

                                </div>
                            </form> 
                            
                        </div>
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
