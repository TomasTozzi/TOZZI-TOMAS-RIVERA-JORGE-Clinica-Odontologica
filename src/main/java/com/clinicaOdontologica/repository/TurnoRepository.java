package com.clinicaOdontologica.repository;

import com.clinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    Turno findByDni(int dni);
}
