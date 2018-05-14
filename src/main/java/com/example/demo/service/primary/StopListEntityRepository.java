package com.example.demo.service.primary;

import com.example.demo.domain.primary.StopListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface StopListEntityRepository extends JpaRepository<StopListEntity,Long>{
    List<StopListEntity> getByUid(String uid);
    void removeByUid(String uid);
}
