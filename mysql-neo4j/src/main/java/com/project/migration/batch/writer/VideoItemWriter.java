package com.project.migration.batch.writer;




import com.project.migration.model.Video;
import com.project.migration.repository.VideoGraphRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

// Write to Neo4J

@Component
@Lazy(value = true)
public class VideoItemWriter implements ItemWriter<Video> {


    @Autowired
    private VideoGraphRepo videoGraphRepository;

    @Override
    public void write(List<? extends Video> items) throws Exception {

    }
}
