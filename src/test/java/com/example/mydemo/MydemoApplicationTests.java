package com.example.mydemo;

import com.example.mydemo.controller.DefaultController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@AutoConfigureJdbc
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ImportAutoConfiguration
public class MydemoApplicationTests {

	@Test
	public void testHomePage() {
		DefaultController dc = new DefaultController();
		String result = dc.home();
        assertEquals(result, "Reporting for duty!");
	}

}
