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
		String tag = template.generateChartTag("chart6", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart6\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart7() {
		GsonOption chartOption = PieExample.getChart7();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart7", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart7\" style=\"width:500px; height:400px\"></div>"));
	}

}
