<!doctype html>
<html  lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Inicio de Sesión</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/bootstrap.css" rel="stylesheet" />
        <link href="assets/rubick.css" rel="stylesheet" />
        <link href="assets/presentation-page.css" rel="stylesheet" />
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
        <style>
            body{
                background-image: url(assets/images/Bogota.jpeg);
                background-size: cover;
                padding: 25px !important;
                border: 15px !important;
                color:white !important;
            }  
            .card{
                padding: 10px;
                background: rgba(235, 232, 230, 0.5)!important;
            }
            p{
                color: black !important;
                text-align: justify !important;
                font-size: 18px !important;
            }
            a{
                background-color: rgba(255, 127, 0, 0.9)!important;
                color: white !important;
                font-size: 25px !important;
                

            }



        </style>

    </head>
    <body>


        <div class="container-fuid">
            <div class="card" id="section1">
                <div class="container">

                    <div class="content">
                        <div class="row">
                            <div class="col-md-4 col-sm-5 col-md-offset-1">
                                <div class="builder-image">
                                    <div class="box-1">
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/Conductor.jpeg">

                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/bogota.jpg">

                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/Llaves.jpg">

                                        </figure>
                                    </div>
                                </div>
                                <br>
                                <div class="builder-image">
                                    <div class="box-2">
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/Motor_1.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/imagen3_1.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/imagen4_1.jpg">
                                        </figure>
                                    </div>
                                </div>
                                <br>
                                <div class="builder-image">
                                    <div class="box-3">
                                        <figure class="slide">
                                            <img src="assets/images/timon_1.jpg">
                                        </figure>
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/speed_1.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/pieza.jpg">
                                        </figure>
                                    </div>
                                </div>
                            </div>
                            <br> <br>
                            <div class="col-md-5 col-sm-5 col-sm-offset-1 col-md-offset-1">
                                <div class="title">
                                    <img src="assets/images/logo/n.png">
                                    <div class="separator-container">
                                        <div class="separator line-separator">?</div><br> <br>
                                    </div>
                                    <p>De la reserva a la comunicación y al pago. "Asistente vial" 
                                        le ayuda a encontrar talleres rápidamente, económicamente, 
                                        con mas seguridad y le ahorra tiempo evitando la búsqueda de talleres por toda la ciudad.</p>
                                    <br>
                                    <div>

                                        <% if (request.getAttribute("registroExitoso") != null) { %>
                                        <div class="alert alert alert-succes alert-dismissable">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <strong>¡Conductor!</strong> Registrado correctamente
                                        </div>

                                        <%
                                            }
                                        %>

                                    </div>
                                    <a href="indexCliente.jsp"
                                       class="btn btn-animation btn-block">
                                        Conductor
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <br>
                                    <br><br>
                                    <p>Como taller, puedes encontrar gran
                                        cantidad de ofertas donde puedes tomar para generar ingresos.
                                        "Asistente vial"  te permite consultar talleres con la ubicación en tiempo real.
                                    </p>
                                    <br>
                                    <br>
                                    <a href="indexTaller.jsp"
                                       class="btn btn-animation btn-block">
                                        Propietario
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- end full page-->
        <!-- end wrapper -->


        <script src="assets/jquery-1.11.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/box-slider-all.jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {

                var $box = $('.box');

                var options_1 = {
                    speed: 1200
                    , autoScroll: true
                    , timeout: 5000
                    , effect: 'scrollHorz3d'
                };

                var options_2 = {
                    speed: 1200
                    , timeout: 1800
                    , autoScroll: true
                    , effect: 'scrollHorz3d'
                };

                var options_3 = {
                    speed: 1200
                    , timeout: 6200
                    , autoScroll: true
                    , effect: 'scrollHorz3d'
                };

                // initialize the plugin with the desired settings
                $('.box-1').boxSlider(options_1);

                $('.box-2').boxSlider(options_2);

                $('.box-3').boxSlider(options_3);

            });
        </script>

    </body>

</html>