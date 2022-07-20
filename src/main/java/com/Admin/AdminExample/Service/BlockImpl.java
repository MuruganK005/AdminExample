package com.Admin.AdminExample.Service;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.dto.AdminDto;

public interface BlockImpl {
    AdminEntity setBlockBySuperAdmin(AdminDto dto, Long id);

    String setBlockBySuperAdmin1(String Roll,Long id)throws AdminException;

    String setBlockBySuperAdmin2(String roll, Long id) throws AdminException;
}
