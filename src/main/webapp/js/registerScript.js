/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//Asignamos la fecha de hoy al input de fecha de nacimiento
var hoy = new Date();

const formatDate = (current_datetime) => {

    let formatted_date;
    if ((current_datetime.getMonth() + 1) >= 10 && current_datetime.getDate() >= 10) {
        formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate();// + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes() + ":" + current_datetime.getSeconds();
    } else if ((current_datetime.getMonth() + 1) < 10 && current_datetime.getDate() < 10) {
        formatted_date = current_datetime.getFullYear() + "-0" + (current_datetime.getMonth() + 1) + "-0" + current_datetime.getDate();
    } else if ((current_datetime.getMonth() + 1) < 10 && current_datetime.getDate() >= 10) {
        formatted_date = current_datetime.getFullYear() + "-0" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate();
    } else if ((current_datetime.getMonth() + 1) >= 10 && current_datetime.getDate() < 10) {
        formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-0" + current_datetime.getDate();
    }

    return formatted_date;
}

//console.log("La fecha de hoy es: " + formatDate(hoy));

document.getElementById("birthday").value = formatDate(hoy);
document.getElementById("birthday").max = formatDate(hoy);

//Verificaremos la edad en años para saber si es mayor de 13 años
let fechaElegida = document.getElementById("birthday").value;
//console.log("Fecha en el input: " + fechaElegida);
let fechaNac = formatDate(hoy);
//console.log("Su nacimiento es el: " + formatDate(hoy));

//const date = Date.parse("2018/10/30");
fechaNac = fechaNac.substring(0, 4) + "/" + fechaNac.substring(5, 7) + "/" + fechaNac.substring(8, 11);
//console.log("Su nacimiento corregido: " + fechaNac);

//fechaNac = "2018/09/09";

const date = Date.parse("" + fechaNac + "");
let fechaEnFormato = date;

function getEdad(fechaEnFormato) {
    let hoy = new Date()
    //console.log("fecha de hoy: "+hoy);
    let fechaNacimiento = new Date(fechaEnFormato)
    //console.log("fecha de nacimiento: "+fechaNacimiento);
    let edad = hoy.getFullYear() - fechaNacimiento.getFullYear()
    let diferenciaMeses = hoy.getMonth() - fechaNacimiento.getMonth()
    if (
            diferenciaMeses < 0 ||
            (diferenciaMeses === 0 && hoy.getDate() < fechaNacimiento.getDate())
            ) {
        edad--
    }
    return edad
}

console.log("Su edad es: " + getEdad(fechaEnFormato));


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


function validarEdad() {
    fechaElegida = document.getElementById("birthday").value;

    let miNumero = getEdad(fechaElegida);
    if (miNumero >= 13) {
        console.log("Mayor de 13. Su edad es: " + getEdad(fechaElegida));
        return true;
    } else {
        console.log("Menor de 13. Su edad es: " + getEdad(fechaElegida));
        return false;
    }
}

function validarNombre(nombreAValidar) {
    //validamos que sea el formato de nombre correcto
    var regExpNombre = /^[A-ZÁÉÍÓÚÑ ]+$/i.test(nombreAValidar);
    //console.log("La contraseña a validar es: "+passwordAValidar);

    if (regExpNombre) {
        console.log("Nombre/apellido correcto");
        return true;
    } else {
        console.log("Nombre/apellido incorrecto");
        return false;
    }

}


function validarContrasena(passwordAValidar) {
    //validamos que sea el formato de contrasena correcto
    var regExpPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){8,30}$/.test(passwordAValidar);
    //console.log("La contraseña a validar es: "+passwordAValidar);

    if (regExpPassword) {
        console.log("Password correcto");
        return true;
    } else {
        console.log("Password incorrecto");
        return false;
    }
}



function comprobarClave() {
    clave1 = document.getElementById("password1").value;
    clave2 = document.getElementById("password2").value;

    if (clave1 == clave2)
        //console.log("Las dos claves son iguales...\nRealizaríamos las acciones del caso positivo")
        return true;
    else
        return false;
    //console.log("Las dos claves son distintas...\nRealizaríamos las acciones del caso negativo")
}

