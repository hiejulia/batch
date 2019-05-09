package com.project.migration.batch.processor;


import com.project.migration.model.Video;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VideoWrapperItemProcessor implements ItemProcessor<VideoAssetWrapper, Video> {


    @Override
    public Video process(VideoAssetWrapper videoAssetWrapper) throws Exception {

        if (videoAssetWrapper.getVideoAsset() == null) {
            return null;
        }


        List<Bitrate> bitrates = videoAssetWrapper.getVideoAsset().getPlayBackInfo().getBitrates().stream().map(x -> {

            Bitrate bitrate = new Bitrate();


            bitrate.setId(x.getId());
            bitrate.setBitrateKbps(x.getBitrateKbps());
            bitrate.setFilename(x.getFilename());
            bitrate.setRemotePath(x.getRemotePath());


            return bitrate;


        }).collect(Collectors.toList());

        VideoAsset videoAsset = new VideoAsset();

        videoAsset.setTitle(videoAssetWrapper.getVideoAsset().getTitle());

        if (videoAssetWrapper.getVideoAsset().getEntitlement() != null) {
            videoAsset.setEntitlement(Entitlement.valueOf(videoAssetWrapper.getVideoAsset().getEntitlement().name()));
        }


        videoAsset.setBitrates(bitrates);

        if (videoAssetWrapper.getVideoAsset().getEncodingDate() != null) {
            videoAsset.setEncodingDate(videoAssetWrapper.getVideoAsset().getEncodingDate().toInstant());
        }


        videoAsset.setPlaybackUrl(videoAssetWrapper.getVideoAsset().getPlayBackInfo().getVideoUrl());
        videoAsset.setRuntimeSecs(videoAssetWrapper.getVideoAsset().getRunTimeSecs());
        videoAsset.setCaption(videoAssetWrapper.getVideoAsset().getCaption());



        if (videoAssetWrapper.getVideoAsset().getId() != null) {
            videoAsset.setId(videoAssetWrapper.getVideoAsset().getId());
        }


        Video video = new Video();
        video.setId(videoAssetWrapper.getVideoAssetId());
        video.setVideoAsset(videoAsset);
        video.setTitle(videoAssetWrapper.getVideoAsset().getTitle());


        if (videoAssetWrapper.getVideoAsset().getEntitlement() != null) {
            video.setEntitlement(Entitlement.valueOf(videoAssetWrapper.getVideoAsset().getEntitlement().name()));
        }


        if (videoAssetWrapper.getVideoAsset().getEventOccurredDate() != null) {
            video.setEventOccurredDate(videoAssetWrapper.getVideoAsset().getEventOccurredDate().toInstant());
        }


        video.setUrl(videoAssetWrapper.getVideoAsset().getUrl());
        video.setCaption(videoAssetWrapper.getVideoAsset().getCaption());


        if (videoAssetWrapper.getVideoAsset().getRelated() != null && videoAssetWrapper.getVideoAsset().getRelated().getGames() != null) {


            List<Game> games = videoAssetWrapper.getVideoAsset().getRelated().getGames().stream().map(x -> {
                Game game = new Game();
                game.setId(x.getId());
                return game;
            }).collect(Collectors.toList());
            video.setGames(games);


        }



        if (videoAssetWrapper.getVideoAsset().getRelated() != null && videoAssetWrapper.getVideoAsset().getRelated().getTeams() != null) {


            List<Team> teams = videoAssetWrapper.getVideoAsset().getRelated().getTeams().stream().map(x -> {
                Team team = new Team();
                team.setId(x.getId());
                team.setSeasonValue(x.getSeason());
                team.setName(x.getFullName());
                team.setAbbreviation(x.getAbbr());
                return team;
            }).collect(Collectors.toList());
            video.setTeams(teams);



        }

        return video;
    }
}
