/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function borrarPost() {

    Swal.fire({
        icon: 'question',
        title: '¿Desea borrar esta publicación?',
        text: 'No podrá volver a ver esta publicación.',
        confirmButtonText: 'Sí, borrar',
        showDenyButton: true,
        denyButtonText: `Cancelar`,
        denyButtonColor: '#6f7880'
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire({
                icon: 'success',
                title: '¡Registro exitoso!',
                text: 'Se registró la cuenta exitosamente.',
                confirmButtonText: 'Volver al inicio de sesión'
            }).then((value) => {
                window.location.href = '../html/login.jsp';
            });
        } else if (result.isDenied) {
            //console.log('Valor del input: ' + valorN);
        }
    });

}