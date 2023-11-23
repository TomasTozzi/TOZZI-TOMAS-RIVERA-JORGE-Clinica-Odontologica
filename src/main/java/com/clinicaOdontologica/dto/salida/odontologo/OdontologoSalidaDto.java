package com.clinicaOdontologica.dto.salida.odontologo;

public class OdontologoSalidaDto {

    private Long id;
    private String matricula;
    private String nombre;
    private String apellido;


    public OdontologoSalidaDto() {
    }

    public OdontologoSalidaDto(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
