<%-- 
    Document   : editarNota
    Created on : 21 nov. 2022, 12:47:07
    Author     : Jan
--%>
<%@page import="Modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PostCat - Página principal</title>
        <link rel="shortcut icon" href="img/logo-cato.png">
        <!--<link rel="stylesheet" href="../css/mycss.css">-->
        <!--script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link rel="stylesheet" href="css/myEditStyle.css">
        <script src="https://kit.fontawesome.com/835e988e9b.js" crossorigin="anonymous"></script>

    </head>
    <!--<body>
        <div>
            <h1>Bienvenido a la pantalla principal</h1>
            <div>
                <input type="button" value="Cerrar sesión" name="volverAlLogin" onclick="location.href='../html/login.jsp'"></button>
            </div>
            
    <!--c:forEach items="usuarios" var="usuario">
        
    <!--/c:forEach>
    
    
    
</div>
</body>-->

    <body>

        <nav>
            <div class="nav-left">
                <img src="img/logo.png" class="logo" onclick="actualizarPag();">
                <!--<h4>PostCat</h4>-->
                <ul>
                    <li><a href="Recientes"><img src="img/newspaper-regular.png" title="Recientes"></a></li>
                    <li><a href="MasComentadas"><img src="img/comments-regular.png" title="Más comentadas"></a></li>
                    <li><a href="MasVotadas"><img src="img/thumbs-up-regular.png" title="Más votadas"></a></li>
                </ul>
            </div>
            <div class="nav-right">
                <div class="search-box">
                    <img src="img/search.png">
                    <input type="text" placeholder="Buscar">
                </div>
                <div class="nav-user-icon online" onclick="settingsMenuToggle()">
                    <img src="img/${usuarios[0].userImagen}">
                </div>
            </div>
            <!-- ------------settings-menu------------ -->
            <div class="settings-menu">

                <!--                <div id="dark-btn">
                                    <span></span>
                                </div>-->


                <div class="settings-menu-inner">
                    <div class="user-profile">
                        <img src="img/${usuarios[0].userImagen}">
                        <div>
                            <p>${usuarios[0].nombre}</p>
                            <a href="#">Editar tu perfil</a>
                        </div>
                    </div>
                    <hr>
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
                    <div class="settings-links">
                        <img src="img/arrow-right-from-bracket-solid.png" class="settings-icon">
                        <a onclick="logout()">Cerrar Sesión</a>
                    </div>
                </div>

            </div>

        </nav>

        <div class="container">
            <!-- ------------left-sidebar------------ -->
            <div class="left-sidebar">
                <div class="imp-links">
                    <!--<a href="#">Accesos Directos</a>-->
                    <p>Publicaciones</p>
                    <a href="Recientes"><img src="img/newspaper-regular.png">  Recientes</a>
                    <a href="MasComentadas"><img src="img/comments-regular.png">  Más comentadas</a>
                    <a href="MasVotadas"><img src="img/thumbs-up-regular.png"> Más votadas</a>
                    <!--                    <a href="#"><img src="img/marketplace.png"> Mercado</a>
                                        <a href="#"><img src="img/watch.png"> Ver</a>
                                        <a href="#">Ver más</a>-->
                </div>
                <!--                <div class="shortcut-links">
                                    <p>Accesos Directos</p>
                                    <a href="#"><img src="img/shortcut-1.png"> Desarolladores Web</a>
                                    <a href="#"><img src="img/shortcut-2.png"> Curso de Diseño Web</a>
                                    <a href="#"><img src="img/shortcut-3.png"> Desarrollo Completo</a>
                                    <a href="#"><img src="img/shortcut-4.png"> Sitios Expertos</a>
                                </div>-->
            </div>

            <!-- ------------main-content------------ -->




            <div class="main-content">

                <!--<h1>Mis usuarios: ${usuarios[0].nombre}</h1>-->

                <%--<c:forEach items="${usuarios}" var="usuario">--%>
                <h1><c:out value="${usuario.ID_Usuario}"></c:out></h1>
                <h1><c:out value="${usuario.nombre}"></c:out></h1>
                <h1><c:out value="${usuario.apePaterno}"></c:out></h1>
                <h1><c:out value="${usuario.apeMaterno}"></c:out></h1>
                <h1><c:out value="${usuario.fecNacimiento}"></c:out></h1>
                <h1><c:out value="${usuario.email}"></c:out></h1>
                <h1><c:out value="${usuario.userName}"></c:out></h1>
                <h1><c:out value="${usuario.contrasena}"></c:out></h1>

                    <h1><c:out value="${usuario.userImagen}"></c:out></h1>
                <h1><c:out value="${usuario.activo}"></c:out></h1>
                <h1><c:out value="${usuario.fechaDeCreacion}"></c:out></h1>
                <h1><c:out value="${usuario.fechaDeCambio}"></c:out></h1>
                <%--</c:forEach>--%>



                <%--<c:forEach items="${publicaciones}" var="publicacion">--%>
                <h1><c:out value="${publicacion.ID_Publicacion}"></c:out></h1>
                <h1><c:out value="${publicacion.texto}"></c:out></h1>
                <h1><c:out value="${publicacion.imagen}"></c:out></h1>
                <h1><c:out value="${publicacion.spoiler}"></c:out></h1>
                <h1><c:out value="${publicacion.ID_Usuario}"></c:out></h1>
                <h1><c:out value="${publicacion.activo}"></c:out></h1>

                    <h1><c:out value="${publicacion.fechaDeCreacion}"></c:out></h1>
                <h1><c:out value="${publicacion.fechaDeCambio}"></c:out></h1>
                <%--</c:forEach>--%>

                <!--                <div class="story-gallery">
                                    <div class="story story1">
                                        <img src="img/upload.png">
                                        <p>Post Story</p>
                                    </div>
                                    <div class="story story2">
                                        <img src="img/member-1.png">
                                        <p>Alison</p>
                                    </div>
                                    <div class="story story3">
                                        <img src="img/member-2.png">
                                        <p>Jackson</p>
                                    </div>
                                    <div class="story story4">
                                        <img src="img/member-3.png">
                                        <p>Samona</p>
                                    </div>
                                    <div class="story story5">
                                        <img src="img/member-4.png">
                                        <p>John Doe</p>
                                    </div>
                                </div>-->

                <c:forEach items="${publicacionEditable}" var="publicacion">
                    <div class="write-post-container">
                        <div class="user-profile">
                            <img src="img/${usuarios[0].userImagen}">
                            <div>
                                <p>${usuarios[0].nombre}</p>
                                <small>Público <i class="fas fa-caret-down"></i></small>
                            </div>
                        </div>

                        <div class="post-input-container">

                            <form action="ActualizarNota" method="POST">
                                <textarea type="text" name="miContenido" nrows="3" required maxlength="100">${publicacion.texto}</textarea>
                                <textarea name="idUsuario" style="display: none;">${usuarios[0].ID_Usuario}</textarea>
                                <textarea name="idNota" style="display: none;" >${publicacion.ID_Publicacion}</textarea>
                                <textarea name="miImgURL" style="display: none;">${publicacion.imagen}</textarea>
                                <div class="add-post-links">
                                    <!--<a href="#"><img src="img/live-video.png"> En vivo</a>-->


                                    <input style="display: none;" type="file" id="miImg"  name="miImg" accept="image/*"/>

                                    <label for="miImg"> 
                                        <div class="myLabel">
                                            <a title="Subir imagen"><img src="img/image-regular.png"> Actualizar imagen</a>
                                            <!--<img class="myImg" id="imagenSubida" src="img/logo-cato.png"/>-->
                                            <!--                                        <div>
                                                                                        <span id="tituloArchivo">Agregar imagen</span><br />
                                                                                        <span id="nombreArchivo"></span>
                                                                                    </div>-->
                                        </div>
                                    </label>
                                    <input type="checkbox" id="spoiler" name="spoiler" value="Spoiler"><a title="Guardar publicación"> &nbsp;Spoiler</a>

                                    <button type='submit'>
                                        <a title="Guardar cambios"><img src="img/floppy-disk-regular.png"> Guardar cambios</a>    
                                    </button>
                                    <!--<input type="submit" value="<a><img className='colorNav' src='img/floppy-disk-regular.png'> Guardar</a>">-->
                                    <!--<a href="#"><img className="colorNav" src="img/floppy-disk-regular.png"> Guardar</a>-->
                                    <!--<a href="#"><img src="img/feeling.png"> Sentimiento/Actividad</a>-->
                                </div>
                            </form>

                            <form action="Recientes" method="GET">
                                <div class="add-post-links">
                                    <button type='submit'>
                                        <a title="Cancelar"><img src="img/ban-solid.png"> Cancelar</a>    
                                    </button>
                                </div>
                            </form>
                            <br>
                            <c:if test="${publicacion.imagen != ''}">
                                <img src="img/${publicacion.imagen}" class="post-img">
                            </c:if>
                        </div>
                    </div>                           
                </c:forEach>

                <%--<c:forEach items="${publicaciones}" var="publicacion">--%>
                <%--<c:if test="${1 == publicacion.activo}">--%>
                <!--                        <div class="post-container">
                                            <div class="post-row">
                                                <div class="user-profile">
                <%--<c:forEach items="${usuariosall}" var="usuario">--%>
                    <h1><c:out value="${usuario.email}"></c:out></h1>

                <c:if test="${usuario.ID_Usuario == publicacion.ID_Usuario}">
                    <h1><c:out value="${usuario.email}"></c:out></h1>
                    <c:set var = "UserPostNombre" scope = "session" value = "${usuario.nombre}"></c:set>
                    <c:set var = "UserPostFoto" scope = "session" value = "${usuario.userImagen}"></c:set>
                </c:if>
                <%--</c:forEach>--%>

                <img src="img/${UserPostFoto}">


                <div>
                    <p>${UserPostNombre}</p>
                    <span>${publicacion.fechaDeCreacion}</span>
                </div>
            </div>
            <div>
                <c:if test="${usuarios[0].ID_Usuario == publicacion.ID_Usuario}">
                    <form action="EditarNota" method="POST">
                        <input type="text" name="idNota" value="${publicacion.ID_Publicacion}" style="display: none;"></input>
                        <button type='submit' style="background: transparent;
                                border: none;
                                cursor: pointer;">
                            <a><i class="fa-solid fa-pen-to-square"></i></a>                              
                        </button>
                    </form>
                    <form action="BorrarNota" method="POST">
                        <input type="text" name="idNota" value="${publicacion.ID_Publicacion}" style="display: none;"></input>
                        <button type='submit' style="background: transparent;
                                border: none;
                                cursor: pointer;">

                            <a><i class="fa-solid fa-trash"></i></a>                            
                        </button>
                    </form>
                </c:if>
            </div>
        </div>
        <p class="post-text">
                ${publicacion.texto}
                                            Trabajo en equipo <span>@Jobbin</span> donde todo trabajo se empieza y termina con la máxima calidad.
                                            <a href="#">#JOBBIN</a>
                                            <a href="#">#ROBBIN</a>
            </p>
                <c:if test="${publicacion.imagen != ''}">
                    <img src="img/${publicacion.imagen}" class="post-img">
                </c:if>

                <div class="post-row">
                    <div class="activity-icons">
                        <div><img src="img/like-blue.png"> 120</div>
                        <div><img src="img/comments.png"> 45</div>
                        <div><img src="img/share.png"> 20</div>
                    </div>
                    <div class="post-profile-icon">
                        <img src="img/${usuarios[0].userImagen}">
                                                    <i class="fas fa-caret-down"></i>
                    </div>
                </div>
            </div>-->
                <%--</c:if>--%>
                <%--</c:forEach>--%>

                <!--<button onclick="window.location.href = 'notas'" type="button" class="load-more-btn">Ver más</button>-->

            </div>
            <!-- ------------right-sidebar------------ -->
            <div class="right-sidebar">

                <div class="sidebar-title">
                    <h4>Etiquetas</h4>
                    <a href="#">Ver todas</a>
                </div>

                <div class="event">
                    <div class="left-event">
                        <h3>18</h3>
                        <span>Marzo</span>
                    </div>
                    <div class="right-event">
                        <h4>#RedSocial</h4>
                        <!-- <p><i class="fa-solid fa-location-dot"></i> Willson Tech Park</p> -->
                        <p><i class="fa-solid fa-user"></i> Josué Moncada</p>
                        <a href="#">Filtrar por esta etiqueta</a>
                    </div>
                </div>

                <div class="event">
                    <div class="left-event">
                        <h3>22</h3>
                        <span>Junio</span>
                    </div>
                    <div class="right-event">
                        <h4>#MarketingDeMóviles</h4>
                        <p><i class="fa-solid fa-user"></i> Gerardo Arias</p>
                        <a href="#">Filtrar por esta etiqueta</a>
                    </div>
                </div>

                <!--                <div class="sidebar-title">
                                    <h4>Anuncios</h4>
                                    <a href="#">Cerrar</a>
                                </div>
                
                                <img src="img/advertisement.png" class="sidebar-img">
                
                                <div class="sidebar-title">
                                    <h4>Conversaciones</h4>
                                    <a href="#">Ocultar Chat</a>
                                </div>
                
                                <div class="online-list">
                                    <div class="online">
                                        <img src="img/member-1.png">
                                    </div>
                                    <p>Alexa Lima</p>
                                </div>
                                <div class="online-list">
                                    <div class="online">
                                        <img src="img/member-2.png">
                                    </div>
                                    <p>Josué Moncada</p>
                                </div>
                                <div class="online-list">
                                    <div class="online">
                                        <img src="img/member-3.png">
                                    </div>
                                    <p>Jay Retta</p>
                                </div>-->
            </div>
        </div>

        <div class="footer">
            <br>
            <p>Copyright 2022 - PostCat por Jan Ochoa y Elvia Arriaga</p>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/script.js"></script>
        <script src="js/sesionNoActiva.js"></script>
        <script src="js/mostrarComentarios.js"></script>

    </body>

</html>
