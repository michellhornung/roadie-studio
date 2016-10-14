package com.hornung.roadiestudio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hornung.roadiestudio.RoadieStudioApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RoadieStudioApplication.class)
@WebAppConfiguration
public class RoadieStudioApplicationTests {

	@Test
	public void contextLoads() {
	}

}
