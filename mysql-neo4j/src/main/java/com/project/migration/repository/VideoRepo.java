package com.project.migration.repository;

import com.project.migration.model.Video;
import org.springframework.data.repository.CrudRepository;



public interface VideoRepo extends CrudRepository<Video, Long> {

    Video findByUuid(String uuid);

}