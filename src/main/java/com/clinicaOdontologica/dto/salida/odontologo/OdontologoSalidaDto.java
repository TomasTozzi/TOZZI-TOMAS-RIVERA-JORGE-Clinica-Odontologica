package com.clinicaOdontologica.dto.salida.odontologo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OdontologoSalidaDto {

    private int id;
    private String matricula;
    private String nombre;
    private String apellido;


    public OdontologoSalidaDto() {
    }

    public OdontologoSalidaDto(int id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
