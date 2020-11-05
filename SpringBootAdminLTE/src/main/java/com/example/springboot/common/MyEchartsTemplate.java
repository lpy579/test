package com.example.springboot.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.json.OptionUtil;

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

	/**
	 * Generate only the chart Javascript.
	 * 
	 * @param chartId     The chartId of the <div> place-holder in the HTML.
	 * @param chartOption The ECharts option object.
	 * @return Javascript that can be embedded into HTML.
	 */
	public String generateChartJS(String chartId, Option chartOption) {
		String chartOptionJson = GsonUtil.format(chartOption);

		Context context = new Context();
		context.setVariable("chartId", chartId);
		context.setVariable("chartOptionJson", chartOptionJson);

		return engine.process(TEMPLATE_SIMPLE_001, context);
	}

	/**
	 * Generate the whole chart HTML, easy for preview.
	 * 
	 * @param The ECharts option object.
	 * @return HTML with the ECharts embedded.
	 */
	public String generateChartHTML(Option chartOption) {
		String chartOptionJson = GsonUtil.format(chartOption);

		Context context = new Context();
		context.setVariable("chartId", "chart1");
		context.setVariable("chartOptionJson", chartOptionJson);

		return engine.process(TEMPLATE_SIMPLE_002, context);
	}

	/**
	 * Save the chart HTML into a temporary file, and open browser to view it.
	 * 
	 * @param chartOption The ECharts option object.
	 * @throws Exception
	 */
	public void preview(Option chartOption) throws Exception {
		// generate a temporary file.
		String fileName = "EChartsPreview" + System.currentTimeMillis() + ".html";
		Path filePath = Paths.get(System.getProperty("java.io.tmpdir"), fileName);
		String tempHtmlFile = filePath.toString();
		// System.out.println(tempHtmlFile);

		// write the HTML content into that file.
		File htmlFile = new File(tempHtmlFile);
		try (OutputStream os = new FileOutputStream(htmlFile);
				Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
			String htmlContent = generateChartHTML(chartOption);
			w.write(htmlContent);
		}

		// open browser to view that file.
		OptionUtil.browse(tempHtmlFile);
	}
}
