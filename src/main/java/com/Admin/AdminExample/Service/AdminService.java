package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Enum.TypesOfRole;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Repository.AdminRepository;
import com.Admin.AdminExample.dto.AdminDto;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminImpl{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EntityManager entityManager;
//    private java.lang.Object Object;

    @Override
    public AdminEntity createAdmin(AdminDto entity) throws AdminException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        if (entity.getId() == null) {
            Optional<AdminEntity> adminEntity = adminRepository.findById(entity.getId());
            if (adminEntity.isPresent()) {
                throw new AdminException(HttpStatus.FORBIDDEN," Record Not Found");
            }
        }
        Optional<AdminEntity> entity1=adminRepository.findByEmail(entity.getEmail());
        if (entity1.isPresent() && entity1.get().getId() != entity.getId()){
            throw new AdminException(HttpStatus.FORBIDDEN," Email Already Exist");
        }
        Optional<AdminEntity> entity2=adminRepository.findByPhoneNumber(entity.getPhoneNumber());
        if (entity2.isPresent() && entity2.get().getId() != entity.getId()){
            throw new AdminException(HttpStatus.FORBIDDEN,"PhoneNumber Already Exist");
        }
        if (TypesOfRole.SUPER_ADMIN.equals(entity.getRolesCreator())) {
            AdminEntity adminEntity = modelMapper.map(entity, AdminEntity.class);
                return adminRepository.save(adminEntity);
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

        return adminRepository.findByDeleted(false);
    }

    @Override
    public String deleteAdminById(Long id) {
           adminRepository.deleteById(id);
        return "Admin "+id+" Successfully Deleted";
    }
    @Override
    public AdminEntity updateAdminById(Long id, AdminDto entity)throws AdminException {
        ModelMapper model=new ModelMapper();
        model.getConfiguration().setAmbiguityIgnored(true);
        Optional<AdminEntity> entity1=adminRepository.findByEmail(entity.getEmail());
        if (entity1.isPresent() && entity1.get().getId()!= entity.getId())
        {
            throw new AdminException(HttpStatus.FORBIDDEN," Email Already Exist with Another Id");
        }
        Optional<AdminEntity> entity2=adminRepository.findByPhoneNumber(entity.getPhoneNumber());
        if ((entity2.isPresent() && entity2.get().getId()!= entity.getId())){
                throw new AdminException(HttpStatus.FORBIDDEN,"PhoneNumber Already Exist with Another Id");
            }
        AdminEntity entity3=model.map(entity,AdminEntity.class);
        return adminRepository.save(entity3);
    }

    @Override
    public List<AdminEntity> getAllDeletedRecords() {
        return adminRepository.findByDeleted(true);
    }

    @Override
    public String softdDeleteAdminById(Long id) {
         Optional<AdminEntity> entity=adminRepository.findById(id);
         if (entity.isPresent()){
             entity.get().setDeleted(true);
             adminRepository.save(entity.get());
         }
         return "Admin SoftDelete Successful";
    }

    @Override
    public Iterable<AdminEntity> getAllSoftDeletedAdmin(Boolean isDeleted) {
        Session session= entityManager.unwrap(Session.class);
        Filter filter= session.enableFilter("deletedAdminFilter");
        filter.setParameter("isDeleted",isDeleted);
        Iterable<AdminEntity> entityIterable=adminRepository.findAll();
        session.disableFilter("deletedAdminFilter");
        return entityIterable;
    }

//    @Override
//    public Optional<Object> findById(Long id) {
//        return adminRepository.findById(id);
//    }
//
//    @Override
//    public AdminDto replaceAdmin(Long id, AdminDto adminDto) {
//        return adminRepository.save(id);
//    }
}
