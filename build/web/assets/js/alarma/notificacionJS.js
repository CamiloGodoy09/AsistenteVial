window.onload = notificacion;
var value = 1;
var hol = 0;
var mensaje = "";
var array = "";
var card = new Array();

function notificacion() {
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {
            action: 'consulta',
            value: value
        },
        success: function (resultado) {
            resultado = resultado.trim();
           
            mensaje = resultado.slice(1, -1);
            if (mensaje !== "") {
                array = mensaje.split(",");
                //empty para vaciar el contenedor del modal
                $(".rows").empty()
                for (var i = 0; i < array.length; i++) {
                    var informacion = array[i].split("*");
                   
                    card[i] = '<div style="margin-top:15px;"class="col-md-3"><div class="card"><div class="card-body"><h4 class="card-title d-flex justify-content-between align-items-center">' + informacion[2] + '<button type="button" href="#" id="abrirMapa" value="' + informacion[3] + '*' + informacion[4] + '*'+ informacion[5] +'" data-toggle="modal"  data-target="#mapa">ver</button></h4><p>fecha: ' + informacion[0] + '</p><p><p>categoria: ' + informacion[1] + '</p></div></div></div><br>'
                }
                $(".rows").append(card);

                $('#abrirModal').click();

            }
        }
    });

    setTimeout('notificacion()', 1000);
}

var latitud = "";
var longitud = "";
var idalarma = "";
$(document).on("click", "#abrirMapa", function initMap() {
    var n = $(this).val();
    var cadena = n.split("*");
    latitud = cadena[0];
    longitud = cadena[1];
    idalarma =cadena[2];
    
    $("#clienteAlarma").prop('href','/Propietario/controlador?action=aceptarAlarma&Alarma='+idalarma);  


    var map = L.map('map', {
        center: [latitud, longitud],
        zoom: 13,
        zoomControl: true
    });
    var defaultLayer = L.tileLayer.provider('OpenStreetMap.Mapnik').addTo(map);
    var marker = L.marker([latitud, longitud]);
    marker.addTo(map)




});

$(document).on("click", ".cerrarModal", function () {
    console.log("hola"),

    $.ajax({
        url: 'controladors',
        type: 'POST',
        data: {
            actualiza: 'actualizaEstado',
            nitTaller: 1234,
            opcion:'actualizaEstado'
        },
        success: function (resultado) {
            console.log(resultado);
        }
    });

}
);
