package com.yadev.citas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> findAll() { return this.appointmentService.findAll(); }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable Long id) { return this.appointmentService.findById(id); }

    @PostMapping
    public Appointment save(@RequestBody Appointment doctor) { return this.appointmentService.save(doctor); }

    @PathVariable("/{id}/register-attention")
    public Appointment updateCita(@PathVariable Long id, @RequestBody String diagnostico) {
        return this.appointmentService.updateToAttendant(id, diagnostico);
    }
}
