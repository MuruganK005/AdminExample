package com.Admin.AdminExample.Controller;
import com.Admin.AdminExample.Entity.Address;
import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Enum.TypesOfRole;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Service.AdminService;
import com.Admin.AdminExample.dto.AdminDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Admin.AdminExample.Enum.TypesOfRole.SUPER_ADMIN;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/createAdmin")
    public AdminDto createAdmin(@RequestBody AdminDto entity)throws AdminException {
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
    public AdminDto updateAdminById(@PathVariable Long id,@RequestBody AdminDto entity) throws AdminException {
        return adminService.updateAdminById(id,entity);
    }
    @PostMapping("getObjectAsString")
    public String getObjectAsString(@RequestBody AdminDto dto) throws JsonProcessingException {
//        List<AdminDto> model=new ArrayList<>();
        ObjectMapper objectMapper=new ObjectMapper();
//        model.add(new AdminDto(1L,"Murugan",9080850513L,"muruganeee005@gmail.com",new Address(1L,27L,"","","","",15L), SUPER_ADMIN));
        return objectMapper.writeValueAsString(dto);

    }

}
