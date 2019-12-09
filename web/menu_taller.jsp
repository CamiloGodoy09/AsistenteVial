

<%@page import="VO.PropietarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DaoTaller"%>
<%@page import="VO.BeanTaller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession miSesion = (HttpSession) request.getSession();
    PropietarioVO propietariovo = (PropietarioVO) miSesion.getAttribute("pvo");
%>


<%    if (miSesion.getAttribute("validar") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

%>
<%    BeanTaller bvtaller = new BeanTaller();
    DaoTaller dvtaller = new DaoTaller(bvtaller);
    ArrayList<BeanTaller> lista = dvtaller.consultaTalleres();
    for (int i = 0; i < lista.size(); i++) {
        bvtaller = lista.get(i);
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <link rel="stylesheet" href="assets/css/cssAlarma/gh-fork-ribbon.css" />


        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="assets/js/alarma/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/js/alarma/notificacionJS.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="assets/js/alarma/crearAlertaMaps.js" type="text/javascript"></script>

        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.7.1/less.js"></script>
        <script src="http://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
        <script src="assets/js/alarma/leaflet-providers.js"></script>
<link rel="icon" type="image/png" href="assets/images/Icono.ico">
        <style>

            #modal {
                background: rgba(0, 0, 0, 0.9) !important;
                position: fixed !important;
                top: -100vh !important;
                left: 0 !important;
                height: 100vh !important;
                width: 100vw !important;
                transition: all .5s;
                z-index: 2 !important;
            }
           
            #mensaje{
                color:white !important;
                padding: 15px !important;
            }


            #mostrar-modal {
                display: none !important;
            }
            #mostrar-modal + label {
                display: none !important;
            }

            #mostrar-modal:checked ~ #modal {
                top: 0 !important; 
            }
            #mostrar-modal:checked ~ #cerrar-modal + label {
                display: block !important;
            }

            #cerrar-modal {
                display: none !important;
            }
            #cerrar-modal + label {
                position: absolute !important;
                top: 1em !important;
                right: 1em !important;
                z-index: 100 !important;
                color: #fff !important;
                font-weight: bold !important;
                cursor: pointer !important;
                background: tomato !important;
                width: 25px !important;
                height: 25px !important;
                line-height: 25px !important;
                text-align: center !important;
                border-radius: 50% !important;
                display: none !important;
                transition: all .5s !important;
            }
            #cerrar-modal:checked ~ #modal {
                top: -100vh !important;
            }
            #cerrar-modal:checked + label {
                display: none !important;
            }
            /* Set the size of the div element that contains the map */
            #map {
                height: 400px;  /* The height is 400 pixels */
                width: 100%;  /* The width is the width of the web page */
            }
        </style>
    </head>
    <body>
       
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
            <div class="main-content">

                <input type="radio" id="mostrar-modal" name="modal"/>
                <label id="abrirModal"for="mostrar-modal" class="btn btn-warning">Ver modal</label>

                <input type="radio" id="cerrar-modal" name="modal" class="cerrarModal"/>
                <label for="cerrar-modal">X</label>

                <div id="modal">
                    <h2 id="mensaje">¡Alerta! Alguien Quiere Contactarte.</h2>
                    <script>

                    </script>
                    <main class="container">
                        <div class="row rows">

                        </div>
                    </main>

                </div>


                <div class="modal fade" id="mapa" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Ubicación</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div id="map"></div>
                                
                                <a id="clienteAlarma" class="btn btn-warning" >Aceptar</a>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="page-title-area">
                    <div class="row align-items-center">
                        <div class="col-sm-6">
                            <div class="breadcrumbs-area clearfix">

                                <img src="assets/images/logo/n.png" alt=""/>
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
                                <h4 class="user-name dropdown-toggle" data-toggle="dropdown"> <%= propietariovo.getUsuario() %> <i class="fa fa-angle-down"></i></h4>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="actualizarUsuario.jsp">Configuración</a>
                                    <form method="post" action="close">
                                        <button  class="dropdown-item" >Cerrar sesión</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-6 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="header-title">¿Requieres ayuda urgente de un taller mecánico?</h4>
                                    <p>Con asistente vial ya no será un problema.</p>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-warning btn-flat btn-lg mt-3" data-toggle="modal" data-target="#exampleModalLong">Leer mas</button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModalLong">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title"> Nuestros talleres</h5>
                                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Como usuario podrás elegir el tipo de taller que desees, además recibirás gran cantidad de propuestas de diferentes talleres y diferentes precios.
                                                    </p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="col-lg-6 mt-5">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="header-title">¿Son muy costosos los servicios de la página?</h4>
                                    <p>Alta facilidad en sus pagos.</p>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-warning     btn-flat btn-lg mt-3" data-toggle="modal" data-target="#precio">Leer mas</button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="precio">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title">  Facilidad de costos </h5>
                                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                                                </div>
                                                <div class="modal-body">
                                                    <p> Como usuario tendrás la ventaja de que los servicios de la página son gratuitos, y los precios que manejen los talleres podrán ser de su comodidad ya que usted elije el taller
                                                    </p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                    <a href="../../../Downloads/Icono.ico"></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- page title area end -->

            </div>


    </body>
