<%-- 
    Document   : alarma.jsp
    Created on : 23/10/2019, 08:26:16 PM
    Author     : junior
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DaoTaller"%>
<%@page import="VO.BeanTaller"%>
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

<%   BeanTaller bvtaller = new BeanTaller();
    DaoTaller dvtaller = new DaoTaller(bvtaller);
    ArrayList<BeanTaller> lista = dvtaller.consultaTalleres();
    for (int i = 0; i < lista.size(); i++) {
        bvtaller = lista.get(i);
    }


%>

<!doctype html>
<html class="no-js" lang="es">

    
        <%-- Link de las alarmas --%>
    <head>
        <link rel="stylesheet" href="http://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <link href="assets/css/cssAlarma/gh-fork-ribbon.css" rel="stylesheet" type="text/css"/>
        <script src="http://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="assets/js/alarma/crearAlertaMaps.js" type="text/javascript"></script>
        <script src="assets/js/alarma/alerta.js" type="text/javascript"></script>
        <script src="assets/js/alarma/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="assets/js/alarma/leaflet-providers.js" type="text/javascript"></script>
        <script src="assets/js/alarma/jquery-3.4.1.min.js" type="text/javascript"></script>
        <title>Consultar</title>
        <style>
            #map{
                height:400px;
                width:100%;

            }
        </style>      
        <%-- Link de los estilos de la pagina --%>  
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Asistente vial</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/metisMenu.css">
        <!-- <script src="https://cdn.jsdelivr.net/npm/promise-polyfill@8/dist/polyfill.js"></script> -->

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
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
    </head>

    <body>
        <input type="hidden" value="<%=miSesion1.getAttribute("idusuario")%>" id="idusuario"/>       <!--[if lt IE 8]>
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
                                <li><a href="menu.jsp"><i class="ti-menu" style="color: orange"></i><span>Menu</span></a></li>
                                <li >
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

                                <h3>Alarma</h3>
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
                                    <strong>¡Correcto!</strong> Su vehiculo se registró correctamente.
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
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"> <%= clienteVO.getUsuario() %> <i class="fa fa-angle-down"></i></h4>
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
                        <h4 class="header-title">Generar Alarma</h4>
                        <p class="text-muted font-14 mb-4">Pensado en todos los imprevistos que se pueden presentar en un auto 
                            a la hora de viajar, se diseñó ésta alarma, para poder contactar con los talleres mas cercanos a su localización
                            y poder solucionar de manera rápida su imprevisto.
                        </p>
                        <div class="col-lg-12 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <div id="map"></div>
                                    <script type="text/javascript">

                                        var map = L.map('map', {
                                            center: [4.5700001, -74.1167465],
                                            zoom: 10,
                                            zoomControl: true
                                        });
                                        var defaultLayer = L.tileLayer.provider('OpenStreetMap.Mapnik').addTo(map);

                                        <%for (int i = 0; i < lista.size(); i++) {
                                                bvtaller = lista.get(i);%>

                                        var marker<%=i%> = L.marker([<%=bvtaller.getLatitud()%>, <%=bvtaller.getLongitud()%>]);
                                        marker<%=i%>.on('click', function () {
                                            popup<%=i%>.openOn(map);
                                        })
                                        var popup<%=i%> = L.popup()
                                                .setLatLng([<%=bvtaller.getLatitud()%>, <%=bvtaller.getLongitud()%>])
                                                .setContent('<p>nombre: <%=bvtaller.getNombreTaller()%><br>telefono:  <%=bvtaller.getTelefono()%><br> direccion:<%=bvtaller.getDireccion()%><br>correo:<%=bvtaller.getCorreo()%> </p><br>\n\
                                    <button class="btn btn-warning" onclick="traerId(this.value)"class="alertar" value="<%=bvtaller.getNiTaller()%>" >Crear Alerta</button>')

                                        marker<%=i%>.addTo(map)

                                        <% }%>


                                    </script>



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
