package com.example.demo.base;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

/**
 * @author pengzhang34
 * @date 2020/9/25 9:51
 */
@Configuration
@Aspect
@Slf4j
public class RequestLogger {

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object request(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object get(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object post(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public Object put(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object delete(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public Object patch(ProceedingJoinPoint point) throws Throwable {
        return log(point);
    }

    private Object log(ProceedingJoinPoint point) throws Throwable {
        String method = point.getSignature().getName();
        Object[] methodArgs = point.getArgs();

        long startTime = System.currentTimeMillis();
        log.info("Handling HTTP request, {} - [{}]", point.getSignature().toShortString(),
                ofNullable(methodArgs).map(Arrays::stream).orElseGet(Stream::empty)
                        .map(String::valueOf).collect(joining(",")));
        Object response = point.proceed(methodArgs);
        log.info("Handled HTTP request. used time: {} ms \n", System.currentTimeMillis() - startTime);
        return response;
    }
}
