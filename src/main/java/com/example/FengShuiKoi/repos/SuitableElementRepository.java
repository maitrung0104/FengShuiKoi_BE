package com.example.FengShuiKoi.repos;


import com.example.FengShuiKoi.entity.Element;
import com.example.FengShuiKoi.entity.Suitable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuitableElementRepository extends JpaRepository<Suitable, Long> {
    List<Suitable> findByElement(Element element);
}