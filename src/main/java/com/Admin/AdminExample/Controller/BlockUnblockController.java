package com.Admin.AdminExample.Controller;

import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Exception.AdminException;
import com.Admin.AdminExample.Service.BlockUnblockService;
import com.Admin.AdminExample.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("block")
public class BlockUnblockController {
    @Autowired
    private BlockUnblockService unblockService;
    @PostMapping("/setBlock/{id}")
    public AdminEntity setBlockBySuperAdmin(@RequestBody AdminDto dto, @PathVariable Long id){
        return unblockService.setBlockBySuperAdmin(dto,id);
    }
    @PutMapping("/setBlocked/{id}")
    public String setBlockBySuperAdmin1(@RequestParam String Roll,@PathVariable Long id)throws AdminException {
        return unblockService.setBlockBySuperAdmin1(Roll,id);
    }
    @PutMapping("/setUnBlocked/{id}")
    public String setBlockBySuperAdmin2(@RequestParam String Roll,@PathVariable Long id)throws AdminException {
        return unblockService.setBlockBySuperAdmin2(Roll,id);
    }


}
