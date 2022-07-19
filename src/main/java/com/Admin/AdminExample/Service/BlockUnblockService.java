package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Repository.AdminRepository;
import com.Admin.AdminExample.dto.AdminDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlockUnblockService implements BlockImpl{
    @Autowired
    private AdminRepository repo;

    @Override
    public AdminEntity setBlockBySuperAdmin(AdminDto dto, Long id) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Optional<AdminEntity> entityOptional=repo.findByStatus(dto.getStatus());
        entityOptional.get().setStatus(true);
        AdminEntity entity=modelMapper.map(dto,AdminEntity.class);
        return repo.save(entity);
    }

    @Override
    public String setBlockBySuperAdmin1(String Roll,Long id)throws AdminException {
        if(Roll.equals("SUPER_ADMIN")){
            Optional<AdminEntity> entity=repo.findById(id);
            if (entity.isPresent()){
                entity.get().setStatus(true);
                repo.save(entity.get());
            }
        } else if (!Roll.equals("SUPER_ADMIN")){
            throw new AdminException(HttpStatus.FORBIDDEN,"Your Not Super Admin");
        }
//        Optional<AdminEntity> entity=repo.findById(id);
//        if (entity.isPresent()){
//            entity.get().setStatus(true);
//            repo.save(entity.get());
//        }
        return "Admin has Blocked ";
    }
}
