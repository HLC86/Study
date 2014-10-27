package com.my.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xiaoming Wang on 2014/10/24.
 */
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public MyScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    @Override
    public void execute(Runnable command) {
        purge();
        if (getTaskCount() > 0) {
            return;
        }

        schedule(command, 0, TimeUnit.NANOSECONDS);
    }
}
