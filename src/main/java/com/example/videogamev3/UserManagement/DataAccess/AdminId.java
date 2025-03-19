package com.example.videogamev3.UserManagement.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminId {
    @Column(name = "admin_id")
    private String uuid;
}
