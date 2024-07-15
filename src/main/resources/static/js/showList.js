const url = "http://localhost:8080/listarPeliculas";

//gets saved elements  from db and shows them in cards

// Fetch data from API
async function getPelis(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();
    // console.log(data);
    return data; 
  } catch (error) {
    console.error('Error:', error);
    return [];
  }
}

// Grid cards
async function renderPelis() {
  const gridSection = document.getElementById('grid-cards');
  const results = await getPelis(url);

  if (results && Array.isArray(results)) {
    gridSection.innerHTML = results.map(result => `
      <div class="card animGrid" id="card-${result.id}" data-portada="${result.portada || 'placeholder.jpg'}">
        <img src="${result.portada || 'placeholder.jpg'}" class="card-img-top img-fluid img-thumbnail rounded fade-in-center" alt="${result.name}">
        <div class="card-body">
          <div class="image-container">
            <button class="garbage-can" onclick="delPeli(${result.id})">
              <img src="../public/rubbish-bin.svg" alt="Delete" />
              <span class="tooltip">Borrar</span>  
            </button> 
          </div>
          <input type="text" class="form-control mb-2" id="titulo-${result.id}" value="${result.titulo}">
          <input type="text" class="form-control mb-2" id="puntuacion-${result.id}" value="${result.puntuacion || ''}">
          <input type="hidden" class="form-control mb-2" id="portada-${result.id}" value="${result.portada || ''}">
          <input type="text" class="form-control mb-2" id="review-${result.id}" value="${result.review || ''}">
          <button class="btn btn-other" onclick="savePeli(${result.id})">Guardar cambios</button>
        </div>
      </div>
    `).join('');
  } else {
    gridSection.innerHTML = '<p>Vacio</p>';
  }
}


async function delPeli(id) {
  try {
     await fetch(`http://localhost:8080/delPelicula/${id}`, {
      method: 'DELETE',
    });
    okDel();
  } catch (error) {
    dibujarError(error);
  }
}

function okDel() {
  alert('Eliminada!');
            window.location.href = './list.html'; // Redirect 
}

function dibujarError(error) {
  document.querySelector('#grid-cards').innerHTML = `Error: ${error}`;
}

async function savePeli(id) {
  const card = document.getElementById(`card-${id}`);
  const storedPortada = card.getAttribute('data-portada');

  const titulo = document.getElementById(`titulo-${id}`).value;
  const puntuacion = document.getElementById(`puntuacion-${id}`).value;
  const portada = document.getElementById(`portada-${id}`).value || storedPortada;
  const review = document.getElementById(`review-${id}`).value;

  const peliculaData = {
    titulo: titulo,
    puntuacion: puntuacion,
    portada: portada,
    review: review
  };

  try {
    const response = await fetch(`http://localhost:8080/updatePelicula/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(peliculaData)
    });
    if (response.ok) {
      alert('Pelicula actualizada exitosamente');
      renderPelis(); // Refresh the list
    } else {
      alert('Error al actualizar la pelicula');
    }
  } catch (error) {
    console.error('Error:', error);
  }

}



// Call functions
renderPelis();
