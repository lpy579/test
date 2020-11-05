package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class HeatmapExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = HeatmapExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart1", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("\"data\": [\"Saturday\",\"Friday\",\"Thursday\",\"Wednesday\",\"Tuesday\",\"Monday\",\"Sunday\"]"));
	}

}
