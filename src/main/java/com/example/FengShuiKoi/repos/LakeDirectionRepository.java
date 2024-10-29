package com.example.FengShuiKoi.repos;



import com.example.FengShuiKoi.entity.Element;
import com.example.FengShuiKoi.entity.LakeDirection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LakeDirectionRepository extends JpaRepository<LakeDirection, Long> {
    List<LakeDirection> findByElement(Element element);

}
