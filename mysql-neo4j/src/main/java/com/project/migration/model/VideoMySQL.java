package com.project.migration.model;


import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

@Data
public class VideoMySQL {



    @Id
    @GeneratedValue
    private String uuid;

    private String fileName;

    private String bitrateKbps;

    private String remotePath;

    private String title;

    // id, fileName, bitrateKbps, remotePath, title


}
