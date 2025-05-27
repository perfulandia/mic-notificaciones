package com.notificaciones.notificaciones.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificaciones.notificaciones.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findAll();

    Optional<Notificacion> findById(Long id);

    boolean existsById(Long id);
}
