package com.example.mydemo;

import com.example.mydemo.controller.DefaultController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MydemoApplicationTests {

	@Test
	public void testHomePage() {
		DefaultController dc = new DefaultController();
		String result = dc.home();
		assertEquals(result,"reporting for duty!");
	}

}
