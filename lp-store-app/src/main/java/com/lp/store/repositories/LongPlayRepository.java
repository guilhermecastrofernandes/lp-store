package com.lp.store.repositories;

import java.util.List;

import com.lp.store.entities.LongPlay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongPlayRepository extends CrudRepository<LongPlay, Long> {
    
    List<LongPlay> findByName(String name);
    
}
