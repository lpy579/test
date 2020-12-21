package com.example.springboot.common;

import java.util.Map;
import java.util.TreeMap;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.springboot.config.AppConfig;

/**
 * A template processing engine for [DataTables](https://www.datatables.net).
 * 
 * @author bobyuan
 */
public class MyDataTablesTemplate {
	public static final String DATATABLES_SIMPLE_001 = "datatables_simple_001";
	public static final String DATATABLES_SIMPLE_002 = "datatables_simple_002";
	
	private TemplateEngine engine;
	private Map<String, String> tableOptJsonMap = new TreeMap<>();

	/**
	 * Default constructor.
	 */
	public MyDataTablesTemplate() {
		boolean enableCache = AppConfig.IS_IN_PRODUCTION;
		engine = MyThymeleafUtils.newTemplateEngine(enableCache);
	}

	public void add(String tableId, String tableOptionJson) {
		tableOptJsonMap.put(tableId, tableOptionJson);
	}
	
	public void add(String tableId) {
		tableOptJsonMap.put(tableId, "");
	}

	/**
	 * Generate the chart Javascript using template 001.
	 * 
	 * @param chartId         The chartId of the place-holder in the HTML.
	 * @param chartOptionJson The ECharts option in JSON.
	 * @return Javascript that can be embedded into HTML.
	 */
	public String generateBodyJS_001() {
		Context context = new Context();
		context.setVariable("tableOptJsonMap", tableOptJsonMap);
		return engine.process(DATATABLES_SIMPLE_001, context);
	}
	
	/**
	 * Generate the chart Javascript using template 002.
	 * 
	 * @param chartId         The chartId of the place-holder in the HTML.
	 * @param chartOptionJson The ECharts option in JSON.
	 * @return Javascript that can be embedded into HTML.
	 */
	public String generateBodyJS_002() {
		Context context = new Context();
		context.setVariable("tableOptJsonMap", tableOptJsonMap);
		return engine.process(DATATABLES_SIMPLE_002, context);
	}

}
