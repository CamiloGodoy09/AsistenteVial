var mensaje = "";
window.onload = buscador;
function buscador() {
    var id = document.getElementById("idusuario").value;
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {
            action: 'alarmaAceptada',
            value: id
        },
        success: function (resultado) {
            mensaje = resultado.trim();

            if (mensaje === "no rigistra") {

            } else {
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    onOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                })

                Toast.fire({
                    type: 'success',
                    title: 'Tu alarma fua aceptada por: ' + resultado
                })

                desactiva(id);

            }

        }

    });

    setTimeout('buscador()', 1000);
}

function desactiva(id) {
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {
            action: 'alarmaAceptadaIn',
            value: id
        },
        success: function (resultado) {


        }

    });

}

