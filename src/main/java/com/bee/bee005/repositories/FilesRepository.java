package com.bee.bee005.repositories;

import com.bee.bee005.models.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilesRepository extends CrudRepository<Files, Long> {

/*    Iterable <Files> findAll();

    Optional<Files> findById(Long aLong);

    Files findByPath(String path);

    Files findByVersion(String version);

    Files findByType(String type);*/

}
