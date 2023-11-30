window.onload = function () {
  console.log("Clinica Odontologica Abierta...");
};


// Funciones Odontologo
// Crear Odontologo.
function crearPaciente() {
  let pacienteNuevo = {
    nombre: document.getElementById("nombre").value,
    apellido: document.getElementById("apellido").value,
    dni: document.getElementById("dni").value,
    fechaIngreso: document.getElementById("fechaIngreso").value,
    domicilioEntradaDto: {
      calle: document.getElementById("calle").value,
      numero: document.getElementById("numero").value,
      localidad: document.getElementById("localidad").value,
      provincia: document.getElementById("provincia").value,
  }
  };

  enviarPaciente(pacienteNuevo);
  console.log("Paciente creado");
  console.log(pacienteNuevo);
}



// Eliminar Odontologo.
function eliminarPacientePorId() {
  console.log("Eliminar Paciente");
  eliminarPaciente();
}

// Consultar Odontologo por id.
function consultarPacientePorId() {
    console.log("consultar Paciente");
    let id = document.getElementById("pacienteId").value;
    consultarPaciente(id);
  }

// Consultar todos los Odontologos.
function consultarPacientes() {
  console.log("ConsultarTodosPacientes");
  consultarTodosPacientes();
}

// Actualizar Odontologo.
function actualizarPaciente() {
  console.log("Actualizar Paciente");
  let pacienteNuevo = {
    id: document.getElementById("actualizarPacienteId").value,
    nombre: document.getElementById("actualizarNombrePaciente").value,
    apellido: document.getElementById("actualizarApellidoPaciente").value,
    dni: document.getElementById("actualizarDniPaciente").value,
    fechaIngreso: document.getElementById("actualizarFechaIngresoPaciente").value,
    domicilioEntradaDto: {
      calle: document.getElementById("actualizarCallePaciente").value,
      numero: document.getElementById("actualizarNumeroPaciente").value,
      localidad: document.getElementById("actualizarLocalidadPaciente").value,
      provincia: document.getElementById("actualizarProvinciaPaciente").value,
  }
}
  modificarPaciente(pacienteNuevo);
}

// Limpiar formulario.
function limpiarFormulario(formId) {
  document.getElementById(formId).reset();
  console.log("Se limpió el formulario " + formId);
}


//METODOS HTTP
// POST PACIENTE.
function enviarPaciente(pacienteNuevo) {
    let options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
    body: JSON.stringify(pacienteNuevo),
};

let url = "http://localhost:8081/pacientes/registrar";
fetch(url, options)
.then((Response) => Response.json())
.then((data) => console.log(data.id));
}

// DELETE ODONTOLOGO.
function eliminarPaciente() {
  let pacienteId = document.getElementById("pacienteId").value;

  let options = {
    method: "DELETE",
    };

  let url = `http://localhost:8081/pacientes/eliminar/${pacienteId}`;

  try {
    fetch(url, options);
  } catch (error) {
    console.log("Hubo un error en la consultar. Por favor verifica el id");
  }

  document.getElementById("consultarPacientesForm").reset();
    console.log("Se eliminó el odontólogo con id " + pacienteId);
}






// GET PACIENTE X ID
function consultarPaciente(id) {
  let pacienteId = id;
  console.log("dentro de consultar paciente");
  let url = `http://localhost:8081/pacientes/${pacienteId}`;

  let idRetorno = null

  fetch(url)
    .then((Response) => Response.json())
    .then((data) => console.log(data))
    .then((data) => idRetorno = data.id)
    .catch((error) =>
      console.log("Hubo un error en la consultar. Por favor verifica el id" + error)
    );
    console.log(idRetorno);
    return idRetorno;
}

// GET TODOS LOS pacientes
function consultarTodosPacientes(){
  let options = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  };

  let url = "http://localhost:8081/pacientes/listar";

  fetch(url, options)
    .then((Response) => Response.json())
    .then((data) => console.log(data));
}


/*function modificarPaciente(pacienteNuevo) {
  let pacienteId = pacienteNuevo.id;
  console.log(pacienteId+ " " + "paciente id");
  
    if (consultarPaciente(pacienteId) != null) {
    let options = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(pacienteNuevo),
    };

    let url = `http://localhost:8081/pacientes/actualizar`;

    fetch(url, options)
      .then((Response) => Response.json())
      .then((data) => (data))
      .catch((error) =>
        console.log("Hubo un error en la consultar. Por favor verifica el id" + error)
      );
      return pacienteId;


  } 
  else {
    console.log("No se encontro paciente");
      }
}*/

function modificarPaciente(pacienteNuevo) {
    let pacienteId = pacienteNuevo.id;
    if (ejecutarOperacionAsync(pacienteId)) {
      let options = {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(pacienteNuevo),
      };
  
      let url = `http://localhost:8081/pacientes/actualizar`;
  
      fetch(url, options)
        .then((Response) => Response.json())
        .then((data) => (data))
        .catch((error) =>
          console.log("Hubo un error en la consultar. Por favor verifica el id" + error)
        );
        console.log(pacienteNuevo);
        return pacienteId;
  } 
    else {  
          console.log("No se encontro paciente");
    }
  }


async function ejecutarOperacionAsync(id) {
  let resultado = null;
  try {
    
    resultado = await fetch(`http://localhost:8081/pacientes/${id}`);
    console.log('Operación completada con éxito:', resultado);
    // Puedes hacer más cosas con el resultado aquí
  } catch (error) {
    console.error('Error en la operación:', error);
    // Manejar errores aquí si es necesario
  }
  console.log(resultado.ok);
  return resultado;
}