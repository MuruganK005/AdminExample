package com.Admin.AdminExample.Repository;

import com.Admin.AdminExample.Entity.AdminEntity;
//import com.Admin.AdminExample.Entity.SuperAdmin;
//import com.Admin.AdminExample.Enum.TypesOfRole;
import com.Admin.AdminExample.dto.AdminDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
    Optional<AdminEntity> findByEmail(String email);
    Optional<AdminEntity> findById(Long id);

    Optional<AdminEntity> findByPhoneNumber(Long phoneNumber);

    List<AdminEntity> findByDeleted(Boolean b);

    Optional<AdminEntity> findByStatus(Boolean status);
}
