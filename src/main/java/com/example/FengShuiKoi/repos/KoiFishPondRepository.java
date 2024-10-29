package com.example.FengShuiKoi.repos;


import com.example.FengShuiKoi.entity.Element;
import com.example.FengShuiKoi.entity.KoiFishPond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KoiFishPondRepository extends JpaRepository<KoiFishPond, Long> {
    List<KoiFishPond> findByElement(Element element);
}
