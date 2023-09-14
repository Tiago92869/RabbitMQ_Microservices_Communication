package com.rabbit.teste.appointmentservice.service;

import com.rabbit.teste.appointmentservice.dto.AppointmentDto;
import com.rabbit.teste.appointmentservice.entity.Appointment;
import com.rabbit.teste.appointmentservice.mapper.AppointmentMapper;
import com.rabbit.teste.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public Page<AppointmentDto> findAllAppointments(Pageable pageable) {

        return this.appointmentRepository.findAll(pageable).map(AppointmentMapper.INSTANCE::appointmentToDto);
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {

        appointmentDto.setId(UUID.randomUUID());

        Appointment appointment = AppointmentMapper.INSTANCE.dtoToAppointment(appointmentDto);

        return AppointmentMapper.INSTANCE.appointmentToDto(this.appointmentRepository.save(appointment));
    }
}
