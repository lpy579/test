package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class FunnelExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = FunnelExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart1", 500, 400, chartOption);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart1\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"title\": {\"text\": \"漏斗图\",\"subtext\": \"纯属虚构\"}"));
	}

	@Test
	void testGetChart2() {
		GsonOption chartOption = FunnelExample.getChart2();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart2", 500, 400, chartOption);
		System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart2\" style=\"width:500px; height:400px\"></div>"));
		Assertions.assertTrue(tag.contains("\"data\": [\"展现\",\"点击\",\"访问\",\"咨询\",\"订单\"]"));
	}

}
