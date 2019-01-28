package com.project.batch.writer.transaction;


import org.springframework.batch.item.file.ResourceSuffixCreator;


public class StatementSuffixGenerator implements ResourceSuffixCreator {

    public String getSuffix(int arg0) {
        return arg0 + ".txt";
    }

}



