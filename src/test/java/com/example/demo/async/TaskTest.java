package com.example.demo.async;

import com.example.demo.DemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Task Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 5, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TaskTest {

    @Autowired
    private Task task;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doTaskOne()
     */
    @Test
    public void testDoTaskOne() throws Exception {
        for (int i = 0; i < 1000; i++){
            task.doTaskOne();
        }
    }


} 
