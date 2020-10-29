package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class LineExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = LineExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart1", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart1\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart3() {
		GsonOption chartOption = LineExample.getChart3();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart3", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart3\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart5() {
		GsonOption chartOption = LineExample.getChart5();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart5", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart5\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart6() {
		GsonOption chartOption = LineExample.getChart6();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart6", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart6\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart9() {
		GsonOption chartOption = LineExample.getChart9();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart9", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart9\" style=\"width:500px; height:400px\"></div>"));

	}

}
