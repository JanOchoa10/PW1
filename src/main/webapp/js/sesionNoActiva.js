/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



$.ajax({
    async: false,
    type: "GET",
    dataType: "json",
    url: "RevisarSesion"
}).done(function (data) {
    console.log(data);
    if (data.respuesta == false) {
        //alert("Sesion no activa");
        window.location.href = "./";
    }
}).fail(function (jqXHR, textEstado) {
    console.log("La solicitud regreso con un error: " + textEstado);
});