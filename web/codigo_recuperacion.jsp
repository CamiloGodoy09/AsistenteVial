
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Registrar.css" rel="stylesheet" type="text/css"/>
        <title>Recuperar</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/bootstrap.css" rel="stylesheet" />
        <link href="assets/rubick.css" rel="stylesheet" />
        <link href="assets/presentation-page.css" rel="stylesheet" />
        <style>
            body{
                background-image: url(assets/images/fondo.jpg);
                background-size: cover;
                padding: 25px !important;
                border: 15px !important;
                color:white !important;
            }  
            .card{
                padding: 10px;
                background: rgba(0, 0, 0, 0.6)!important;
            }
            p{
                color:white !important;
                text-align: justify !important;
                font-size: 18px !important;
            }
            button{
                background-color: rgba(0, 0, 0, 0.7)!important;
                color: white !important;
                font-size: 25px !important;

            }
            input{
                background-color: rgba(0, 0, 0, 0.7)!important;
                color: white !important;
                font-size: 25px !important;
            }



        </style>
        <link rel="icon" type="image/png" href="assets/images/Icono.ico">
    </head>
    <body>
        <% String correo = "";
            String v = "";
            if (request.getParameter("v").toString() != "") {
                v = request.getParameter("v").toString();

            }
            correo = request.getAttribute("correo").toString();
        %>

        <div class="container-fuid">
            <div class="card" id="section1">
                <div class="container">

                    <div class="content">
                        <div class="row">
                            <div class="col-md-4 col-sm-5 col-md-offset-1">
                                <div class="builder-image">
                                    <div class="box-1">
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/IMAGEN5.jpg">

                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/bogota.jpg">

                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/cam1.jpg">

                                        </figure>
                                    </div>
                                </div>
                                <div class="builder-image">
                                    <div class="box-2">
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/imagen1.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/imagen3.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/imagen4.jpg">
                                        </figure>
                                    </div>
                                </div>
                                <div class="builder-image">
                                    <div class="box-3">
                                        <figure class="slide">
                                            <img src="assets/images/fondo.jpg">
                                        </figure>
                                        <figure class="slide jbs-current">
                                            <img src="assets/images/prueba.jpg">
                                        </figure>
                                        <figure class="slide">
                                            <img src="assets/images/servicios.jpg">
                                        </figure>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-5 col-sm-5 col-sm-offset-1 col-md-offset-1">
                                <div class="title">


                                    <h2 id="Tit">Recuperar Clave</h2>

                                    <form id="form" method="post" action="recuperarClave">

                                        <table id="Tabla" width="500" height="80">

                                            <tr>
                                                <th> <br>
                                                    <input id="Input" type="text" name="txtcodigo"placeholder="codigo"required class="form-control transparent-input"><br><br>

                                                    <input id="Input" type="text" name="txtPass"placeholder="nueva contraseña"required class="form-control transparent-input"><br><br>

                                                    <input name="txtcorreo" value="<%=correo%>" type="hidden">
                                                </th>

                                            </tr>
                                        </table> <br><br>

                                        <button id="boton" class="btn btn-animation btn-block"> Cambiar Contraseña</button>
                                        <input id="Input" type="hidden" name="opcion" value="2"><br>
                                        <input id="Input" type="hidden" name="v" value="<%=v%>"><br>


                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                        

        <%
       if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%>
        
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