//Mantenlo a la espera
document.getElementById("formR").addEventListener("submit", function (event) {
    event.preventDefault()

    if (!validateEmail(document.getElementById("email").value)) {
        console.log("No se muestra el email");
        Swal.fire({
            icon: 'error',
            title: '¡Registro no exitoso!',
            text: 'Ingrese un correo válido.',
            confirmButtonText: 'Reintentar',
        })
        ///document.getElementById("email").value = "";

    } else {

        if (!validarNombre(document.getElementById("names").value)
                || !validarNombre(document.getElementById("lastNameP").value)
                || !validarNombre(document.getElementById("lastNameM").value)) {
            console.log("No se muestra el nombres");
            Swal.fire({
                icon: 'error',
                title: '¡Registro no exitoso!',
                text: 'El nombre y los apellidos deben contener solo letras y espacios en blanco.',
                confirmButtonText: 'Reintentar',
            })

        } else {

            if (!validarContrasena(document.getElementById("password1").value)) {
                console.log("No se muestra el contraseña correcta");
                Swal.fire({
                    icon: 'error',
                    title: '¡Registro no exitoso!',
                    text: 'La contraseña debe contener al menos 1 mayúscula, 1 minúscula, 1 número y 1 caracter especial.',
                    confirmButtonText: 'Reintentar',
                })
                console.log(document.getElementById("password1").value);
                console.log(document.getElementById("password2").value);
                document.getElementById("password1").value = "";
                document.getElementById("password2").value = "";

            } else {

                if (!validarEdad()) {
                    console.log("No se muestra el edad");
                    Swal.fire({
                        icon: 'error',
                        title: '¡Registro exitoso!',
                        text: 'La edad del usuario debe ser mayor a 13 años.',
                        confirmButtonText: 'Reintentar',
                    })

                } else {

                    if (!comprobarClave()) {
                        console.log("No se muestra el contraseña confirmada");
                        Swal.fire({
                            icon: 'error',
                            title: '¡Registro no exitoso!',
                            text: 'Las contraseñas deben ser iguales.',
                            confirmButtonText: 'Reintentar',
                        })
                        document.getElementById("password2").value = "";

                    } else {

                        if (validateImage()) {
                            Swal.fire({
                                icon: 'question',
                                title: '¡Imagen no cargada!',
                                text: '¿Deseas continuar?',
                                confirmButtonText: 'Sí',
                                showDenyButton: true,
                                denyButtonText: `Agregar imagen`,
                                denyButtonColor: '#6f7880',
                            }).then((result) => {
                                /* Read more about isConfirmed, isDenied below */
                                if (result.isConfirmed) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: '¡Registro exitoso!',
                                        text: 'Se registró la cuenta exitosamente.',
                                        confirmButtonText: 'Volver al inicio de sesión',
                                    }).then((value) => {
                                        window.location.href = '../html/login.jsp';
                                    })
                                } else if (result.isDenied) {
                                    //console.log('Valor del input: ' + valorN);
                                }
                            })



                        } else {


                            console.log("No se muestra el exitoso");
                            Swal.fire({
                                icon: 'success',
                                title: '¡Registro exitoso!',
                                text: 'Se registró la cuenta exitosamente.',
                                confirmButtonText: 'Volver al inicio de sesión',
                            }).then((value) => {
                                window.location.href = "../html/login.jsp";
                            })
                        }

                    }
                }
            }

        }

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

const inputNames = document.getElementById('names');
const inputLastNameP = document.getElementById('lastNameP');
const inputLastNameM = document.getElementById('lastNameM');
const inputBirthday = document.getElementById('birthday');
const inputEmail = document.getElementById('email');

const inputUsername = document.getElementById('username');
const inputPassword1 = document.getElementById('password1');

const inputPassword2 = document.getElementById('password2');

inputNames.addEventListener('focusout', updateValueNames);
inputNames.addEventListener('keyup', updateValueNames);

inputLastNameP.addEventListener('focusout', updateValueLastNameP);
inputLastNameP.addEventListener('keyup', updateValueLastNameP);

inputLastNameM.addEventListener('focusout', updateValueLastNameM);
inputLastNameM.addEventListener('keyup', updateValueLastNameM);

inputBirthday.addEventListener('focusout', updateValueBirthday);
inputBirthday.addEventListener('keyup', updateValueBirthday);

inputEmail.addEventListener('focusout', updateValueEmail);
inputEmail.addEventListener('keyup', updateValueEmail);

inputUsername.addEventListener('focusout', updateValueUsername);
inputUsername.addEventListener('keyup', updateValueUsername);

inputPassword1.addEventListener('focusout', updateValuePassword1);
inputPassword1.addEventListener('keyup', updateValuePassword1);

