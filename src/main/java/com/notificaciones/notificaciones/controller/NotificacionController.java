package com.notificaciones.notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificaciones.notificaciones.model.Notificacion;
import com.notificaciones.notificaciones.service.NotificacionService;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> getAllResenas() {
        List<Notificacion> notificaciones = notificacionService.findAll();

        if (!notificaciones.isEmpty()) {
            return new ResponseEntity<>(notificaciones, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> findNotificacion(@PathVariable Long id) {

        if (notificacionService.existsById(id)) {
            return new ResponseEntity<>(notificacionService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Notificacion> saveNotificacion(@RequestBody Notificacion notificacion) {

        if (!notificacionService.existsById(notificacion.getId())) {
            return new ResponseEntity<>(notificacionService.save(notificacion), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> updateResena(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        if (notificacionService.existsById(notificacion.getId())) {
            return new ResponseEntity<>(notificacionService.update(id, notificacion), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable Long id) {
        notificacionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
