package com.munteanu.exectutor_service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceMain {
    public static void main(String[] args) {

//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


        // corePoolSize the number of threads to keep in the pool, even if they are idle
        int corePoolSize = 4;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(corePoolSize);


//        executorService.scheduleAtFixedRate()
//        executorService.scheduleWithFixedDelay()
    }
}
