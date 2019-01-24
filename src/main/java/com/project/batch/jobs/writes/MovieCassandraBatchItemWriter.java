package com.project.batch.jobs.writes;

import java.util.List;

import com.project.batch.model.MovieDetails;
import com.project.batch.service.MovieService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Movie cassandra
 */
public class MovieCassandraBatchItemWriter  implements ItemWriter<MovieDetails>{

    protected static final Log logger = LogFactory.getLog(MovieCassandraBatchItemWriter.class);


    @Autowired
    private MovieService movieService;

    // Write
    @Override
    public void write(List<? extends MovieDetails> items) throws Exception {

        logger.info("Writing op is performing");


        if (!items.isEmpty()) {

            logger.info("Inserting");

            for (MovieDetails movie : items) {
                // Save movie
                movieService.saveEntity(movie);

                logger.info("Done write to cassandra");
            }
        }
    }



}


