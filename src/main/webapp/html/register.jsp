<%-- 
    Document   : register
    Created on : 15 oct. 2022, 09:57:49
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PostCat - Registrar nueva cuenta</title>
        <link rel="shortcut icon" href="../img/logo-cato.png">
        <link rel="stylesheet" href="../css/mycss.css">
        <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>

    <body>

        <div class="login-box-register" id="login-box-register">
            <img class="avatar" src="../img/logo-cato.png" alt="Logo de la página">
            <h1>Crea una cuenta</h1>
            <form method="get" id="formR">

                <div class="columnaPrincipal">
                    <div class="columna1">

                        <label for="names">Nombre(s)</label>
                        <input type="text" name="names" id="names" maxlength="30" required
                               placeholder="Ingresa tu(s) nombre(s)">
                        <div id="myNames">
                            <br>
                        </div>

                        <label for="lastNameP">Apellido paterno</label>
                        <input type="text" name="lastNameP" id="lastNameP" maxlength="30" required
                               placeholder="Ingresa tu apellido paterno">
                        <div id="myLastNameP">
                            <br>
                        </div>

                        <label for="lastNameM">Apellido materno</label>
                        <input type="text" name="lastNameM" id="lastNameM" maxlength="30" required
                               placeholder="Ingresa tu apellido materno">
                        <div id="myLastNameM">
                            <br>
                        </div>

                        <label for="birthday">Fecha de nacimiento</label>
                        <input type="date" name="birthday" id="birthday" required min="1977-01-01" max="2022-12-31">
                        <div id="myBirthday">
                            <br>
                        </div>

                    </div>

                    <div class="columna2">

                        <label for="email">Correo electrónico</label>
                        <input type="email" name="email" id="email" maxlength="30" required
                               placeholder="Ingresa tu correo electrónico">
                        <div id="myEmail">
                            <br>
                        </div>

                        <label for="username">Nombre de usuario</label>
                        <input type="text" name="username" id="username" maxlength="30" required
                               placeholder="Ingresa tu nombre de usuario">
                        <div id="myUsername">
                            <br>
                        </div>

                        <label for="password">Contraseña</label>
                        <input type="password" name="password1" id="password1" maxlength="30" minlength="8" required
                               placeholder="Ingresa tu contraseña">
                        <div id="myPassword1">
                            <br>
                        </div>

                        <label for="password">Confirmar contraseña</label>
                        <input type="password" name="password2" id="password2" maxlength="30" minlength="8" required
                               placeholder="Vuelve a ingresar tu contraseña">
                        <div id="myPassword2">
                            <br>
                        </div>

                    </div>
                </div>




                <div>
                    <!--<br>-->
                    <label for="avatar">Imagen de perfil</label>
                    <br>
                    <input class="ocultaron" type="file" id="avatar" accept="image/*"/>

                    <label for="avatar"> 
                        <div class="myLabel">
                            <img class="myImg" id="imagenSubida" src="../img/logo-cato.png" alt="" />
                            <div>
                                <span id="tituloArchivo">Agregar imagen</span><br />
                                <span id="nombreArchivo"></span>
                            </div>
                        </div>
                    </label>

                </div>

                <br>

                <input type="submit" value="Crear cuenta">

                <!--a href="../html/passwordLost.jsp">¿Olvidaste tu contraseña?</a><br-->
                <div class="centrado">
                    <a href="../html/login.jsp">¿Ya tienes cuenta? Inicia sesión</a>
                </div>




            </form>

        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="../js/registerScript.js"></script>
    </body>

</html>
