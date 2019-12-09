<%-- 
    Document   : index
    Created on : 23/10/2019, 01:38:30 PM
    Author     : junior
--%>
<!doctype html>


<html class="no-js" lang="en">

    <head>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Inicio de Sesión</title>
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
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
        <style>
            body{
                background-image: url(assets/images/Bogota.jpeg);
                background-size: cover;

            }
            #txtpropi {
                margin: 20px 130px;
                color: #443963;
                font-weight: normal;
                font-size: 30px;
                text-transform: lowercase;
            }

        </style>
    </head>

    <body >
        <!--[if lt IE 8]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
        <!-- preloader area start -->
        <div id="preloader">
            <div class="loader"></div>
        </div>
        <!-- preloader area end -->
        <!-- login area start -->
        <div class="login-area" style="background: url('')" >
            <div class="container">
                <div class="login-box ptb--100" >
                    <form method="post" action="Cliente">
                        <div class="login-form-head" style="background: rgba(235, 232, 230, 1)">
                            <img src="assets/images/logo/n.png" alt=""/>

                        </div>
                       
                        <div class="login-form-body">
                            <% if (request.getAttribute("mensajeError") != null) { %>
                            <div class="alert alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡ERROR!</strong> Usuario o Contraseña incorrectos.
                            </div>

                            <%
                            } else if (request.getAttribute("registroExitoso") != null) {
                            %>
                            <div class="alert alert alert-success alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡Correcto!</strong> Registro exitoso
                            </div>                                                                                        

                            <% } else if (request.getAttribute("EncontradoUsuario") != null) { %>
                            <div class="alert alert alert-primary alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>¡Correcto!</strong> Revise su correo
                            </div>          

                            <% }%>

                            <div class="form-gp">
                                <label for="exampleInputEmail1">N°-identificación</label>
                                <input type="text" id="exampleInputEmail1" name="txtid" maxlength="20" required>
                                <i class="ti-email"></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword1">Clave</label>
                                <input type="password" id="exampleInputPassword1" name="txtclave" maxlength="30" required>
                                <i class="ti-lock"></i>
                            </div>
                            <input type="hidden" value="1" name="opcion">
                            <div class="row mb-4 rmber-area">


                            </div>
                            <div class="submit-btn-area">
                                <button id="form_submit" type="submit" style="background: orange">Ingresar <i class="ti-arrow-right" ></i></button>
                                <div class="login-other row mt-4">

                                </div>
                                <div class="form-footer text-center mt-5">
                                    <p class="text-muted">No tienes cuenta? <a href="registroUsuario.jsp">Registrar</a></p>
                                </div>
                                <div class="form-footer text-center mt-5">
                                    <p class="text-muted">Olvidaste la Clave <a href="recuperar_clave.jsp">Recuperar</a></p>
                                </div>

                            </div>
                        </div>
                    </form>

                </div>
            </div>

            <!-- login area end -->

            <!-- jquery latest version -->
            <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
            <!-- bootstrap 4 js -->
            <script src="assets/js/popper.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
            <script src="assets/js/owl.carousel.min.js"></script>
            <script src="assets/js/metisMenu.min.js"></script>
            <script src="assets/js/jquery.slimscroll.min.js"></script>
            <script src="assets/js/jquery.slicknav.min.js"></script>

            <!-- others plugins -->
            <script src="assets/js/plugins.js"></script>
            <script src="assets/js/scripts.js"></script>
    </body>

</html>