package com.clinicaOdontologica;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ClinicaOdontologicaApplication {

    private static Logger logger = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClinicaOdontologicaApplication.class, args);
        //crearTabla();
        logger.info("ClinicaOdontologica is now running...");
        appOpen();
    }

    //JR. este metodo muestra el return y el logger al levantar la app con el endpoint vacio.
    @GetMapping()
    public static String appRunning() {
        logger.info("ejecutando el GetMapping ...");
        return "clinica Odontologica is Running";
    }

    @GetMapping("/open")
    public static String appOpen() {
        logger.info("ejecutando el GetMapping 2 ...");
        return "clinica Odontologica is open";
    }

    //Metodo de creacion de tabla que se ejecuta dentro del main.
 /*   private static void crearTabla() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clinicaC1;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
            logger.info("Se creo la tabla en la Base de Datos.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error al crear la Base de Datos.");
        } finally {
            try {
                connection.close();
                logger.info("Se cerro la conexion a la Base de Datos.");
            } catch (Exception ex) {
                logger.info("Error al cerrar la conexion a la Base de Datos.");
                ex.printStackTrace();
            }
        }
    }
*/
    @GetMapping("/close")
    public String appClosed() {
        logger.info("ejecutando el GetMapping 3 ...");
        return "clinica Odontologica is Closed";
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}