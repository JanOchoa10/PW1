<%-- 
    Document   : home
    Created on : 15 oct. 2022, 09:58:27
    Author     : Jan
--%>
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
        <link rel="stylesheet" href="css/style.css">
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
                            <p>Jan Ochoa</p>
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

        <div class="container">
            <!-- ------------left-sidebar------------ -->
            <div class="left-sidebar">
                <div class="imp-links">
                    <a href="#"><img src="img/news.png"> Últimas noticias</a>
                    <a href="#"><img src="img/friends.png"> Amigos</a>
                    <a href="#"><img src="img/group.png"> Grupos</a>
                    <a href="#"><img src="img/marketplace.png"> Mercado</a>
                    <a href="#"><img src="img/watch.png"> Ver</a>
                    <a href="#">Ver más</a>
                </div>
                <div class="shortcut-links">
                    <p>Accesos Directos</p>
                    <a href="#"><img src="img/shortcut-1.png"> Desarolladores Web</a>
                    <a href="#"><img src="img/shortcut-2.png"> Curso de Diseño Web</a>
                    <a href="#"><img src="img/shortcut-3.png"> Desarrollo Completo</a>
                    <a href="#"><img src="img/shortcut-4.png"> Sitios Expertos</a>
                </div>
            </div>

            <!-- ------------main-content------------ -->
            
            
            
            
            <div class="main-content">
                
                <h1>Mis usuarios: ${usuarios}</h1>
        
        <c:forEach items="${usuarios}" var="usuario">
            <h1><c:out value="${usuario.nombre}"></c:out></h1>
        </c:forEach>

                <div class="story-gallery">
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
                </div>


                <div class="write-post-container">
                    <div class="user-profile">
                        <img src="img/profile-pic.png">
                        <div>
                            <p>Jan Ochoa</p>
                            <small>Público <i class="fas fa-caret-down"></i></small>
                        </div>
                    </div>

                    <div class="post-input-container">
                        <textarea nrows="3" placeholder="¿Qué estás pensando, Jan?"></textarea>
                        <div class="add-post-links">
                            <a href="#"><img src="img/live-video.png"> En vivo</a>
                            <a href="#"><img src="img/photo.png"> Foto/Video</a>
                            <a href="#"><img src="img/feeling.png"> Sentimiento/Actividad</a>
                        </div>
                    </div>
                </div>

                <div class="post-container">
                    <div class="post-row">
                        <div class="user-profile">
                            <img src="img/profile-pic.png">
                            <div>
                                <p>Jan Ochoa</p>
                                <span>Junio 24 2022, 13:40 pm</span>
                            </div>
                        </div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                    <p class="post-text">
                        Trabajo en equipo <span>@Jobbin</span> donde todo trabajo se empieza y termina con la máxima calidad.
                        <a href="#">#JOBBIN</a>
                        <a href="#">#ROBBIN</a>
                    </p>
                    <img src="img/feed-image-1.png" class="post-img">


                    <div class="post-row">
                        <div class="activity-icons">
                            <div><img src="img/like-blue.png"> 120</div>
                            <div><img src="img/comments.png"> 45</div>
                            <div><img src="img/share.png"> 20</div>
                        </div>
                        <div class="post-profile-icon">
                            <img src="img/profile-pic.png">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>
                </div>

                <div class="post-container">
                    <div class="post-row">
                        <div class="user-profile">
                            <img src="img/profile-pic.png">
                            <div>
                                <p>Jan Ochoa</p>
                                <span>Junio 24 2022, 13:40 pm</span>
                            </div>
                        </div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                    <p class="post-text">
                        Lo mejor de los amigos son las reuniones.
                        <a href="#">#Fogata</a>
                        <a href="#">#PlayaYBombones</a>
                    </p>
                    <img src="img/feed-image-2.png" class="post-img">


                    <div class="post-row">
                        <div class="activity-icons">
                            <div><img src="img/like-blue.png"> 120</div>
                            <div><img src="img/comments.png"> 45</div>
                            <div><img src="img/share.png"> 20</div>
                        </div>
                        <div class="post-profile-icon">
                            <img src="img/profile-pic.png">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>
                </div>
                <div class="post-container">
                    <div class="post-row">
                        <div class="user-profile">
                            <img src="img/profile-pic.png">
                            <div>
                                <p>Jan Ochoa</p>
                                <span>Junio 24 2022, 13:40 pm</span>
                            </div>
                        </div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                    <p class="post-text">
                        Lo mejor de los amigos son las reuniones.
                        <a href="#">#Fogata</a>
                        <a href="#">#PlayaYBombones</a>
                    </p>
                    <img src="img/feed-image-3.png" class="post-img">


                    <div class="post-row">
                        <div class="activity-icons">
                            <div><img src="img/like-blue.png"> 120</div>
                            <div><img src="img/comments.png"> 45</div>
                            <div><img src="img/share.png"> 20</div>
                        </div>
                        <div class="post-profile-icon">
                            <img src="img/profile-pic.png">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>
                </div>
                <div class="post-container">
                    <div class="post-row">
                        <div class="user-profile">
                            <img src="img/profile-pic.png">
                            <div>
                                <p>Jan Ochoa</p>
                                <span>Junio 24 2022, 13:40 pm</span>
                            </div>
                        </div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                    <p class="post-text">
                        Lo mejor de los amigos son las reuniones.
                        <a href="#">#Fogata</a>
                        <a href="#">#PlayaYBombones</a>
                    </p>
                    <img src="img/feed-image-4.png" class="post-img">


                    <div class="post-row">
                        <div class="activity-icons">
                            <div><img src="img/like-blue.png"> 120</div>
                            <div><img src="img/comments.png"> 45</div>
                            <div><img src="img/share.png"> 20</div>
                        </div>
                        <div class="post-profile-icon">
                            <img src="img/profile-pic.png">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>
                </div>
                <div class="post-container">
                    <div class="post-row">
                        <div class="user-profile">
                            <img src="img/profile-pic.png">
                            <div>
                                <p>Jan Ochoa</p>
                                <span>Junio 24 2022, 13:40 pm</span>
                            </div>
                        </div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                    <p class="post-text">
                        Lo mejor de los amigos son las reuniones.
                        <a href="#">#Fogata</a>
                        <a href="#">#PlayaYBombones</a>
                    </p>
                    <img src="img/feed-image-5.png" class="post-img">


                    <div class="post-row">
                        <div class="activity-icons">
                            <div><img src="img/like-blue.png"> 120</div>
                            <div><img src="img/comments.png"> 45</div>
                            <div><img src="img/share.png"> 20</div>
                        </div>
                        <div class="post-profile-icon">
                            <img src="img/profile-pic.png">
                            <i class="fas fa-caret-down"></i>
                        </div>
                    </div>
                </div>

                <button type="button" class="load-more-btn">Ver más</button>

            </div>
            <!-- ------------right-sidebar------------ -->
            <div class="right-sidebar">

                <div class="sidebar-title">
                    <h4>Eventos</h4>
                    <a href="#">Ver todos</a>
                </div>

                <div class="event">
                    <div class="left-event">
                        <h3>18</h3>
                        <span>Marzo</span>
                    </div>
                    <div class="right-event">
                        <h4>Red Social</h4>
                        <!-- <p><i class="fa-solid fa-location-dot"></i> Willson Tech Park</p> -->
                        <p><i class="fas fa-map-marker-alt"></i> Willson Tech Park</p>
                        <a href="#">Saber más</a>
                    </div>
                </div>

                <div class="event">
                    <div class="left-event">
                        <h3>22</h3>
                        <span>Junio</span>
                    </div>
                    <div class="right-event">
                        <h4>Marketing de Móviles</h4>
                        <p><i class="fas fa-map-marker-alt"></i> Willson Tech Park</p>
                        <a href="#">Saber más</a>
                    </div>
                </div>

                <div class="sidebar-title">
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
                </div>
            </div>
        </div>

        <div class="footer">
            <br>
            <p>Copyright 2022 - PostCat por Jan Ochoa y Elvia Arriaga</p>
        </div>

        <script src="js/script.js"></script>

    </body>

</html>