inputPassword2.addEventListener('focusout', updateValuePassword2);
inputPassword2.addEventListener('keyup', updateValuePassword2);

let misBooleanos =
        i1 = true,
        i2 = true,
        i3 = true,
        i4 = true,
        i5 = true,
        i6 = true,
        i7 = true,
        i8 = true;

function updateValueNames() {
    if (validarNombre(document.getElementById("names").value)
            || validarNombre(document.getElementById("lastNameP").value)
            || validarNombre(document.getElementById("lastNameM").value)) {
        document.getElementById('names').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myNames').innerHTML = "<br>";
        i1 = true;
    } else {
        document.getElementById('names').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myNames').innerHTML = "<label>El nombre(s) debe(n) contener solo letras y espacios en blanco.</label><br>";
        document.getElementById('myNames').style.color = "#C70039";
        document.getElementById('myNames').style.fontSize = "12px";
        i1 = false;

    }
    validarTamano();
}

function updateValueLastNameP() {
    if (validarNombre(document.getElementById("lastNameP").value)) {
        document.getElementById('lastNameP').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myLastNameP').innerHTML = "<br>";
        i2 = true;
    } else {
        document.getElementById('lastNameP').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myLastNameP').innerHTML = "<label>El apellido paterno debe contener solo letras y espacios en blanco.</label><br>";
        document.getElementById('myLastNameP').style.color = "#C70039";
        document.getElementById('myLastNameP').style.fontSize = "12px";
        i2 = false;

    }
    validarTamano();
}

function updateValueLastNameM() {
    if (validarNombre(document.getElementById("lastNameM").value)) {
        document.getElementById('lastNameM').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myLastNameM').innerHTML = "<br>";
        i3 = true;
    } else {
        document.getElementById('lastNameM').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myLastNameM').innerHTML = "<label>El apellido materno deben contener solo letras y espacios en blanco.</label><br>";
        document.getElementById('myLastNameM').style.color = "#C70039";
        document.getElementById('myLastNameM').style.fontSize = "12px";
        i3 = false;

    }
    validarTamano();
}

function updateValueBirthday() {
    if (validarEdad()) {
        document.getElementById('birthday').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myBirthday').innerHTML = "<br>";
        i4 = true;
    } else {
        document.getElementById('birthday').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myBirthday').innerHTML = "<label>La edad del usuario debe ser mayor a 13 años.</label><br>";
        document.getElementById('myBirthday').style.color = "#C70039";
        document.getElementById('myBirthday').style.fontSize = "12px";
        i4 = false;

    }
    validarTamano();
}


function updateValueEmail() {
    if (validateEmail(document.getElementById("email").value)) {
        document.getElementById('email').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myEmail').innerHTML = "<br>";
        i5 = true;
    } else {
        document.getElementById('email').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myEmail').innerHTML = "<label>Ingrese un correo válido. <br> Ej. correo@ejemplo.com</label><br>";
        document.getElementById('myEmail').style.color = "#C70039";
        document.getElementById('myEmail').style.fontSize = "12px";
        i5 = false;

    }
    validarTamano();
}

function updateValueUsername() {
    if (document.getElementById("username").value != "") {
        document.getElementById('username').style.borderColor = "#0DF93E";
        // document.getElementById('username').style.color = "#0DF93E";
        // document.getElementById('usernameLabel').style.color = "#0DF93E";
        document.getElementById('myUsername').innerHTML = "<br>";
        i6 = true;
    } else {
        document.getElementById('username').style.borderColor = "#C70039";
        // document.getElementById('username').style.color = "#C70039";
        // document.getElementById('usernameLabel').style.color = "#C70039";
        document.getElementById('myUsername').innerHTML = "<label>El nombre de usuario no debe estar vacío.</label><br>";
        document.getElementById('myUsername').style.color = "#C70039";
        document.getElementById('myUsername').style.fontSize = "12px";
        i6 = false;

    }
    validarTamano();
}

function updateValuePassword1() {

    if (validarContrasena(document.getElementById("password1").value)) {
        document.getElementById('password1').style.borderColor = "#0DF93E";
        // document.getElementById('password1').style.color = "#0DF93E";
        // document.getElementById('password1Label').style.color = "#0DF93E";
        document.getElementById('myPassword1').innerHTML = "<br>";
        i7 = true;
    } else {
        document.getElementById('password1').style.borderColor = "#C70039";
        // document.getElementById('password1').style.color = "#C70039";
        // document.getElementById('password1Label').style.color = "#C70039";
        document.getElementById('myPassword1').innerHTML = "<label>La contraseña debe contener al menos 1 mayúscula, 1 minúscula, 1 número y 1 caracter especial.</label><br>";
        document.getElementById('myPassword1').style.color = "#C70039";
        document.getElementById('myPassword1').style.fontSize = "12px";
        i7 = false;
    }
    validarTamano();
}

