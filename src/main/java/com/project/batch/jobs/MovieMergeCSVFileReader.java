package com.project.batch.jobs;



import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.SingleItemPeekableItemReader;
import org.springframework.batch.item.support.builder.SingleItemPeekableItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.example.springBatch.model.DirectorDTO;
import com.example.springBatch.model.MovieDTO;
import com.example.springBatch.model.MovieDetails;
import com.example.springBatch.model.PersonDTO;


public class MovieMergeCSVFilesReader implements ItemReader<com.example.springBatch.model.MovieDetails>, ItemStream  {



    private SingleItemPeekableItemReader<MovieDTO> moviePeekReader;
    private SingleItemPeekableItemReader<DirectorDTO> directorPeekReader;

    @Autowired
    private ResourceLoader resourceLoader;

    public MovieMergeCSVFilesReader() {


    }

    public MovieMergeCSVFilesReader(ResourceLoader resourceLoader) {
        loadReaders(resourceLoader);
    }


    private void loadReaders(ResourceLoader resourceLoader) {

        ItemReader<MovieDTO> mReader;
        ItemReader<DirectorDTO> dirReader;

        mReader = new FlatFileItemReaderBuilder<MovieDTO>()
                .name("movieReader")
                .resource(resourceLoader.getResource("classpath:sample_movies.csv"))
                .delimited()
                .delimiter(",")
                .names(new String[]{"movieId", "title"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MovieDTO>() {{
                    setTargetType(MovieDTO.class);
                }})
                .build();

        dirReader = new FlatFileItemReaderBuilder<DirectorDTO>()
                .name("directorReader")
                .resource(resourceLoader.getResource("classpath:sample_directors.csv"))
                .delimited()
                .delimiter(",")
                .names(new String[]{"movieId", "name"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<DirectorDTO>() {{
                    setTargetType(DirectorDTO.class);
                }})
                .build();

        moviePeekReader = new SingleItemPeekableItemReaderBuilder<MovieDTO>()
                .delegate(mReader)
                .build();

        directorPeekReader = new SingleItemPeekableItemReaderBuilder<DirectorDTO>()
                .delegate(dirReader)
                .build();
    }

    @Override
    public MovieDetails read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        MovieDTO mDTO = moviePeekReader.peek();
        DirectorDTO dirDTO = directorPeekReader.peek();
        if (mDTO == null) {
            return null;
        }
        Long mDTOId = mDTO.getMovieId();
        if (dirDTO == null) {
            return convertMovie(mDTO);
        }

        Long dirDTOId = dirDTO.getMovieId();

        if (mDTOId == dirDTOId) {
            //advance to next item
            moviePeekReader.read();
            directorPeekReader.read();
            return convertMovie(mDTO, dirDTO);
        }
        if (mDTOId < dirDTOId) {
            moviePeekReader.read();
            //to advance the peek method to the next item
            return read();
        }
        if (mDTOId > dirDTOId) {
            directorPeekReader.read();
            //to advance the peek method to the next item
            return read();
        }

        //should not get here
        return null;
    }


    private MovieDetails convertMovie(MovieDTO m) {
        MovieDetails returned = new MovieDetails();
        returned.setMovieId(m.getMovieId());
        returned.setTitle(m.getTitle());
        return returned;
    }
    private MovieDetails convertMovie(MovieDTO m , DirectorDTO dir) {
        MovieDetails returned = new MovieDetails();
        returned.setMovieId(m.getMovieId());
        returned.setTitle(m.getTitle());
        returned.setDirector(dir.getName());

        return returned;

    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        moviePeekReader.open(executionContext);
        directorPeekReader.open(executionContext);

    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() throws ItemStreamException {
        moviePeekReader.close();
        directorPeekReader.close();
    }



}