package com.project.batch.batch;



import com.project.batch.model.user;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * User process class
 */
@Component
public class UserProcessor implements ItemProcessor<user, user> {

    @Override
    public user process(user user) throws Exception {
        user.setId(1L);
        user.setDate(new Date());
        return user;
    }
}

