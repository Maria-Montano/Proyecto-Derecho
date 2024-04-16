/*const express = require ('express'); //importar modulos

//crea una instancia express
const app= express();
const port=8081;   // PUERTO DEL SERVIDOR

//ruta para el endpoins /registro
app.post('/registro', (req, res) =>{
    const Destinatario = req.body.Destinatario;  //el valor que hay en el campo Destinatario del html
    const Texto = req.body.Texto;  //VALOR DEL TEXTO

    //Enviaremos los datos obtenidos del html
    res.send('Solicitud recibida. Destinatario' + Destinatario + 'Texto' + Texto);
});

//Inicia el Servidor 
app.listen(port, () => {
    console.log('Servidor en http://localhost:${port} ');
});

*/

document.getElementById('Correo').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

    // Obtener los valores de los campos del formulario
    var destinatario = document.getElementById('Destinatario').value;
    var texto = document.getElementById('Texto').value;

    // Crear un objeto con los datos a enviar
    var data = {
        destinatario: destinatario,
        texto: texto
    };

    // Enviar una solicitud POST al backend
    fetch('/Enviar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.text())
    .then(message => {
        alert(message); // Mostrar el mensaje de respuesta del servidor
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
