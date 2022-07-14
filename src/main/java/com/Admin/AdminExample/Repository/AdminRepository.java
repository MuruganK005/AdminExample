package com.Admin.AdminExample.Repository;

import com.Admin.AdminExample.Entity.AdminEntity;
//import com.Admin.AdminExample.Entity.SuperAdmin;
//import com.Admin.AdminExample.Enum.TypesOfRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByEmail(String email);

    Optional<AdminEntity> findByPhoneNumber(Long phoneNumber);
}
