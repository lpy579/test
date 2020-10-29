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
		String tag = template.generateChartTag("chart1", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart1\" style=\"width:500px; height:400px\"></div>"));
	}

	@Test
	void testGetChart2() {
		GsonOption chartOption = OtherExample.getChart2();
		MyEchartsTemplate template = new MyEchartsTemplate();
		String tag = template.generateChartTag("chart2", 500, 400, chartOption);
		//System.out.println(tag);
		Assertions.assertTrue(tag.contains("<div id=\"chart2\" style=\"width:500px; height:400px\"></div>"));

		//转换为json
        //System.out.println(option.toString());
        //格式化的json，不利于传输，适合阅读
        //System.out.println(option.toPrettyString());
		
		//chartOption.exportToHtml("D:\\TEMP", "other_example.html");
		//chartOption.view();
	}

}
