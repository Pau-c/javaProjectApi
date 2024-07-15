

document.getElementById('peliculaForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent the default form submission

    const nombre = document.getElementById('nombre').value;
    const puntuacion = document.getElementById('puntuacion').value;
    const portada = document.getElementById('portada').value;
    const review = document.getElementById('review').value;

    const peliculaData = {
        titulo: nombre,
        puntuacion: puntuacion,
        portada: portada,
        review: review
    };

    try {
        const response = await fetch('http://localhost:8080/addPelicula', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(peliculaData)
        });

        if (response.ok) {
            alert('Agregada!');
            window.location.href = './list.html'; // Redirect 
        } else {
            alert('Error');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Error, proba otra vez');
    }
});

