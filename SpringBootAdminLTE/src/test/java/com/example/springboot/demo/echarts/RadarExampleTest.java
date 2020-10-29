package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class RadarExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = RadarExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart1", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart1\" style=\"width:500px; height:400px\"></div>"));
	}

}
