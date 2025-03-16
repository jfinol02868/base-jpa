package com.jpa.ccondigo.repo.entity.uno.uno;

import com.jpa.ccondigo.repo.entity.uno.uno.entity.Socio;
import com.jpa.ccondigo.repo.entity.uno.uno.entity.Tarjeta;
import com.jpa.ccondigo.repo.entity.uno.uno.repository.SocioRepository;
import com.jpa.ccondigo.repo.entity.uno.uno.repository.TarjetaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OneToOneServiceData {

    private final SocioRepository socioRepository;
    private final TarjetaRepository tarjetaRepository;

    @Transactional
    public void runCreate() {

        // 1.-  Rellenamos los objetos a la inversa
        // 2.- Asociamos los objestos entre sí
        // 3.- Madamos a persistir el objeto padre
        // 4.- En el tipo de relacion OneToOne, se pueden crear ambos objetos sin dependencias
        // NOTA: Objeto padre el socio, objeto hijo la tarjeta

        Tarjeta tarjeta = Tarjeta.builder()
                .numero(1234)
                .caducidad(new Date())
                .build();

        // recuerda agregar la tarjeta al socio
        Socio socio = Socio.builder()
                .dni("12345678A")
                .nombre("Juan")
                .apellidos("Perez")
                .tarjeta(tarjeta)
                .build();

        // Agrgar el socio a la tarjeta
        tarjeta.setSocio(socio);
        socioRepository.save(socio);
    }

    public void runUpdate() {

        // 1.- Buscamos el objeto padre
        // 2.- Actualizamos los datos del objeto padre
        // 3.- Actualizamos los datos del objeto hijo
        // 4.- Si el objeto hijo no existe, lo creamos y lo asociamos al objeto padre
        // 5.- Mandamos a persistir el objeto padre
        // 6.- Si el objeto hijo existe solo lo actualizamos sin asociarlo al objeto padre ya esta en la sesion de hibernate

        Optional<Socio> socioOptional = socioRepository.findById("12345678A");
        if (socioOptional.isPresent()) {
            Socio socio = socioOptional.get();
            socio.setNombre("Juan Andres");

            Tarjeta tarjeta = socio.getTarjeta();
            if (tarjeta != null) {
                // Actualiza los datos de la tarjeta existente
                tarjeta.setNumero(654321);
                tarjeta.setCaducidad(new Date());
            } else {
                // Crea una nueva tarjeta y la asocia al socio
                tarjeta = new Tarjeta();
                tarjeta.setNumero(654321);
                tarjeta.setCaducidad(new Date());
                tarjeta.setSocio(socio);
                socio.setTarjeta(tarjeta);
            }

            socioRepository.save(socio);
        } else {
            // Manejar el caso en que el socio no se encuentra
            System.out.println("Socio no encontrado");
        }
    }

    public void deleteRun() {
        Optional<Socio> socioOptional = socioRepository.findById("12345678A");
        if (socioOptional.isPresent()) {
            Socio socio = socioOptional.get();
            socioRepository.delete(socio);
        } else {
            // Manejar el caso en que el socio no se encuentra
            System.out.println("Socio no encontrado");
        }
    }
}
