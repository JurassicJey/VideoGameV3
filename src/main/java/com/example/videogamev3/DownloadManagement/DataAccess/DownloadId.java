package com.example.videogamev3.DownloadManagement.DataAccess;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Embeddable
public class DownloadId {
    private String uuid;

}
