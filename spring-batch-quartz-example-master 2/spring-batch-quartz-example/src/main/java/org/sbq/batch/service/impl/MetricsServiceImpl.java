package org.sbq.batch.service.impl;

import org.sbq.batch.exceptions.TransientException;
import org.sbq.batch.service.MetricsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author ilya40umov
 */
@Service
public class MetricsServiceImpl implements MetricsService
{
    @Override
    public void calculateEventMetrics(Date startingFrom, Date endingAt)
    {

    }

    @Override
    public void calculateOnlineMetrics(Date at)
    {
        Random rnd = new Random();
        // Random
        if (rnd.nextInt(3) == 0)
        {
            throw new TransientException("This kind of problem can sometimes happen!");
        }
    }
}



// no van bth - no co bo roi ma - lol -


