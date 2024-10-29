package com.example.FengShuiKoi.repos;


import com.example.FengShuiKoi.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {

    Element findByName(String name);
}

