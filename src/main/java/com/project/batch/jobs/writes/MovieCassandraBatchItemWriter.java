package com.project.batch.jobs.writes;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springBatch.model.MovieDetails;
import com.example.springBatch.service.MovieService;

public class MovieCassandraBatchItemWriter  implements ItemWriter<MovieDetails>{

    protected static final Log logger = LogFactory.getLog(MovieCassandraBatchItemWriter.class);

    @Autowired
    private MovieService movieService;

    @Override
    public void write(List<? extends MovieDetails> items) throws Exception {

        logger.info("Writing op is performing");
        if (!items.isEmpty()) {
            logger.info("Inserting");
            for (MovieDetails movie : items) {
                movieService.saveEntity(movie);
            }
        }
    }



}


