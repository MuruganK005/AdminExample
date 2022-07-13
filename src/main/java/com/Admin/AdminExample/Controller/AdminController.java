package com.Admin.AdminExample.Controller;
import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Entity.SuperAdmin;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/createAdmin")
    public AdminEntity createAdmin(@RequestBody AdminEntity entity)throws AdminException {
        return adminService.createAdmin(entity);
    }
    @GetMapping("/{id}")
    public Optional<AdminEntity> getById(@PathVariable Long id){
        return adminService.getById(id);
    }
    @GetMapping("/getAllAdmin")
    public List<AdminEntity> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @DeleteMapping("/{id}")
    public String deleteAdminById(@PathVariable Long id){
        return adminService.deleteAdminById(id);
    }
    @PutMapping("/{id}")
    public Optional<AdminEntity> updateAdminById(@PathVariable Long id){
        return adminService.updateAdminById(id);
    }

}
