package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.dto.AdminDto;

import java.util.List;
import java.util.Optional;

public interface AdminImpl {
    AdminDto createAdmin(AdminDto entity) throws AdminException;
    Optional<AdminEntity> getById(Long id);
    List<AdminEntity> getAllAdmin();
    String deleteAdminById(Long id);
    AdminDto updateAdminById(Long id, AdminDto entity)throws AdminException;
}
