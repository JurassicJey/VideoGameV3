package com.example.videogamev3.UserManagement.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    Admin findAdminByAdminId_uuid(String uuid);
}
