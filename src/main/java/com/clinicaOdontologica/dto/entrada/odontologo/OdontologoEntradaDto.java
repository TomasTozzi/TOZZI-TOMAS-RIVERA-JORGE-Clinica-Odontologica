package com.clinicaOdontologica.dto.entrada.odontologo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class OdontologoEntradaDto {


    @NotNull(message = "La Matricula del Odontologo no puede ser nula.")
    @Size(max = 12, message = "La matricula debe tener maximo 5 digitos")
    private String matricula;
    @NotNull(message = "El nombre del Odontolo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del Odontologo")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;

    @Size(max = 50, message = "El Odontologo debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido del Odontologo no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del Odontologo")
    private String apellido;

    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
