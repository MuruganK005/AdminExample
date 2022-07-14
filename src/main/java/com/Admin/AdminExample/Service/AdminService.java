package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Enum.TypesOfRole;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Repository.AdminRepository;
import com.Admin.AdminExample.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminImpl{

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminDto createAdmin(AdminDto entity) throws AdminException {
        Optional<AdminEntity> entity1=adminRepository.findByEmail(entity.getEmail());
        if (entity1.isPresent() && entity1.get().getId() != entity.getId()){
            throw new AdminException(HttpStatus.FORBIDDEN," Email Already Exist");
        }
        Optional<AdminEntity> entity2=adminRepository.findByPhoneNumber(entity.getPhoneNumber());
        if (entity2.isPresent() && entity2.get().getId() != entity.getId()){
            throw new AdminException(HttpStatus.FORBIDDEN,"PhoneNumber Already Exist");
        }
        if (TypesOfRole.SUPER_ADMIN.equals(entity.getRolesCreator())) {
                return adminRepository.save(entity);
        } else {
            throw new AdminException(HttpStatus.BAD_REQUEST,"You are Not Super_Admin");
        }
    }

    @Override
    public Optional<AdminEntity> getById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<AdminEntity> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public String deleteAdminById(Long id) {
           adminRepository.deleteById(id);
        return "Admin "+id+" Successfully Deleted";

    }
    @Override
    public AdminDto updateAdminById(Long id, AdminDto entity)throws AdminException {
        Optional<AdminEntity> entity1=adminRepository.findByEmail(entity.getEmail());
        if (entity1.isPresent() && entity1.get().getId()!= entity.getId())
        {
            throw new AdminException(HttpStatus.FORBIDDEN," Email Already Exist with Another Id");
        }
        Optional<AdminEntity> entity2=adminRepository.findByPhoneNumber(entity.getPhoneNumber());
        if ((entity2.isPresent() && entity2.get().getId()!= entity.getId())){
                throw new AdminException(HttpStatus.FORBIDDEN,"PhoneNumber Already Exist with Another Id");
            }
        return (AdminDto) adminRepository.save(entity);
    }
}
