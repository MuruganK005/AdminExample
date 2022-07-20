package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.SuperAdmin;
import com.Admin.AdminExample.dto.SuperAdminDto;

import java.util.List;
import java.util.Optional;

public interface ServiceImpl {
    SuperAdmin createSuperAdmin(SuperAdminDto admin);
    List<SuperAdmin> getAllSuperAdmin();
    Optional<SuperAdmin> getSuperAdminById(Long id);
    String deleteSuperAdminById(Long id);
}
