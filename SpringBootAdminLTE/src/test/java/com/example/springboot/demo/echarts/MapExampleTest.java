package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class MapExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = MapExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart1", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart1\"));"));
	}

}
