package com.project.batch.jobs.writes;

import java.util.List;

import com.project.batch.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * WRITE TO CASSANDRA DATABASE
 *
 * @param <Person>
 */
public class PersonCassandraBatchItemWriter<Person> implements ItemWriter<Person>, InitializingBean {

    protected static final Log logger = LogFactory.getLog(PersonCassandraBatchItemWriter.class);

    private final Class<Person> aClass;

    // Autowired: PersonService
    @Autowired
    private PersonService personService;

    @Override
    public void afterPropertiesSet() throws Exception { }

    public PersonCassandraBatchItemWriter(final Class<Person> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void write(final List<? extends Person> items) throws Exception {
        // no day man hinh xuong - the thoi - tao ghet cai mui nuoc hoa vcl ra thang nay van tan con nay

        // con nay muon dua day voi nguoi khac
        logger.debug("Write operations is performing, the size is {}" + items.size());

        if (!items.isEmpty()) {

            logger.info("Inserting in a batch performing...");

            for (Person entity : items) {

                // no giong con trai vcl ra - no bat dau ban luan nay - im im di - de xem tui nay lam gi minh

                personService.saveEntity(entity);
                //nghe rock - day la kieu nguoi manh me day - ai cung im lang nhi - ke me tao - binh thuong la vay



            }

        }



    }

}

