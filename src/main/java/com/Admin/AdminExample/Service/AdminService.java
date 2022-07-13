package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Enum.TypesOfRole;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Repository.AdminRepository;
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
    public AdminEntity createAdmin(AdminEntity entity) throws AdminException {
        if (TypesOfRole.SUPER_ADMIN.equals(entity.getRoles())) {
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
    public AdminEntity updateAdminById(Long id,AdminEntity entity)throws AdminException {
        AdminEntity entity1=adminRepository.findByEmail(entity.getEmail());
        if (entity1!=null){
            throw new AdminException(HttpStatus.FORBIDDEN,"Invalid Email");
        }
        AdminEntity entity2=adminRepository.findByPhoneNumber(entity.getPhoneNumber());
        if (entity2!=null){
            throw new AdminException(HttpStatus.FORBIDDEN,"Invalid PhoneNumber");
        }
        return adminRepository.save(entity);
    }
}
