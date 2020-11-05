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
		String js = template.generateChartJS("chart1", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("\"data\": [\"邮件营销\",\"联盟广告\",\"直接访问\",\"搜索引擎\"]"));
	}

	@Test
	void testGetChart3() {
		GsonOption chartOption = LineExample.getChart3();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart3", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("\"title\": {\"text\": \"某楼盘销售情况\",\"subtext\": \"纯属虚构\"}"));
	}

	@Test
	void testGetChart5() {
		GsonOption chartOption = LineExample.getChart5();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart5", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart5\"));"));
	}

	@Test
	void testGetChart6() {
		GsonOption chartOption = LineExample.getChart6();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart6", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart6\"));"));
	}

	@Test
	void testGetChart9() {
		GsonOption chartOption = LineExample.getChart9();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart9", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart9\"));"));

	}
}
