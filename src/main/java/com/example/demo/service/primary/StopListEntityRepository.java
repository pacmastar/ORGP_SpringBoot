package com.example.demo.service.primary;

import com.example.demo.domain.primary.StopListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopListEntityRepository extends JpaRepository<StopListEntity,Long>{
    List<StopListEntity> getByUid(String uid);
}
