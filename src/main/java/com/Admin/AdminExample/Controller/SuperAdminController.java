package com.Admin.AdminExample.Controller;

import com.Admin.AdminExample.Entity.SuperAdmin;
import com.Admin.AdminExample.Service.SuperAdminService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SuperAdminController {
    @Autowired
    private SuperAdminService adminService;

    @PostMapping("createSuperAdmin")
    public SuperAdmin createSuperAdmin(@RequestBody SuperAdmin admin){
        return adminService.createSuperAdmin(admin);
    }
    @GetMapping("getAllSuperAdmin")
    public List<SuperAdmin> getAllSuperAdmin(){
        return adminService.getAllSuperAdmin();
    }
    @GetMapping("/get/{id}")
    public Optional<SuperAdmin> getSuperAdminById(@PathVariable Long id){
        return adminService.getSuperAdminById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSuperAdminById(@PathVariable Long id){
        return adminService.deleteSuperAdminById(id);
    }
}
