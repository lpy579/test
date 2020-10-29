package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class BarExampleTest {

	@Test
	void testGetChart0() {
		GsonOption chartOption = BarExample.getChart0();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart0", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart0\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"title\": {\"text\": \"地市数据\"}"));
	}

	@Test
	void testGetChart1() {
		GsonOption chartOption = BarExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart1", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart1\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"title\": {\"text\": \"某地区蒸发量和降水量\",\"subtext\": \"纯属虚构\"}"));
	}

	@Test
	void testGetChart4() {
		GsonOption chartOption = BarExample.getChart4();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart4", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart4\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"data\": [\"周一\",\"周二\",\"周三\",\"周四\",\"周五\",\"周六\",\"周日\"]"));
	}

	@Test
	void testGetChart12() {
		GsonOption chartOption = BarExample.getChart12();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart12", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart12\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"title\": {\"text\": \"ECharts2 vs ECharts1\",\"subtext\": \"Chrome下测试数据\"}"));
	}

	@Test
	void testGetChart14() {
		GsonOption chartOption = BarExample.getChart14();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart14", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart14\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"text\": \"ECharts例子个数统计\""));
	}

}
