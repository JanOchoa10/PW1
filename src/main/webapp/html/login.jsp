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
    <link rel="shortcut icon" href="../img/logo-cato.png">
    <link rel="stylesheet" href="../css/mycss.css">
    <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
</head>
<body>

    <div class="login-box" id="login-box">
        <img class="avatar" src="../img/logo-cato.png" alt="Logo de la página">
        <h1>¡Bienvenido de vuelta!</h1>
        <form method="get" id="formL">
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
                <a href="../html/register.jsp">¿No tienes cuenta? Regístrate</a>
            </div>
            
        </form>
    
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/loginScript.js"></script>
</body>

</html>