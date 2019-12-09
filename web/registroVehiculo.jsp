<%-- 
    Document   : RegistroVehiculo
    Created on : 23/10/2019, 07:18:36 PM
    Author     : junior
--%>
<%-- 
    Document   : Menu
    Created on : 23/10/2019, 02:34:08 PM
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
        <script src="assets/js/validaciones/validaciones.js" type="text/javascript"></script>
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
        <script src="assets/js/alarma/buscadorAlarmasAceptadas.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="assets/js/validaciones/validaciones.js" type="text/javascript"></script>
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
    </head>

    <body>
        <input type="hidden" value="<%=miSesion1.getAttribute("idusuario")%>" id="idusuario"/> 
        <!--[if lt IE 8]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
        <!-- preloader area start -->


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
                                <li><a href="menu.jsp"><i class="ti-menu" style="color: orange"></i><span>Menu</span></a></li>
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
                    <div class="container">
                         <div class="breadcrumbs-area clearfix">


                                <% if (request.getAttribute("mensajeError") != null) { %>
                                <div class="alert alert alert-danger alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡ERROR!</strong> Revise los datos e intente nuevamente.
                                </div>

                                <%
                                } else if (request.getAttribute("mensajeExito") != null) {
                                %>
                                <div class="alert alert alert-success alert-dismissable">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <strong>¡Correcto!</strong> Su vehículo se registró correctamente.
                                </div>
                                <% }%>
                            </div>
                        
                        
                        <h3>Vehículo</h3>
                        <div class="card-body">
                            <h4 class="header-title">Registro de un nuevo Vehículo.</h4>
                            <p class="text-muted font-14 mb-4">Porfavor ingrese todos los datos solicitados.</p>

                            <form method="post" action="Vehiculo" class="needs-validation">
                                <div class="row ">
                                    <div class="col-lg-6 mt-6">
                                        <div class="form-group">
                                            <label  class="control-label">Placa</label>
                                            <input type="text" name="txtplaca" maxlength="7" class="form-control"  pattern="[A-Z]{3}[-]\d{3}" placeholder="RKL-345" required="required">
                                            <span class="spanOb"> *Obligatorio </span>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 mt-6">
                                        <div class="form-group">
                                            <label class="control-label">Tipo</label>
                                            <select name="txtTipo" class="form-control">
                                                <option  value="Carro">Carro</option>
                                                <option  value="Camion">Camion</option> 
                                                <option  value="Bus">Bus</option> 
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                 <div class="row ">
                                    <div class="col-lg-6 mt-6">
                                <div class="form-group">
                                    <label for="usr" class="control-label">Marca</label>
                                    <input type="text" maxlength="10" pattern="[A-Za-z ]{4-16}" min="4" name="txtmarca" class="form-control" placeholder="DIGITE LA MARCA DE SU VEHÍCULO   (ejemplo: nissan)" required>
                                    <span class="spanOb"> *Obligatorio </span>
                                </div>
                                    </div>
                                     <div class="col-lg-6 mt-6">
                                  <div class="form-group">
                                        <label class="control-label" for="usr">Cilindraje</label>
                                        <input type="number" min="100" max="1600"  name="txtcilindraje" placeholder="DIGITE EL CILINDRAJE   (ejemplo: 200)" maxlength="6" class="form-control" required>
                                        <span class="spanOb"> *Obligatorio </span>

                                        <input type="hidden" value="1" name="opcion">
                                    </div>
                                     </div>
                                 </div>
                                     
                                <div class="row">

                                    <div class="col-lg-6 mt-6">
                                        <div class="form-group">
                                            <label for="usr" class="control-label">Modelo</label>
                                            <input type="number"  min="1000" max="3000"  name="txtmodelo" class="form-control" placeholder="DIGITE EL MODELO (ejemplo: 2015)" required>
                                            <span class="spanOb"> *Obligatorio </span>
                                        </div>
                                    </div>
                                              
                                        <input type="hidden" value="<%= clienteVO.getIdCliente()%>"  name="txtid" class="form-control" placeholder="DIGITE SU IDENTIFICACIÓN" required>
                                  
                                    <div class="col-lg-6 mt-6">
                                        <div class="form-group">
                                            <label for="usr" class="control-label">Color</label>
                                            <input type="text" pattern="[A-Za-z ]{4-16}"  maxlength="20" min="4" name="txtcolor" class="form-control" placeholder="DIGITE EL COLOR DE SU VEHÍCULO   (ejemplo: azul)" required>
                                            <span class="spanOb"> *Obligatorio </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="col-lg-6 mt-6">
                                        <div class="form-group">
                                            <label for="usr" class="control-label">Carrocería</label>
                                            <select name="txtcarroceria" class="form-control">
                                                <option  value="Con carroceria">Con carroceria</option>
                                                <option  value="Sin carroceria">Sin carroceria</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 mt-6">
                                    <div class="form-group">
                                        <label class="control-label" for="usr">Servicio</label>
                                        <select name="txtservicio" class="form-control">
                                            <option  value="Publico">Público</option>
                                            <option  value="Particular">Particular</option>

                                        </select>
                                    </div>
                                    </div>
                                </div>
                                  
                                    <div class="form-group">
                                        <label for="usr">Tarjeta de propiedad:</label>
                                        <input type="file" accept=".pdf" name="tarjeta" id="imgfoto" class="form-control" required><br>
                                        <span class="spanOb"> *Obligatorio </span>
                                    </div> 
                                    <div class="row">
                                        <div class="form-group col-lg-6 col-sm-6 col-6 control-label" >
                                            <button class="btn btn-warning btn-block" id="btnregistrar">Registrar</button>
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
