package com.example.demo.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhangP
 * @since 2019-06-05 13:44
 */
@Configuration
public class Config {


    /**
     * 核心线程大小
     */
    private static int CORE_POOL_SIZE = 64;
    /**
     * 线程池最大线程数
     */
    private static int MAX_POOL_SIZE = 128;
    /**
     * 额外线程空状态生存时间
     */
    private static int KEEP_ALIVE_TIME = 30 * 1000;
    /**
     * 队列大小
     */
    private static int MAX_QUEUE_SIZE = 10000;

    /**
     * 配置线程池
     *
     * @return
     */
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(MAX_QUEUE_SIZE);
        taskExecutor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        taskExecutor.setThreadNamePrefix("oKong-");
        // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //调度器shutdown被调用时等待当前被调度的任务完成
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }


}
