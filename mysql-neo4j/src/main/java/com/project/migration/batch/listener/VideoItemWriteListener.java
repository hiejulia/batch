package com.project.migration.batch.listener;



import com.project.migration.model.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;



@Component
public class VideoItemWriteListener implements ItemWriteListener<Video> {



    private static final Logger log = LoggerFactory.getLogger(VideoItemWriteListener.class);

    private Instant startTime;


    @Override
    public void beforeWrite(List<? extends Video> items) {
        startTime = Instant.now();
    }


    @Override
    public void afterWrite(List<? extends Video> items) {
        log.info("Complete write items with duration {}", Duration.between(startTime, Instant.now()));
    }


    @Override
    public void onWriteError(Exception exception, List<? extends Video> items) {
        log.error("Error to write items", exception);
    }
}
