<%-- 
    Document   : registroUsuario
    Created on : 23/10/2019, 04:49:08 PM
    Author     : junior
--%>

<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Propietarios</title>
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
        <%
            String h = "";
            if (request.getAttribute("men") != null) {
                h = request.getAttribute("men").toString();
            }
        %>

        <script src="https://www.google.com/recaptcha/api.js"></script>
         <style>
            body{
                background-image: url(assets/images/Bogota.jpeg)!important;
                background-size: cover !important;
            }

        </style>
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
        <!-- login area start -->
        <div class="">
            <div class="container">
                <div class="login-box ptb--100">
                    <form method="post" action="Propietario">
                        <div class="login-form-head">
                            <h4>Registro</h4>
                            <p>Por favor ingrese todos los datos que se le solicitan</p>
                        </div>
                        <div class="login-form-body">
                            <label for="exampleInputName1">Foto</label>
                            <div class="form-gp">
                                <input type="file" accept="image/*" name="imgfoto" id="imgfoto">
                                <i class=""></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputEmail1">Nombres</label>
                                <input type="text" pattern="[A-Za-z ]{4-16}"  maxlength="20" min="4" name="txtnombre" class="form-control"   required>
                                <i class=""></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword1">Apellidos</label>
                                <input type="text" pattern="[A-Za-z ]{4-16}"  maxlength="20" min="4" name="txtapellido" class="form-control" required><br>
                                <i class=""></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword2">identificacioón</label>
                                <input type="number" max="10000000000" min="10000000" name="txtid"class="form-control"  required>
                                <i class=""></i>
                            </div>
                            
                            <div class="form-gp">
                                <label for="exampleInputPassword2">Fecha de nacimiento</label><br>
                                 <input type="date"  name="fecha" class="form-control" required>
                                <i class=""></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword2">Género</label><br>
                               <select name="txtgenero" class="form-control">
                                                <option  value="Hombre">Hombre</option>
                                                <option  value="Mujer">Mujer</option>
                                                <option  value="Otro">Otro</option> 
                                            </select>
                                <i class=""></i>
                            </div>
                             <div class="form-gp">
                                <label for="exampleInputPassword2">Correo</label>
                               <input type="email" class="form-control" name="txtcorreo" class="form-control"  required><br>
                                <i class=""></i>
                            </div>
                             <div class="form-gp">
                                <label for="exampleInputPassword2">Teléfono</label>
                                <input type="number"  min="1000000" max="10000000000" name="telefono" required class="form-control"><br>
                                <input type="hidden" name="txtestado" value="1">  
                                <i class=""></i>
                            </div>
                             <div class="form-gp">
                                <label for="exampleInputPassword2">usuario</label>
                                <input type="text" pattern="[A-Za-z ]{4-16}"  maxlength="20" minlenght="4"  name="txtusuario" class="form-control" required><br>
                                <i class=""></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword2">Contraseña</label>
                               <input type="password" maxlength="20" minlength="8" name="txtclave" class="form-control" required><br>
                                <i class=""></i>
                            </div>
                            <input type="checkbox" value="terminos" required><label>Acepto términos y condiciones de la empresa</label><br>
                                        <input type="hidden" value="1" name="opcion" class="form-control">
                            <form action="" method="POST">

                                <div class="g-recaptcha" data-sitekey="6LfQtB4UAAAAAD8dYz3NfgE54Jgd4MRD4ctt43oe"></div>
                                <br/>
                                <label><%=h%></label><br>
                                
                            </form> 
                            <div class="submit-btn-area">
                                <button id="form_submit" type="submit">Registrar <i class="ti-arrow-right"></i></button>
                                
                                <div class="login-other row mt-4">
                                  
                                </div> 
                            </div>
                            <div class="form-footer text-center mt-5">
                                <p class="text-muted">Ya tienes una cuenta? <a href="index.jsp">Inicia sesion</a></p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <% if (request.getParameter("mensajeError") != null) { %>
          <script>
            $(document).ready(function ()
            {
                $("#modal1").modal("show");
            });
                    </script>

                    <div class="modal fade" id="modal1" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title"><div class="alert alert-danger"><strong>ERROR</strong></div></h4>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <center><h5>Ocurrio un Error al registrar los datos por favor verifique los datos ingresados</h5></center>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                <%
            }
        %>
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
