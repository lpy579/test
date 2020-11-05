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
		String js = template.generateChartJS("chart0", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"title\": {\"text\": \"地市数据\"}"));
	}

	@Test
	void testGetChart1() {
		GsonOption chartOption = BarExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart1", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"title\": {\"text\": \"某地区蒸发量和降水量\",\"subtext\": \"纯属虚构\"}"));
	}

	@Test
	void testGetChart4() {
		GsonOption chartOption = BarExample.getChart4();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart4", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"data\": [\"周一\",\"周二\",\"周三\",\"周四\",\"周五\",\"周六\",\"周日\"]"));
	}

	@Test
	void testGetChart12() {
		GsonOption chartOption = BarExample.getChart12();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart12", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"title\": {\"text\": \"ECharts2 vs ECharts1\",\"subtext\": \"Chrome下测试数据\"}"));
	}

	@Test
	void testGetChart14() {
		GsonOption chartOption = BarExample.getChart14();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart14", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"text\": \"ECharts例子个数统计\""));
	}

}
