package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl implements DeleteService{

    @Autowired
    private UserRepository userRepository;

    public void deleteUser(Long id) throws IllegalArgumentException{

        userRepository.delete(id);

    }

}
