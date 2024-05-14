package faang.school.urlshortenerservice.config.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class ExecutorConfig implements AsyncConfigurer {

    @Value("${executor.service.batch_size}")
    private int threadBatch;

    @Bean
    public ExecutorService executor() {
        ExecutorService service = Executors.newFixedThreadPool(threadBatch);
        return service;
    }
}
