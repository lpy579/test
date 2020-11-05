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
		String js = template.generateChartJS("chart1", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"title\": {\"text\": \"漏斗图\",\"subtext\": \"纯属虚构\"}"));
	}

	@Test
	void testGetChart2() {
		GsonOption chartOption = FunnelExample.getChart2();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart2", chartOption);
		// System.out.println(js);
		Assertions.assertTrue(js.contains("\"data\": [\"展现\",\"点击\",\"访问\",\"咨询\",\"订单\"]"));
	}

}
