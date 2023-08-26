package com.bee.bee005.repositories;

import com.bee.bee005.models.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends CrudRepository<Files, Long> {

}
