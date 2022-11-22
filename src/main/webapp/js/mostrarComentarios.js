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

//    if (agregar) {
        for (var i = 0; i < rojos.length; i++) {
//        rojos[i].classList.remove("rojo");
            if (i == posicion) {
//                if(rojos[i].classList.toggle())
                rojos[i].classList.toggle("contenedor-comentarios-height");
            }
        }
//        agregar = false;
//    } else {
//        for (var i = 0; i < rojos.length; i++) {
////        rojos[i].classList.remove("rojo");
//            if (i == posicion) {
//                rojos[i].classList.remove("contenedor-comentarios-height");
//            }
//        }
//        agregar = true;
//    }
}
