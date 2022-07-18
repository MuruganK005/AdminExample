package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.dto.AdminDto;

import java.util.List;
import java.util.Optional;

public interface AdminImpl {
    AdminEntity createAdmin(AdminDto entity) throws AdminException;
    Optional<AdminEntity> getById(Long id);
    List<AdminEntity> getAllAdmin();
    String deleteAdminById(Long id);
    AdminEntity updateAdminById(Long id, AdminDto entity)throws AdminException;

    List<AdminEntity> getAllDeletedRecords();

    String softdDeleteAdminById(Long id);

//    Iterable<AdminEntity> getAllSoftDeletedAdmin(Boolean);

    Iterable<AdminEntity> getAllSoftDeletedAdmin(Boolean isDeleted);

//    Optional<Object> findById(Long id);

//    AdminDto replaceAdmin(Long id);

//    Optional<Object> replaceAdmin(Long id);
}
