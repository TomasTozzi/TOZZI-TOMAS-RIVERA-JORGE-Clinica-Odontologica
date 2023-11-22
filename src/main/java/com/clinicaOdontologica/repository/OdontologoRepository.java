package com.clinicaOdontologica.repository;

import com.clinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    Odontologo findByDni(int dni);
}
