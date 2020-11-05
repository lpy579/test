package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class GaugeExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = GaugeExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart1", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("\"data\": [{\"name\": \"完成率\",\"value\": 75}]"));
	}

}
