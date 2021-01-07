package com.example.springboot.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

/**
 * Test case for MyTablesawTemplate.
 * 
 * @author bobyuan
 */
@Tag("junit5")
class MyTablesawTemplateTest {
	public static Table getTablesawTable() {
		String[] animals = { "bear", "cat", "giraffe", "dog", "duck", "fish", "mouse", "monkey", "bird", "snake", "rabbit", "worm" };
		double[] cuteness = { 90.1, 84.3, 99.7, 89.2, 76.5, 88.3, 85.48, 90.23, 92.1, 67.4, 93.2, 78.22};

		Table cuteAnimals = Table.create("Cute Animals").addColumns(StringColumn.create("Animal types", animals),
				DoubleColumn.create("rating", cuteness));

		return cuteAnimals;
	}

	@Test
	void test_generateTag() {
		String tablesawId = "tablesaw1";
		Table tablesawObj = getTablesawTable();

		MyTablesawTemplate template = new MyTablesawTemplate();
		String tag = template.generateTag(tablesawId, tablesawObj);
		// System.out.println(tag);
		Assertions.assertTrue(tag.contains("<table id=\"tablesaw1\""));
		Assertions.assertTrue(tag.contains("<td>Animal types</td>"));
		Assertions.assertTrue(tag.contains("<td>bear</td>"));
		Assertions.assertTrue(tag.contains("<td>90.1</td>"));
		Assertions.assertTrue(tag.contains("</table>"));
	}

	@Test
	void test_generateHTML() {
		Table tablesawObj = getTablesawTable();

		MyTablesawTemplate template = new MyTablesawTemplate();
		String html = template.generateHTML(tablesawObj);
		System.out.println(html);
		Assertions.assertTrue(html.contains("<html>"));
		Assertions.assertTrue(html.contains("<body>"));

		Assertions.assertTrue(html.contains("<td>Animal types</td>"));
		Assertions.assertTrue(html.contains("<td>bear</td>"));
		Assertions.assertTrue(html.contains("<td>90.1</td>"));
		Assertions.assertTrue(html.contains("</table>"));

		Assertions.assertTrue(html.contains("</body>"));
		Assertions.assertTrue(html.contains("</html>"));
	}

	@Test
	void test_preview() {
		Table tablesawObj = getTablesawTable();

		try {
			MyTablesawTemplate template = new MyTablesawTemplate();
			template.preview(tablesawObj);
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(e.getMessage());
		}
	}
}
