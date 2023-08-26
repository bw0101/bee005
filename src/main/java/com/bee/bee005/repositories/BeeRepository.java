package com.bee.bee005.repositories;

import com.bee.bee005.models.Bee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeeRepository extends CrudRepository<Bee, Long> {
  //  Iterable <Bee> findAll();
}
