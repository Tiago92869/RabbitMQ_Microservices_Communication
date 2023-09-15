package com.rabbit.teste.appointmentservice.repository;

import com.rabbit.teste.appointmentservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    List<Appointment> findByUserId(UUID id);
}
