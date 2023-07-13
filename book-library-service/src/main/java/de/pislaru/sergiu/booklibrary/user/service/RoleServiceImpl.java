package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.dto.RoleDTO;
import de.pislaru.sergiu.booklibrary.repositories.RoleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<RoleDTO> getRoles() {
        Set<RoleDTO> roleDTOS = new HashSet<>();
        roleRepository.findAll().iterator().forEachRemaining(role -> roleDTOS.add(modelMapper.map(role, RoleDTO.class)));
        return roleDTOS;
    }
}
