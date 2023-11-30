window.onload = function () {
  console.log("Clinica Odontologica Abierta...");
};

// Funciones Odontologo
// Crear Odontologo.
function crearOdontologo() {
  let odontologoNuevo = {
    matricula: document.getElementById("crearMatricula").value,
    nombre: document.getElementById("crearNombreOdontologo").value,
    apellido: document.getElementById("crearApellidoOdontologo").value,
  };
  enviarOdontologo(odontologoNuevo);
  console.log("Odontólogo creado");
  console.log(odontologoNuevo);
}
// Eliminar Odontologo.
function eliminarOdontologoPorId() {
  console.log("Eliminar Odontologo");
  eliminarOdontologo();
}

// Consultar Odontologo por id.
function consultarOdontologoPorId() {
  console.log("consultar Odontologo");
  let id = document.getElementById("odontologoId").value;
  consultarOdontologo(id);
}

// Consultar todos los Odontologos.
function consultarOdontologos() {
  console.log("ConsultarTodosOdontologos");
  consultarTodosOdontologos();
}

// Actualizar Odontologo.
function updateOdontologo() {
  console.log("Actualizar Odontologo");
  let odontologoNuevo = {
    id: document.getElementById("actualizarOdontologoId").value,
    matricula: document.getElementById("actualizarMatriculaOdontologo").value,
    nombre: document.getElementById("actualizarNombreOdontologo").value,
    apellido: document.getElementById("actualizarApellidoOdontologo").value,
  };
  
  modificarOdontologo(odontologoNuevo);
}

// Limpiar formulario.
function limpiarFormulario(formId) {
  document.getElementById(formId).reset();
  console.log("Se limpió el formulario " + formId);
}

//METODOS HTTP
// POST ODONTOLOGO.
function enviarOdontologo(odontologoNuevo) {
  let options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(odontologoNuevo),
  };

  let url = "http://localhost:8081/odontologo/registrar";
  fetch(url, options)
    .then((Response) => Response.json())
    .then((data) => console.log(data.id));
}

// DELETE ODONTOLOGO.
function eliminarOdontologo() {
  let odontologoId = document.getElementById("odontologoId").value;

  let options = {
    method: "DELETE",
  };

  let url = `http://localhost:8081/odontologo/eliminar/${odontologoId}`;

  try {
    fetch(url, options);
  } catch (error) {
    console.log("Hubo un error en la consultar. Por favor verifica el id");
  }

  document.getElementById("consultarOdontologosForm").reset();
  console.log("Se eliminó el odontólogo con id " + odontologoId);
}

// GET ODONTOLOGO X ID
function consultarOdontologo(id) {
  console.log("dentro de consultar odontologo");
  console.log("ID: " + id);

  let url = `http://localhost:8081/odontologo/${id}`;
  let datos = fetch(url)
    .then((Response) => Response.json())
    .then((data) => console.log(data))
    .catch((error) => console.log(error));

  console.log(datos);

}

// GET TODOS LOS ODONTOLOGOS
function consultarTodosOdontologos() {
  let options = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  };

  let url = "http://localhost:8081/odontologo/listar";

  fetch(url, options)
    .then((Response) => Response.json())
    .then((data) => console.log(data));
}




// Función modificarOdontologo con async/await
function modificarOdontologo(odontologoNuevo) {
  console.log("*****************************");
    let id = odontologoNuevo.id;
    console.log("Odontologo id: " + id);

   


      // Llamar a la función para enviar el odontólogo modificado
  enviarModificacionOdontologo(odontologoNuevo);

}



function enviarModificacionOdontologo(odontologoNuevo) {
  let options = {
    method: "UPDATE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(odontologoNuevo),
  };

  let url = "http://localhost:8081/odontologo/actualizar";
  fetch(url, options)
    .then((Response) => Response.json())
    .then((data) => console.log(data.id));
}