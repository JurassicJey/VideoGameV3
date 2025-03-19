package com.example.videogamev3.UserManagement.Presentation;

import com.example.videogamev3.UserManagement.BusinessLogic.AdminService;
import com.example.videogamev3.UserManagement.BusinessLogic.AdminService;
import com.example.videogamev3.UserManagement.Presentation.AdminRequestModel;
import com.example.videogamev3.UserManagement.Presentation.AdminResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping()
    public List<AdminResponseModel> getAdmins() {
        return adminService.getAllAdmins();
    }
    @GetMapping("{uuid}")
    public AdminResponseModel getAdminById(@PathVariable String uuid) {
        return adminService.getAdminById(uuid);
    }

    @PostMapping()
    public AdminResponseModel addAdmin(@RequestBody AdminRequestModel adminRequestModel) {
        return adminService.addAdmin(adminRequestModel);
    }

    @PutMapping("{uuid}")
    public AdminResponseModel updateAdmin(@RequestBody AdminRequestModel adminRequestModel, @PathVariable String uuid) {
        return adminService.updateAdmin(adminRequestModel, uuid);
    }

    @DeleteMapping("{uuid}")
    public void deleteAdmin(@PathVariable String uuid) {
        adminService.deleteAdmin(uuid);
    }
}
