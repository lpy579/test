package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class PieExampleTest {

	@Test
	void testGetChart6() {
		GsonOption chartOption = PieExample.getChart6();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart6", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart6\"));"));
	}

	@Test
	void testGetChart7() {
		GsonOption chartOption = PieExample.getChart7();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart7", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart7\"));"));
	}

}
