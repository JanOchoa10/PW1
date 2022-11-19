<%-- 
    Document   : register
    Created on : 15 oct. 2022, 09:57:49
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page contentType="text/html; charset=Windows-1252" language="java"%>--%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PostCat - Registrar nueva cuenta</title>
        <link rel="shortcut icon" href="img/logo-cato.png">
        <link rel="stylesheet" href="css/mycss.css">
        <link rel="stylesheet" href="css/style2.css">
        <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>

    <body>
        
        
        <nav>
            <div class="nav-left">
                <img src="img/logo.png" class="logo" onclick="location.reload(false);">
                <!--<h4>PostCat</h4>-->
<!--                <ul>
                    <li><img src="img/newspaper-regular.png" title="Recientes"></li>
                    <li><img src="img/comments-regular.png" title="Más comentadas"> </li>
                    <li><img src="img/thumbs-up-regular.png" title="Más votadas"></li>
                </ul>-->
            </div>
            <div class="nav-right">
<!--                <div class="search-box">
                    <img src="img/search.png">
                    <input type="text" placeholder="Buscar">
                </div>-->
                <div class="nav-user-icon" onclick="settingsMenuToggle()">
                    <img src="img/logo-cato.png">
                </div>
            </div>
            <!-- ------------settings-menu------------ -->
            <div class="settings-menu">

                <!--                <div id="dark-btn">
                                    <span></span>
                                </div>-->


                <div class="settings-menu-inner">
<!--                    <div class="user-profile">
                        <img src="img/${usuarios[0].userImagen}">
                        <div>
                            <p>${usuarios[0].nombre}</p>
                            <a href="#">Editar tu perfil</a>
                        </div>
                    </div>-->
                    <!--<hr>-->
                    <!--                    <div class="user-profile">
                                            <img src="img/feedback.png">
                                            <div>
                                                <p>Dar opinión</p>
                                                <a href="#">Ayúdanos a mejorar el nuevo diseño</a>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="settings-links">
                                            <img src="img/setting.png" class="settings-icon">
                                            <a href="#">Configuración y privacidad <img src="img/arrow.png" width="10px"></a>
                                        </div>
                                        <div class="settings-links">
                                            <img src="img/help.png" class="settings-icon">
                                            <a href="#">Ayuda y Soporte <img src="img/arrow.png" width="10px"></a>
                                        </div>
                                        <div class="settings-links">
                                            <img src="img/display.png" class="settings-icon">
                                            <a href="#">Pantalla y Accesibilidad <img src="img/arrow.png" width="10px"></a>
                                        </div>-->
                    <div class="settings-links2">
                        <img src="img/moon-solid.png" class="settings-icon">
                        <a>Modo oscuro</a>
                        <div id="dark-btn">
                            <span></span>
                        </div>
                    </div>
<!--                    <div class="settings-links">
                        <img src="img/arrow-right-from-bracket-solid.png" class="settings-icon">
                        <a onclick="logout()">Cerrar Sesión</a>
                    </div>-->
                </div>

            </div>

        </nav>

        <div class="login-box-register" id="login-box-register">
            <img class="avatar" src="img/logo-cato.png" alt="Logo de la página">
            <h1>Crea una cuenta</h1>
            <form action="Registro2" method="POST" id="formR" >

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
                    <input class="ocultaron" type="file" id="avatar"  name="imagenSubida" accept="image/*"/>

                    <label for="avatar"> 
                        <div class="myLabel">
                            <img class="myImg" id="imagenSubida" src="img/logo-cato.png"/>
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
                    <a href="./">¿Ya tienes cuenta? Inicia sesión</a>
                </div>




            </form>

        </div>
        
        
        
         <div class="footer">
            <br>
            <p>Copyright 2022 - PostCat por Jan Ochoa y Elvia Arriaga</p>
        </div>

        
        
        
        
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/registerScript.js"></script>
        <script src="js/script.js"></script>
        <script src="js/sesionActivaJS.js"></script>
    </body>

</html>
