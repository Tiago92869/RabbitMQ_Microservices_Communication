package com.rabbit.teste.appointmentservice.controller;

import com.rabbit.teste.appointmentservice.dto.AppointmentDto;
import com.rabbit.teste.appointmentservice.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Appointment", description = "Appointments with users")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/")
    @Operation(summary = "List all appointments")
    @ResponseStatus(HttpStatus.OK)
    public Page<AppointmentDto> getAllAppointments(Pageable pageable){

        return this.appointmentService.findAllAppointments(pageable);
    }

    @PostMapping(value = "/")
    @Operation(summary = "List all appointments")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto){

        return this.appointmentService.createAppointment(appointmentDto);
    }
}
