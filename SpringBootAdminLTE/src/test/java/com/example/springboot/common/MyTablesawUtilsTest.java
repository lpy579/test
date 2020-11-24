package com.example.springboot.common;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

class MyTablesawUtilsTest {
	private static Table getTablesawTable1() {
		String[] animals = { "bear", "cat", "giraffe" };
		double[] cuteness = { 90.1, 84.3, 99.7 };

		Table cuteAnimals = Table.create("Cute Animals").addColumns(
				StringColumn.create("Animal types", animals),
				DoubleColumn.create("rating", cuteness));

		return cuteAnimals;
	}
	
	/*
	private static Table getTablesawTable2() {
		String[] cities = { "广州", "深圳", "珠海", "汕头", "韶关", "佛山" };
		int[] datas = { 6030, 7800, 5200, 3444, 2666, 5708 };

		Table cityValues = Table.create("地市数据").addColumns(
				StringColumn.create("城市", cities),
				IntColumn.create("数据", datas));

		return cityValues;
	}
	*/

	@Test
	public void test_getTablesawColumList() {
		Table table = getTablesawTable1();
		List<String> columnNameList = MyTablesawUtils.getTablesawColumNameList(table);
		Assertions.assertEquals("Animal types", columnNameList.get(0));
		Assertions.assertEquals("rating", columnNameList.get(1));
	}

	@Test
	public void test_getTablesawColumTypeList() {
		Table table = getTablesawTable1();
		List<ColumnType> columnTypeList = MyTablesawUtils.getTablesawColumTypeList(table);
		Assertions.assertEquals(ColumnType.STRING, columnTypeList.get(0));
		Assertions.assertEquals(ColumnType.DOUBLE, columnTypeList.get(1));
	}

	@Test
	public void test_getTablesawRowData() {
		Table table = getTablesawTable1();
		List<Object> rowData0 = MyTablesawUtils.getTablesawRowData(table, 0);
		List<Object> rowData1 = MyTablesawUtils.getTablesawRowData(table, 1);
		List<Object> rowData2 = MyTablesawUtils.getTablesawRowData(table, 2);

		Assertions.assertEquals("bear", rowData0.get(0));
		Assertions.assertEquals(Double.valueOf(90.1), rowData0.get(1));

		Assertions.assertEquals("cat", rowData1.get(0));
		Assertions.assertEquals(Double.valueOf(84.3), rowData1.get(1));

		Assertions.assertEquals("giraffe", rowData2.get(0));
		Assertions.assertEquals(Double.valueOf(99.7), rowData2.get(1));
	}

	@Test
	public void test_getTablesawData() {
		Table table = getTablesawTable1();
		List<List<Object>> data = MyTablesawUtils.getTablesawData(table);

		StringBuffer sb = new StringBuffer();
		for (List<Object> rowData : data) {
			String strRow = rowData.stream().map(Object::toString).collect(Collectors.joining(" | "));
			sb.append(strRow + "\n");
		}
		String strData = sb.toString();
		// System.out.println(strData);
		Assertions.assertEquals("bear | 90.1\ncat | 84.3\ngiraffe | 99.7\n", strData);
	}

	@Test
	public void test_tablesawRowDataToString() {
		Table table = getTablesawTable1();

		String strRow = MyTablesawUtils.tablesawRowDataToString(table, 0, " | ");
		Assertions.assertEquals("bear | 90.1", strRow);

		strRow = MyTablesawUtils.tablesawRowDataToString(table, 1, " | ");
		Assertions.assertEquals("cat | 84.3", strRow);

		strRow = MyTablesawUtils.tablesawRowDataToString(table, 2, " | ");
		Assertions.assertEquals("giraffe | 99.7", strRow);
	}

}
