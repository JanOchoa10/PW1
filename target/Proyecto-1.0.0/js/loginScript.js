/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// function validateEmail(correo) {

//     //validamos que sea el formato de email correcto
//     var regExpEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(correo);

//     if (regExpEmail) {
//         console.log("Email correcto");
//         return true;
//     } else {
//         console.log("Email incorrecto");
//         return false;
//     }   

// }

function validarContrasena(passwordAValidar) {
    //validamos que sea el formato de contrasena correcto
    var regExpPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){8,30}$/.test(passwordAValidar);
    //console.log("La contraseña a validar es: "+passwordAValidar);

    if (regExpPassword) {
//        console.log("Password correcto");
        return true;
    } else {
//        console.log("Password incorrecto");
        //alert("Contrasena debve tener caracteres");
        return false;
    }
}

const inputUsername = document.getElementById('username');
const inputPassword1 = document.getElementById('password1');

inputUsername.addEventListener('focusout', updateValueUsername);
inputUsername.addEventListener('keyup', updateValueUsername);
inputPassword1.addEventListener('focusout', updateValuePassword1);
inputPassword1.addEventListener('keyup', updateValuePassword1);

let misBooleanos = i1 = true, i2 = true;

function updateValueUsername() {
    if (document.getElementById("username").value != "") {
        document.getElementById('username').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myUsername').innerHTML = "<br>";
        i1 = true;
    } else {
        document.getElementById('username').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myUsername').innerHTML = "<label>El nombre de usuario no debe estar vacío.</label><br>";
        document.getElementById('myUsername').style.color = "#C70039";
        document.getElementById('myUsername').style.fontSize = "12px";
        i1 = false;

    }
    validarTamano();
}

function updateValuePassword1() {

    if (validarContrasena(document.getElementById("password1").value)) {
        document.getElementById('password1').style.borderColor = "#0DF93E";
        // document.getElementById('password1').style.color = "#0DF93E";
        // document.getElementById('password1Label').style.color = "#0DF93E";
        document.getElementById('myPassword1').innerHTML = "<br>";
        i2 = true;
    } else {
        document.getElementById('password1').style.borderColor = "#C70039";
        // document.getElementById('password1').style.color = "#C70039";
        // document.getElementById('password1Label').style.color = "#C70039";
        document.getElementById('myPassword1').innerHTML = "<label>La contraseña debe contener al menos 1 mayúscula, 1 minúscula, 1 número y 1 caracter especial.</label><br>";
        document.getElementById('myPassword1').style.color = "#C70039";
        document.getElementById('myPassword1').style.fontSize = "12px";
        i2 = false;
    }
    validarTamano();
}

function validarTamano() {
    let uno = "380px", dos = "430px", tres = "420px", cuatro = "390px";

    if (i1 && i2) {
        document.getElementById('login-box').style.height = uno;
//        console.log("Aplicamos " + uno);
    } else {
        if (!i1 && !i2) {
            document.getElementById('login-box').style.height = dos;
//            console.log("Aplicamos " + dos);
        } else {
            if (i1 && !i2) {
                document.getElementById('login-box').style.height = tres;
//                console.log("Aplicamos " + tres);
            } else {
                if (!i1 && i2) {
                    document.getElementById('login-box').style.height = cuatro;
//                    console.log("Aplicamos " + cuatro);
                }
            }
        }
    }
}

//Mantenlo a la espera
document.getElementById("formL").addEventListener("submit", function (event) {
    //event.action = "home";
    //event.preventDefault();


    if (!validarContrasena(document.getElementById("password1").value)) {
        event.preventDefault();
        Swal.fire({
            icon: 'error',
            title: '¡Inicio de sesión no exitoso!',
            text: 'La contraseña debe contener al menos 1 mayúscula, 1 minúscula, 1 número y 1 caracter especial.',
            confirmButtonText: 'Reintentar',
            //footer: '<a href="">Why do I have this issue?</a>'
        })

        console.log(document.getElementById("password1").value);
        document.getElementById("password1").value = "";
    } 
//    else {
//        Swal.fire({
//            icon: 'success',
//            title: '¡Inicio de sesión exitoso!',
//            //showDenyButton: true,
//            //showCancelButton: true,
//            confirmButtonText: 'Continuar',
////            denyButtonText: `Don't save`,
//        }).then((result) => {
//
//            if (result.isConfirmed) {
//                event.method = "POST";
//                event.action = "home";
//
//                // event.preventDefault(false);
//                //window.location.href = "hmtl/home.jsp";
//            }
//        })
//    }

});


//
//$(document).ready(function () {
//    $('#form').submit(function (event) {
//        event.preventDefault();
//        $.ajax({
//            data: $(this).serialize(),
//            type: "POST",
//            dataType: "json",
//            url: "Login"
//        }).done(function (data) {
//            console.log(data);
//            if (data.resultado == true) {
//                window.location.href = "home.jsp";
//            } else {
//                
//                window.location.href = "error_login.jsp";
//            }
//        }).fail(function (jqXHR, textEstado) {
//            console.log("La solicitud regreso con un error: " + textEstado);
//        });
//    });
//
//
//});