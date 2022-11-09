/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validateEmail(correo) {

    //validamos que sea el formato de email correcto
    var regExpEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(correo);
    
    if (regExpEmail) {
        console.log("Email correcto");
        return true;
    } else {
        console.log("Email incorrecto");
        return false;
    }   

}

//Mantenlo a la espera
document.getElementById("formP").addEventListener("submit", function(event){
    event.preventDefault()

    if(validateEmail(document.getElementById("email").value)){
        swal({
            icon: 'success',
            title: '¡Envío exitoso!',
            text: 'Se envió el correo exitosamente.', 
            button: 'Volver al inicio de sesión',
            }).then((value) => {
            window.location.href = "../html/login.jsp";
        })
    } else {
        swal({
            icon: 'error',
            title: '¡Envío no exitoso!',
            text: 'Ingrese un correo válido.', 
            button: 'Reintentar',
        })
        //document.getElementById("email").value = "";
    }
    
    //Validamos que no esté vacío
    /*function validar() {
        if ($('#username').val().length == 0) {
            alert('Ingrese rut');
            return false;
        }
    }*/

    //Dialogo con 2 opciones
    /*swal({
        title: "Estas seguro de eliminar el producto del carrito?",
                text: "Una vez eliminado, no podras recuperarla!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                swal("El producto is death :c!");
            } else {
                swal("El producto sigue con vida :)!");
            }
    })*/
});