function updateValuePassword2() {

    if (comprobarClave()) {
        document.getElementById('password2').style.borderColor = "#0DF93E";
        // document.getElementById('password1').style.color = "#0DF93E";
        // document.getElementById('password1Label').style.color = "#0DF93E";
        document.getElementById('myPassword2').innerHTML = "<br>";
        i8 = true;
    } else {
        document.getElementById('password2').style.borderColor = "#C70039";
        // document.getElementById('password1').style.color = "#C70039";
        // document.getElementById('password1Label').style.color = "#C70039";
        document.getElementById('myPassword2').innerHTML = "<label>Las contraseñas deben ser iguales.</label><br>";
        document.getElementById('myPassword2').style.color = "#C70039";
        document.getElementById('myPassword2').style.fontSize = "12px";
        i8 = false;
    }
    validarTamano();
}

function validarTamano() {
    let uno = "680px", dos = "760px", tres = "700px", cuatro = "720px", cinco = "740px";
    if (i1 &&
            i2 &&
            i3 &&
            i4 &&
            i5 &&
            i6 &&
            i7 &&
            i8) {
        document.getElementById('login-box-register').style.height = uno;
        console.log("Aplicamos " + uno);
    } else {
        if (!i1 &&
                !i2 &&
                !i3 &&
                !i4 &&
                !i5 &&
                !i6 &&
                !i7 &&
                !i8) {
            document.getElementById('login-box-register').style.height = dos;
            console.log("Aplicamos " + dos);
        } else {
            //1 nivel
            if (!i1 ||
                    !i2 ||
                    !i3 ||
                    !i4 ||
                    !i5 ||
                    !i6 ||
                    !i7 ||
                    !i8

                    ) {
                document.getElementById('login-box-register').style.height = tres;
                console.log("Aplicamos " + tres);
            }

            //2 niveles
            if (!i1 && !i2 ||
                    !i1 && !i3 ||
                    !i1 && !i4 ||
                    !i2 && !i3 ||
                    !i2 && !i4 ||
                    !i3 && !i4

                    ||
                    !i5 && !i6 ||
                    !i5 && !i7 ||
                    !i5 && !i8 ||
                    !i6 && !i7 ||
                    !i6 && !i8 ||
                    !i7 && !i8

                    ) {
                document.getElementById('login-box-register').style.height = cuatro;
                console.log("Aplicamos " + cuatro);
            }

            //3 niveles
            if (!i1 && !i2 && !i3 ||
                    !i1 && !i2 && !i4 ||
                    !i1 && !i3 && !i4 ||
                    !i2 && !i3 && !i4

                    ||
                    !i5 && !i6 && !i7 ||
                    !i5 && !i5 && !i8 ||
                    !i5 && !i7 && !i8 ||
                    !i6 && !i7 && !i8

                    ) {
                document.getElementById('login-box-register').style.height = cinco;
                console.log("Aplicamos " + cinco);
            }

            //4 niveles
            if (!i1 && !i2 && !i3 && !i4 ||
                    !i5 && !i6 && !i7 && !i8

                    ) {
                document.getElementById('login-box-register').style.height = dos;
                console.log("Aplicamos " + dos);
            }

        }
    }
}


let archivo = document.querySelector('#avatar');

archivo.addEventListener('change', () => {
    document.querySelector('#nombreArchivo').innerHTML = archivo.files[0].name;
    document.querySelector('#tituloArchivo').innerHTML = 'Imagen agregada:';
    console.log(archivo.files);
    for (let i = 0; i < archivo.files.length; i++) {
        const element = URL.createObjectURL(archivo.files[i]);
        const imagen = document.createElement('img');
        imagen.src = element;
        //document.body.appendChild(imagen);
        document.querySelector('#imagenSubida').src = imagen.src;
    }
});

function validateImage() {
    if (document.querySelector('#avatar').files.length == 0) {
        console.log("imagen no agregada");
        return true;
    } else {
        console.log("imagen agregada");
        return false;
    }

}