package com.rabbit.teste.userservice.service;

import com.rabbit.teste.userservice.dto.UserDto;
import com.rabbit.teste.userservice.entity.User;
import com.rabbit.teste.userservice.mapper.UserMapper;
import com.rabbit.teste.userservice.rabbit.ProducerService;
import com.rabbit.teste.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ProducerService producerService;

    @Autowired
    public UserService(UserRepository userRepository, ProducerService producerService) {
        this.userRepository = userRepository;
        this.producerService = producerService;
    }


    public Page<UserDto> findAllUsers(Pageable pageable) {
        this.producerService.hello(String.valueOf(UUID.randomUUID()));
        return this.userRepository.findAll(pageable).map(UserMapper.INSTANCE::userToDto);
    }

    public UserDto createUser(UserDto userDto) {

        this.producerService.topicExchange();
        userDto.setId(UUID.randomUUID());

        User user = UserMapper.INSTANCE.dtoToUser(userDto);

        return UserMapper.INSTANCE.userToDto(this.userRepository.save(user));
    }

    public void deleteUser(UUID id) {

        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isEmpty()){

            throw new RuntimeException("User doesn't exist");
        }

        this.userRepository.deleteById(id);

        System.out.println("Delete with success - now deleting appointments");
        this.producerService.deleteUser(String.valueOf(id));
    }
}
