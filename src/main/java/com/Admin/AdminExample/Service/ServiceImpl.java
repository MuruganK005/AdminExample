package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.SuperAdmin;

import java.util.List;
import java.util.Optional;

public interface ServiceImpl {
    SuperAdmin createSuperAdmin(SuperAdmin admin);

    List<SuperAdmin> getAllSuperAdmin();

    Optional<SuperAdmin> getSuperAdminById(Long id);

    String deleteSuperAdminById(Long id);
}
