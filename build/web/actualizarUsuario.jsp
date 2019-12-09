<%-- 
    Document   : actualizarUsuario.jsp
    Created on : 23/10/2019, 08:55:02 PM
    Author     : junior
--%>

<%@page import="VO.ClienteVO"%>

<%
    HttpSession miSesion1 = (HttpSession) request.getSession();
    ClienteVO clienteVO = (ClienteVO) miSesion1.getAttribute("clievo");
%>


<%    if (miSesion1.getAttribute("validar") == null) {
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

                                <h3>Configuracion</h3>
                                <% if (request.getAttribute("mensajeError") != null) { %>
                                <div class="alert alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡ERROR!</strong> No se pudo actualizar al usuario
                                </div>

                                <%
                                } else if (request.getAttribute("mensajeExito") != null) {
                                %>
                                <div class="alert alert alert-success alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡Correcto!</strong> Usuario actualizado Correctamente.
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
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"> <%=  clienteVO.getUsuario()%> <i class="fa fa-angle-down"></i></h4>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="actualizarUsuario.jsp">Configuraci+on</a>
                                    <form method="post" action="close">
                                        <input type="hidden" name="opcion" value="1">
                                        <button  class="dropdown-item" >Cerrar sesión</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <h4 class="header-title">Actualización de datos</h4>
                        <p class="text-muted font-14 mb-4"> Modifique los datos que desee
                        </p>

                        <div class="container">                     

                            <form method="post" action="Cliente" class="needs-validation">

                                <div>
                                    <div class="row ">
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Nombres:</label>
                                                <input type="text" name="txtnombre" pattern="[A-Za-z ]{4-16}"  maxlength="20" min="4" class="form-control" value="<%=clienteVO.getNombre()%>" >
                                            </div>
                                        </div>
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Apellidos:</label>
                                                <input type="text" pattern="[A-Za-z ]{4-16}" name="txtapellidos" maxlength="20" min="4" class="form-control" value="<%=clienteVO.getApellidos()%>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row ">
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Fecha de nacimiento:</label>
                                                <input type="date"  min="1930-01-01" max="2003-12-31" name="fecha" class="form-control" value="<%=clienteVO.getFechaNacimiento()%>">
                                            </div>
                                        </div>
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Genero:</label>
                                                <select name="txtgenero" class="form-control">
                                                    <option  value="Hombre">Hombre</option>
                                                    <option  value="Mujer">Mujer</option>
                                                    <option  value="Otro">Otro</option> 
                                                    <option  value="<%=clienteVO.getGenero()%>"><%=clienteVO.getGenero()%></option> 
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row ">
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Correo:</label>
                                                <input type="email" class="form-control" name="txtcorreo" class="form-control" value="<%=clienteVO.getCorreo()%>">
                                            </div>
                                        </div>
                                           
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Teléfono</label>
                                                <input type="text" pattern="[0-9]{6-10}" maxlength="10" minlenght="7"  name="telefono" required class="form-control" value="<%=clienteVO.getTelefono()%>">
                                            </div>
                                        </div>
                                    </div>
                                             <div class="row ">
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Nombre de usuario</label>
                                                <input type="text" pattern="[A-Za-z]{4-16}" name="txtusuario" maxlength="20" minlenght="4" class="form-control" value="<%=clienteVO.getUsuario()%>">
                                            </div>
                                        </div>
                                             
                                        <div class="col-lg-6 mt-6">
                                            <div class="form-group">
                                                <label class="control-label">Contraseña:</label>
                                                <input type="text" maxlength="20" minlenght="8" name="txtclave" class="form-control" value="<%=clienteVO.getClave()%>">
                                            </div>     
                                        </div>
                                             </div>
                                            <input type="hidden" value="3" name="opcion" class="form-control">
                                            <input type="hidden" value="<%=clienteVO.getIdCliente()%>" name="txtid" class="form-control">
                                            <div class="row">
                                                <div class="form-group col-lg-6 col-sm-6 col-6">
                                                    <button class="btn btn-warning btn-block" id="btnregistrar">Actualizar</button>
                                                </div>
                                            </div>
                                            </form>
                                        </div>
                                    </div>


                                </div>

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
