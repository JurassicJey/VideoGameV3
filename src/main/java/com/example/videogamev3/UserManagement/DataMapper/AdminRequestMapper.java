package com.example.videogamev3.UserManagement.DataMapper;


import com.example.videogamev3.UserManagement.DataAccess.Admin;
import com.example.videogamev3.UserManagement.DataAccess.AdminId;
import com.example.videogamev3.UserManagement.Presentation.AdminRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {AdminId.class, UUID.class})
public interface AdminRequestMapper {
    @Mapping(target = "adminId", expression = "java(new AdminId(UUID.randomUUID().toString()))")
    Admin adminRequestModelToAdmin(AdminRequestModel adminRequestModel);
    List<AdminRequestModel> adminRequestModelToAdmin(List<AdminRequestModel> adminRequestModels);
}