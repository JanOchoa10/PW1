/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var settingsMenu = document.querySelector(".settings-menu");

var darkBtn = document.getElementById("dark-btn");

function settingsMenuToggle() {
    settingsMenu.classList.toggle("settings-menu-height");
}

darkBtn.onclick = function () {
    darkBtn.classList.toggle("dark-btn-on");
    document.body.classList.toggle("dark-theme");

    if (localStorage.getItem("theme") == "light") {
        localStorage.setItem("theme", "dark");
    } else {
        localStorage.setItem("theme", "light");
    }
}

if (localStorage.getItem("theme") == "light") {
    darkBtn.classList.remove("dark-btn-on");
    document.body.classList.remove("dark-theme");
} else if (localStorage.getItem("theme") == "dark") {
    darkBtn.classList.add("dark-btn-on");
    document.body.classList.add("dark-theme");
} else {
    localStorage.setItem("theme", "light");
}

function logout() {
    Swal.fire({
        icon: 'question',
        title: '¿Deseas cerrar sesión?',
//        text: 'La contraseña debe contener al menos 1 mayúscula, 1 minúscula, 1 número y 1 caracter especial.',
        confirmButtonText: 'Sí',
        showCancelButton: true,
        cancelButtonText: 'Cancelar',
        //footer: '<a href="">Why do I have this issue?</a>'
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            window.location.href='Logout';
        } 
    })
}