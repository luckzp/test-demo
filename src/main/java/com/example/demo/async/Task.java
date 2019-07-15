package com.example.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author ZhangP
 * @since 2019-06-05 13:55
 */
@Component
public class Task {

    @Async("asyncPoolTaskExecutor")
    public Future<String> doTaskOne() throws Exception {
        System.out.println("当前线程名:" +  Thread.currentThread().getName());
        return new AsyncResult<>("任务一完成");
    }
}
