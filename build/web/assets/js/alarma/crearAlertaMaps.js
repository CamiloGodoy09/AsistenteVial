var longitud, latitud;
window.addEventListener('load', obtener, false);
function obtener() {
    navigator.geolocation.getCurrentPosition(mostrar, gestionarErrores);
}
function mostrar(posicion) {
    if (navigator.geolocation) {
        longitud = posicion.coords.latitude;
        latitud = posicion.coords.longitude;
    }
}
function gestionarErrores(error) {
    alert('Error: ' + error.code + ' ' + error.message + '\n\nPor favor compruebe que está conectado ' +
            'a internet y habilite la opción permitir compartir ubicación física');
}
function traerId(n) {
    var id=document.getElementById("idusuario").value;
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {
            action: 'crearAlarma',
            value: n,
            latitud: longitud,
            longitud: latitud,
            categoria: 1,
            idCliente: id},

        success: function (resultado) {
            
            if (resultado == "NO") {
                Swal.fire({
                    type: 'error',
                    title: 'Oops...',
                    text: 'No se ha guardado!'

                })
            } else {
                Swal.fire(
                        resultado + '!',
                        'Dale click para continuar',
                       'success'
                        )
            }

        }
    });

} 




