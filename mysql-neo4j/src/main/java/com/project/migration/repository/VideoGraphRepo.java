package com.project.migration.repository;




import com.project.migration.model.Video;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Lazy(value = true)
public interface VideoGraphRepo extends GraphRepository<Video> {

    // Find by id
    Video findOneByUuid(String uuid);
}
