<%-- 
    Document   : login
    Created on : 15 oct. 2022, 09:48:11
    Author     : Jan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PostCat - Inicio de sesión</title>
        <link rel="shortcut icon" href="img/logo-cato.png">
        <link rel="stylesheet" href="css/mycss.css">
        <link rel="stylesheet" href="css/style2.css">
        <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>
    <body>         

        <!--        <form action="Página_Principal" method="GET">
                    <label>Nombre: </label>
                    <input type="text" id="idNombre" name="nombre" />
                    <br>
                    <label>Contraseña: </label>
                    <input type="password" id="idContra" name="contra" />
                    <br> 
                    <button type="submit">Ingresar</button>
                </form>
                <br> comment 
                <form action="Página_Principal" method="POST">
                    <button type="submit">Mostrar Usuarios</button>
                </form>-->

        <nav>
            <div class="nav-left">
                <img src="img/logo.png" class="logo">
                <!--<h4>PostCat</h4>-->
                <ul>
                    <li><img src="img/notification.png"></li>
                    <li><img src="img/inbox.png"></li>
                    <li><img src="img/video.png"></li>
                </ul>
            </div>
            <div class="nav-right">
                <div class="search-box">
                    <img src="img/search.png">
                    <input type="text" placeholder="Buscar">
                </div>
                <div class="nav-user-icon online" onclick="settingsMenuToggle()">
                    <img src="img/profile-pic.png">
                </div>
            </div>
            <!-- ------------settings-menu------------ -->
            <div class="settings-menu">

                <div id="dark-btn">
                    <span></span>
                </div>


                <div class="settings-menu-inner">
                    <div class="user-profile">
                        <img src="img/profile-pic.png">
                        <div>
                            <p>${usuarios[0].nombre}</p>
                            <a href="#">Editar tu perfil</a>
                        </div>
                    </div>
                    <hr>
                    <div class="user-profile">
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
                    </div>
                    <div class="settings-links">
                        <img src="img/logout.png" class="settings-icon">
                        <a onclick="logout()">Cerrar Sesión <img src="img/arrow.png" width="10px"></a>
                    </div>
                </div>

            </div>

        </nav>

        <div class="login-box" id="login-box">
            <img class="avatar" src="img/logo-cato.png" alt="Logo de la página">
            <h1>¡Bienvenido de vuelta!</h1>
            <form action="Página_Principal" method="POST" id="formL">
                <label for="username" id="usernameLabel">Nombre de usuario</label>
                <input type="text" name="username" id="username" maxlength="30" required placeholder="Ingresa tu nombre de usuario">
                <div id="myUsername">
                    <br>
                </div>
                <label for="password" id="password1Label">Contraseña</label>
                <input type="password" name="password1" id="password1" maxlength="30" minlength="8" required placeholder="Ingresa tu contraseña">
                <div id="myPassword1">
                    <br>
                </div>
                <input type="submit" value="Iniciar sesión">

                <!--a href="../html/passwordLost.jsp">¿Olvidaste tu contraseña?</a><br-->
                <div class="centrado">
                    <a href="html/register.jsp">¿No tienes cuenta? Regístrate</a>
                </div>

            </form>

        </div>


        <div class="footer">
            <br>
            <p>Copyright 2022 - PostCat por Jan Ochoa y Elvia Arriaga</p>
        </div>






        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/loginScript.js"></script>
        <script src="js/script.js"></script>
        <!--<script src="js/login.js"></script>-->
    </body>

</html>
