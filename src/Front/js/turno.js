window.onload = function () {
  console.log("Clinica Odontologica Abierta...");
};


// Funciones Odontologo
function crearOdontologo() {
  let odontologoNuevo = {
    matricula: document.getElementById("matricula").value,
    nombre: document.getElementById("nombreOdontologo").value,
    apellido: document.getElementById("apellidoOdontologo").value,
  };
  enviarOdontologo(odontologoNuevo);
  console.log("Odontólogo creado");
  console.log(odontologoNuevo);
}
function eliminarOdontologoPorId() {
  console.log("Eliminar Odontologo");
  eliminarOdontologo();
}

function consultarOdontologoPorId() {
    console.log("consultar Odontologo");
    consultarOdontologo();
  }

function consultarOdontologos() {
  console.log("ConsultarTodosOdontologos");
  consultarTodosOdontologos();
}


function limpiarFormulario(formId) {
  document.getElementById(formId).reset();
  console.log("Se limpió el formulario " + formId);
}


//METODOS HTTP
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

function consultarOdontologo() {
  let odontologoId = document.getElementById("odontologoId").value;

  let options = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  };

  let url = `http://localhost:8081/odontologo/${odontologoId}`;

  fetch(url, options)
    .then((Response) => Response.json())
    .then((data) => console.log(data))
    .catch((error) =>
      console.log("Hubo un error en la consultar. Por favor verifica el id")
    );
}

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
