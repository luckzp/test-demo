package com.example.demo.async.handler;

import com.example.demo.async.EventHandler;
import com.example.demo.async.EventModel;
import com.example.demo.async.EventType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nowcoder on 2016/7/16.
 */
@Component
public class LoginExceptionHandler implements EventHandler {


    @Override
    public void doHandle(EventModel model) {
        // 判断是否有异常登陆
        System.out.println("I am logining");
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
