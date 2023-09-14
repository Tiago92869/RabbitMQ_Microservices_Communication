package com.rabbit.teste.appointmentservice.mapper;

import com.rabbit.teste.appointmentservice.dto.AppointmentDto;
import com.rabbit.teste.appointmentservice.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDto appointmentToDto(Appointment appointment);

    Appointment dtoToAppointment(AppointmentDto appointmentDto);
}
