
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
    fetch('http://localhost:8081/Enviar', {
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
