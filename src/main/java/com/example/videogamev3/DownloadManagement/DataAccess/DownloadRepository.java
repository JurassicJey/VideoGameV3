package com.example.videogamev3.DownloadManagement.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository extends JpaRepository<DownloadId, String> {
}
