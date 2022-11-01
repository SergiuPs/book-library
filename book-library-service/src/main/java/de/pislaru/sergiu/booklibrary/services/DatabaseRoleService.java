package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.RoleInfo;
import de.pislaru.sergiu.booklibrary.repositories.RoleRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DatabaseRoleService implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public DatabaseRoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<RoleInfo> getRoles() {
        Set<RoleInfo> roleInfos = new HashSet<>();
        roleRepository.findAll().iterator().forEachRemaining(role -> roleInfos.add(modelMapper.map(role, RoleInfo.class)));
        return roleInfos;
    }
}
