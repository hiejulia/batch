package com.project.migration.batch.listener;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class VideoAssetWrapperItemReadListener implements ItemReadListener<VideoAssetWrapper> {
    private static final Logger log = LoggerFactory.getLogger(VideoAssetWrapperItemReadListener.class);

    @Override
    public void beforeRead() {
        log.info("Start reading video asset wrappers");
    }

    @Override
    public void afterRead(VideoAssetWrapper videoAssetWrapper) {
        log.info("Read video asset with ID={}", videoAssetWrapper.getId());
    }

    @Override
    public void onReadError(Exception ex) {
        log.error("Error reading video asset wrapper", ex);
    }
}