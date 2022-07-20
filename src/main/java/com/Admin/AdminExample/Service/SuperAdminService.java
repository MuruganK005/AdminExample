package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.SuperAdmin;
import com.Admin.AdminExample.Repository.SuperAdminRepository;
import com.Admin.AdminExample.dto.SuperAdminDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminService implements ServiceImpl{
    @Autowired
    private SuperAdminRepository repository;
    @Override
    public SuperAdmin createSuperAdmin(SuperAdminDto admin) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        SuperAdmin entity=modelMapper.map(admin,SuperAdmin.class);
        return repository.save(entity);
    }
    @Override
    public List<SuperAdmin> getAllSuperAdmin() {
        return repository.findAll();
    }
    public Optional<SuperAdmin> getSuperAdminById(Long id) {
        return repository.findById(id);
    }
    @Override
    public String deleteSuperAdminById(Long id) {
        return "SuperAdmin "+id+" Deleted SuccessFully";
    }
}
