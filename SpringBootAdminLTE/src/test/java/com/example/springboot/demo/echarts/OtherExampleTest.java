package com.example.springboot.demo.echarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springboot.common.MyEchartsTemplate;
import com.github.abel533.echarts.json.GsonOption;

class OtherExampleTest {

	@Test
	void testGetChart1() {
		GsonOption chartOption = OtherExample.getChart1();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart1", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart1\"));"));
	}

	@Test
	void testGetChart2() {
		GsonOption chartOption = OtherExample.getChart2();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String js = template.generateChartJS("chart2", chartOption);
		//System.out.println(js);
		Assertions.assertTrue(js.contains("echarts.init(document.getElementById(\"chart2\"));"));

		//转换为json
        //System.out.println(option.toString());
        //格式化的json，不利于传输，适合阅读
        //System.out.println(option.toPrettyString());
		
		//chartOption.exportToHtml("D:\\TEMP", "other_example.html");
		//chartOption.view();
	}

}
