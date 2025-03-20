package com.example.videogamev3.DownloadManagement.DataAccess;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadManager {
    @EmbeddedId
    private DownloadId downloadId;
    private String downloadStatus;
}
