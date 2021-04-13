package com.example.springboot.demo.tablesaw;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

class CuteAnimalExampleTest {

	@Test
	//@Disabled
	void test() {
		Table table = CuteAnimalExample.getTable1();
		//System.out.println(table);
		//System.out.println();
		Assertions.assertNotNull(table);

		// display the columns.
		List<String> columnNameList = table.columnNames();
		String strColumnNameList  = String.join(" | ", columnNameList);
		//System.out.print("Column Names: " + strColumnNameList);
		//System.out.println();
		Assertions.assertEquals("Animal types | rating", strColumnNameList);
		
		ColumnType[] columnTypes = table.columnTypes();
		List<Object> columnTypeList = Arrays.asList(columnTypes);
		String strColumnTypeList = columnTypeList.stream().map(Object::toString).collect(Collectors.joining(" | "));
		//System.out.print("Column Types: " + strColumnTypeList);
		//System.out.println();
		Assertions.assertEquals("STRING | DOUBLE", strColumnTypeList);

		// validate the table.
		Assertions.assertEquals(3, table.rowCount());
		Assertions.assertEquals(2, table.columnCount());
		
		Assertions.assertEquals("bear", table.getString(0, 0));
		Assertions.assertEquals("cat", table.getString(1, 0));
		Assertions.assertEquals("giraffe", table.getString(2, 0));

		Assertions.assertEquals(Double.valueOf(90.1), table.get(0, 1));
		Assertions.assertEquals(Double.valueOf(84.3), table.get(1, 1));
		Assertions.assertEquals(Double.valueOf(99.7), table.get(2, 1));

		// access table by Row and column index.
		System.out.println("--------- Row and column index ---------");
		int rowcount = 1;
		for (Row row : table) {
			System.out.print("ROW_" + rowcount + ": ");
			for (int i=0; i<row.columnCount(); ++i) {
				Object value = row.getObject(i);
				System.out.print(value + " | ");
			}
			System.out.println();
			rowcount++;
		}
		
		// access table all by index.
		System.out.println("--------- all by index ---------");
		for (int r=0; r<table.rowCount(); ++r) {
			System.out.print("ROW_" + (r+1) + ": ");
			for (int c=0; c<table.columnCount(); ++c) {
				Object objValue = table.get(r, c);
				System.out.print(objValue + " | ");
			}
			System.out.println();
		}
	}

}
