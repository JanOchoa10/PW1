<%-- 
    Document   : passwordLost
    Created on : 15 oct. 2022, 09:58:12
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PostCat - Recuperar contraseña</title>
    <link rel="shortcut icon" href="../img/logo-cato.png">
    <link rel="stylesheet" href="../css/mycss.css">
    <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>

    <div class="login-box-lost">
        <img class="avatar" src="../img/logo-cato.png" alt="Logo de la página">
        <h1>Recupera tu contraseña</h1>
        <form method="get" id="formP">
            <label for="email">Correo electrónico</label>
            <input type="email" name="email" id="email" maxlength="30" required placeholder="Ingresa tu correo electrónico">

            <input type="submit" value="Recuperar contraseña">

            <a href="../html/login.jsp">¿Ya tienes una cuenta?</a><br>
            <a href="../html/register.jsp">¿No tienes una cuenta?</a>
        </form>
    
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/passwordLostScript.js"></script>
</body>

</html>