package com.example.springboot.common;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.springboot.config.AppConfig;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;

/**
 * A template processing engine for [ECharts](https://echarts.apache.org).
 * 
 * @author bobyuan
 */
public class MyEchartsTemplate {
	public static final String ECHARTS_SIMPLE_001 = "echarts_simple_001";
	public static final String ECHARTS_SIMPLE_002 = "echarts_simple_002";
	
	private TemplateEngine engine;

	/**
	 * Default constructor.
	 */
	public MyEchartsTemplate() {
		boolean enableCache = AppConfig.IS_IN_PRODUCTION;
		engine = MyThymeleafUtils.newTemplateEngine(enableCache);
	}

	/**
	 * Generate the chart Javascript.
	 * 
	 * @param chartId         The chartId of the place-holder in the HTML.
	 * @param chartOptionJson The ECharts option in JSON.
	 * @return Javascript that can be embedded into HTML.
	 */
	public String generateChartJS(String chartId, final String chartOptionJson) {
		Context context = new Context();
		context.setVariable("chartId", chartId);
		context.setVariable("chartOptionJson", chartOptionJson);
		return engine.process(ECHARTS_SIMPLE_001, context);
	}

	/**
	 * Generate only the chart Javascript.
	 * 
	 * @param chartId     The chartId of the place-holder in the HTML.
	 * @param chartOption The ECharts option object.
	 * @return Javascript that can be embedded into HTML.
	 */
	public String generateChartJS(String chartId, final Option chartOption) {
		String chartOptionJson = GsonUtil.format(chartOption);
		return generateChartJS(chartId, chartOptionJson);
	}

	/**
	 * Generate the whole chart HTML.
	 * 
	 * @param The ECharts option object.
	 * @return HTML with the ECharts embedded.
	 */
	public String generateHTML(final String chartOptionJson) {
		Context context = new Context();
		context.setVariable("chartId", "chart1");
		context.setVariable("chartOptionJson", chartOptionJson);
		return engine.process(ECHARTS_SIMPLE_002, context);
	}

	/**
	 * Generate the whole chart HTML.
	 * 
	 * @param The ECharts option object.
	 * @return HTML with the ECharts embedded.
	 */
	public String generateHTML(final Option chartOption) {
		String chartOptionJson = GsonUtil.format(chartOption);
		return generateHTML(chartOptionJson);
	}

	/**
	 * Save the chart HTML into a temporary file, and open browser to view it.
	 * 
	 * @param chartOption The ECharts option object.
	 * @throws Exception
	 */
	public void preview(final Option chartOption) throws Exception {
		String htmlContent = generateHTML(chartOption);
		MyCommonUtils.previewHTML(htmlContent);
	}
}
