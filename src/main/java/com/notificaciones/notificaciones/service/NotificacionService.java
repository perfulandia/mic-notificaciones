package com.notificaciones.notificaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notificaciones.notificaciones.model.Notificacion;
import com.notificaciones.notificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> findById(Long id) {
        return notificacionRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return notificacionRepository.existsById(id);
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public void deleteById(Long id) {
        notificacionRepository.deleteById(id);
    }

    public Notificacion update(Long id, Notificacion notificacion) {
        Notificacion holder = notificacionRepository.findById(id).get();

        if (notificacion != null) {
            holder.setIdDestinatario(notificacion.getIdDestinatario());
            holder.setTexto(notificacion.getTexto());

            return holder;
        }
        return null;

    }
}
