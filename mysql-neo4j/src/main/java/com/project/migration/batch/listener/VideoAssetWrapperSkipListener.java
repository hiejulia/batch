package com.project.migration.batch.listener;


import com.nfl.dm.shield.ingestion.domain.job.VideoAssetWrapper;
import com.nfl.dm.shield.ingestion.domain.kafka.SaveVideoAssetMetaDataPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Component
public class VideoAssetWrapperSkipListener implements SkipListener<VideoAssetWrapper, SaveVideoAssetMetaDataPayload> {
    private static final Logger log = LoggerFactory.getLogger(VideoAssetWrapperSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        log.error("Error on read", t);
    }

    @Override
    public void onSkipInWrite(SaveVideoAssetMetaDataPayload saveVideoAssetMetaDataPayload, Throwable t) {
        log.error("Error on skip write video asset wrapper", t);
    }

    @Override
    public void onSkipInProcess(VideoAssetWrapper videoAssetWrapper, Throwable t) {
        log.error("Error on skip process video asset wrapper", t);
    }
}
