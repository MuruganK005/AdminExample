package com.Admin.AdminExample.Controller;
import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Repository.AdminRepository;
import com.Admin.AdminExample.Service.AdminService;
import com.Admin.AdminExample.dto.AdminDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository repository;

    @PostMapping("/createAdmin")
    public AdminEntity createAdmin(@RequestBody AdminDto entity)throws AdminException {
        return adminService.createAdmin(entity);
    }
    @GetMapping("/getById/{id}")
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
    @PutMapping("/update/{id}")
    public AdminEntity updateAdminById(@PathVariable Long id,@RequestBody AdminDto entity) throws AdminException {
        return adminService.updateAdminById(id,entity);
    }
    @PostMapping("getObjectAsString")
    public String getObjectAsString(@RequestBody AdminDto dto) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(dto);
    }
    @GetMapping("getDeletedrecords")
    public List<AdminEntity> getAllDeletedRecords(){
        return adminService.getAllDeletedRecords();
    }
    @DeleteMapping("softDelete/{id}")
    public String softDeleteAdminById(@PathVariable Long id){
        return adminService.softdDeleteAdminById(id);
    }
//    @PutMapping("/admin/{id}")
//    public AdminDto replaceAdmin(@RequestBody AdminDto adminDto) {
//
//        return adminService.findById(id)
//                .map(admin -> {
//                   adminDto.setEmail("Muruganeeee005@gmail.com");
//                   adminDto.setPhoneNumber(9080850518L);
//                    return repository.save(id);
//                })
//                .orElseGet(() -> {
//                    adminDto.setId(id);
//                    return repository.save(id);
//                });
//    }
}
