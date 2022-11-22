/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



//var settingsMenu = document.querySelector(".contenedor-comentarios");

//var darkBtn = document.getElementById("dark-btn");


var rojos = document.getElementsByClassName("contenedor-comentarios");
//var agregar = true;

function MostrarComentarios(posicion) {
//    settingsMenu.classList.toggle("contenedor-comentarios-height");

    console.log("Mi posicion: " + posicion)
    for (var i = 0; i < rojos.length; i++) {
        if (i == posicion) {
            rojos[i].classList.toggle("contenedor-comentarios-height");
        }
    }
}

function colorVoto(posicion) {


    for (var i = 0; i < rojos.length; i++) {
        if (i == posicion) {
            var voto = document.getElementById("voto"+posicion);
            var votoActual = voto.getAttribute("src");

            console.log("Mi valor actual: " + votoActual)

            if (votoActual == "img/like.png") {
                voto.setAttribute("src", "img/like-blue.png");
            } else if (votoActual == "img/like-blue.png") {
                voto.setAttribute("src", "img/like.png");
            }
        }
    }

}