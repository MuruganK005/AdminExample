package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;

import java.util.List;
import java.util.Optional;

public interface AdminImpl {
    AdminEntity createAdmin(AdminEntity entity) throws AdminException;

    Optional<AdminEntity> getById(Long id);

    List<AdminEntity> getAllAdmin();

    String deleteAdminById(Long id);

    Optional<AdminEntity> updateAdminById(Long id);
}
