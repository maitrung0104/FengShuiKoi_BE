package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.Koi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KoiRepository extends JpaRepository<Koi, UUID> {
    Koi findKoiById(UUID KoiId);
    List<Koi> findByElement(String element);
}