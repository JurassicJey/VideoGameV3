package com.example.videogamev3.DownloadManagement.Presentation;

import com.example.videogamev3.DownloadManagement.DataAccess.DownloadManager;
import com.example.videogamev3.DownloadManagement.DataAccess.DownloadStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DownloadDto {
    UUID id;
    String sourceUrl;
    DownloadStatus status;

    public static DownloadDto fromEntity(DownloadManager entity) {
        return new DownloadDto(
                entity.getId(),
                entity.getSourceUrl(),
                entity.getDownloadStatus()
        );
    }
}