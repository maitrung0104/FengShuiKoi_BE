package com.example.FengShuiKoi.repos;

import com.example.FengShuiKoi.entity.KoiFishPond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PondRepository extends JpaRepository<KoiFishPond, Integer> {
}