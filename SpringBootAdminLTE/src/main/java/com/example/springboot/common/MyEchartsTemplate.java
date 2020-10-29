package com.example.springboot.common;

import org.apache.commons.lang3.SystemUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;

/**
 * Generate ECharts HTML using Thymeleaf template engine.
 * 
 * @author bobyuan
 */
public class MyEchartsTemplate {
	public static final String TEMPLATE_PREFIX = "templates/myecharts/";
	public static final String TEMPLATE_SUFFIX = ".html";
	public static final String TEMPLATE_SIMPLE_001 = "myecharts_simple_001";
	public static final String TEMPLATE_SIMPLE_002 = "myecharts_simple_002";

	private TemplateEngine engine;

	/**
	 * Default constructor.
	 */
	public MyEchartsTemplate() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		// set the template location in resources.
		templateResolver.setPrefix(TEMPLATE_PREFIX);
		templateResolver.setSuffix(TEMPLATE_SUFFIX);
		templateResolver.setTemplateMode("HTML");

		if (SystemUtils.IS_OS_WINDOWS) {
			// Windows is for development, set to false.
			templateResolver.setCacheable(false);
		} else {
			// For production environment, set to true.
			templateResolver.setCacheable(true);
		}

		// initialize the Thymeleaf template engine.
		engine = new TemplateEngine();
		engine.setTemplateResolver(templateResolver);
	}

	protected String generateChartHtmlUsingTemplate(String templateName, String chartId, int chartWidth,
			int chartHeight, Option chartOption) {
		String chartOptionJson = GsonUtil.format(chartOption);

		Context context = new Context();
		context.setVariable("chartId", chartId);
		context.setVariable("chartWidth", chartWidth);
		context.setVariable("chartHeight", chartHeight);
		context.setVariable("chartOptionJson", chartOptionJson);

		return engine.process(templateName, context);
	}

	/**
	 * Generate only the chart tags (to be embedded into HTML).
	 */
	public String generateChartTag(String chartId, int chartWidth, int chartHeight, Option chartOption) {
		return generateChartHtmlUsingTemplate(TEMPLATE_SIMPLE_001, chartId, chartWidth, chartHeight, chartOption);
	}

	/**
	 * Generate the chart HTML, easily to view in browser.
	 */
	public String generateChartHTML(String chartId, int chartWidth, int chartHeight, Option chartOption) {
		return generateChartHtmlUsingTemplate(TEMPLATE_SIMPLE_002, chartId, chartWidth, chartHeight, chartOption);
	}
}
