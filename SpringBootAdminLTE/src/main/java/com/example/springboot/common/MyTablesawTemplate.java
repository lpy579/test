package com.example.springboot.common;

import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.springboot.config.AppConfig;

import tech.tablesaw.api.Table;

/**
 * A template processing engine for
 * [Tablesaw](https://github.com/jtablesaw/tablesaw).
 * 
 * https://attacomsian.com/blog/thymeleaf-iterate-map-list-set-array
 * 
 * @author bobyuan
 */
public class MyTablesawTemplate {
	private static final String TABLESAW_SIMPLE_001 = "tablesaw_simple_001";
	private static final String TABLESAW_SIMPLE_002 = "tablesaw_simple_002";

	private TemplateEngine engine;

	/**
	 * Default constructor.
	 */
	public MyTablesawTemplate() {
		boolean enableCache = AppConfig.IS_IN_PRODUCTION;
		engine = MyThymeleafUtils.newTemplateEngine(enableCache);
	}

	/**
	 * Generate the table tag.
	 */
	public String generateTag(String tableId, final List<String> columnNameList, final List<List<Object>> tableData) {
		Context context = new Context();
		context.setVariable("tableId", tableId);
		context.setVariable("tableColumnNameList", columnNameList);
		context.setVariable("tableData", tableData);
		return engine.process(TABLESAW_SIMPLE_001, context);
	}

	/**
	 * Generate the table tag.
	 */
	public String generateTag(String tableId, final Table tablesawObj) {
		List<String> columnNameList = MyTablesawUtils.getTablesawColumNameList(tablesawObj);
		List<List<Object>> tableData = MyTablesawUtils.getTablesawData(tablesawObj);
		return generateTag(tableId, columnNameList, tableData);
	}

	/**
	 * Generate the whole HTML.
	 */
	public String generateHTML(final List<String> columnNameList, final List<List<Object>> tableData) {
		Context context = new Context();
		context.setVariable("tableId", "table1");
		context.setVariable("tableColumnNameList", columnNameList);
		context.setVariable("tableData", tableData);
		return engine.process(TABLESAW_SIMPLE_002, context);
	}

	/**
	 * Generate the whole HTML.
	 */
	public String generateHTML(final Table tablesawObj) {
		List<String> columnNameList = MyTablesawUtils.getTablesawColumNameList(tablesawObj);
		List<List<Object>> tableData = MyTablesawUtils.getTablesawData(tablesawObj);
		return generateHTML(columnNameList, tableData);
	}

	/**
	 * Save the table HTML into a temporary file, and open browser to view it.
	 * 
	 * @param tablesawId  The id of the table in the HTML.
	 * @param tablesawObj A Tablesaw object.
	 * @throws Exception
	 */
	public void preview(final Table tablesawObj) throws Exception {
		String htmlContent = generateHTML(tablesawObj);
		MyCommonUtils.previewHTML(htmlContent);
	}
}
