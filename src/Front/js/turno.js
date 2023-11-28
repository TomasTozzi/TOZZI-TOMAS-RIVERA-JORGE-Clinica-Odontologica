window.onload = function () {
    console.log("Clinica Odontologica Abierta...");
  };
  
  
  // Funciones Odontologo
  // Crear Odontologo.
  function crearTurno() {
    let turnoNuevo = {
        fechaYHora: document.getElementById("crearFechaTurno").value,
        paciente: document.getElementById("turnoPacienteId").value,
        odontologo: document.getElementById("turnoOdontologoId").value,

    };
    enviarTurno(turnoNuevo);
    console.log("Turno creado");
    console.log(turnoNuevo);
  }
  // Eliminar Odontologo.
  function eliminarTurnoPorId() {
    console.log("Eliminar Odontologo");
    let turnoId = document.getElementById("turnoId").value;

    eliminarTurno();
    console.log("Se elimino el turno con id: " + turnoId);
    limpiarFormulario("consultarTurnosForm");
  }
  
  // Consultar Odontologo por id.
  function consultarTurnoPorId() {
      console.log("consultar Turno");
      let id = document.getElementById("turnoId").value;
      consultarTurno(id);
    }
  
  // Consultar todos los Odontologos.
  function consultarTurnos() {
    console.log("ConsultarTodosTurnos");
    consultarTodosTurnos();
  }
  
  // Actualizar Odontologo.
  function updateTurno() {
    console.log("Actualizar Odontologo");
    let turnoNuevo = {
      id: document.getElementById("actualizarTurnoId").value,
      fechaYHora: document.getElementById("actualizarFechaTurno").value,
      paciente: document.getElementById("actualizarTurnoPacienteId").value,
      odontologo: document.getElementById("actualizarTurnoOdontologoId").value,
    };
    modificarTurno(turnoNuevo);
  }
  

  
// Limpiar formulario.
function limpiarFormulario(formId) {
    document.getElementById("turnoId").value = "";
    document.getElementById("actualizarTurnoId").value = "";

    // console.log(id);
    // id.innerText = "";
    
    console.log("Se limpió el formulario " + formId )  }



  
  //METODOS HTTP
  // POST ODONTOLOGO.
  function enviarTurno(turnoNuevo) {
      let options = {
          method: "POST",
          headers: {
              "Content-Type": "application/json",
          },
      body: JSON.stringify(turnoNuevo),
  };
  
  let url = "http://localhost:8081/turnos/registrar";
  fetch(url, options)
  .then((Response) => Response.json())
  .then((data) => console.log(data.id));
  }
  
  // DELETE ODONTOLOGO.
  function eliminarTurno() {
    let turnoId = document.getElementById("turnoId").value;
    
    let options = {
      method: "DELETE",
       };
  
    let url = `http://localhost:8081/turnos/eliminar/${turnoId}`;
  
    try {
      fetch(url, options);
    } catch (error) {
      console.log("Hubo un error en la consultar. Por favor verifica el id");
    }
  
    
  }
  
  // GET ODONTOLOGO X ID
  function consultarTurno(id) {
    
    console.log("dentro de consultar turnos");
    let options = {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    };
  
    let url = `http://localhost:8081/turnos/${id}`;
  
  
    
    fetch(url, options)
    .then((Response) => Response.json())
    .then((data) =>  console.log(data))
    .catch((error) => console.log(error));
  
  }
  
  // GET TODOS LOS ODONTOLOGOS
  function consultarTodosTurnos() {
    let options = {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    };
  
    let url = "http://localhost:8081/turnos/listar";
  
    fetch(url, options)
      .then((Response) => Response.json())
      .then((data) => console.log(data));
  }
  
  
  function modificarTurno(turnoNuevo) {
    let Id = turnoNuevo.id;
    console.log(turnoNuevo.id + "turno id");
    
  let turnoEncontrado = consultarTurno(Id);
  console.log("Retorno" + turnoEncontrado);
  if (turnoEncontrado == undefined) {
    console.log("No se encontró elTurno");
  } else {
  
  console.log("Se modifica el turno");
  enviarTurno(turnoNuevo);
  
  
  
  
  
  }
  }