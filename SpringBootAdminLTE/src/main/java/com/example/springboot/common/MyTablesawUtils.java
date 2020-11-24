package com.example.springboot.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;

/**
 * Utility functions for Tablesaw.
 * 
 * @author bobyuan
 */
public class MyTablesawUtils {

	/**
	 * Get the column name list of the Tablesaw object.
	 * 
	 * @param table A Tablesaw object.
	 * @return List of String.
	 */
	public static List<String> getTablesawColumNameList(Table table) {
		List<String> columnNameList = table.columnNames();
		return columnNameList;
	}

	/**
	 * Get the column type list of the Tablesaw object.
	 * 
	 * @param table A Tablesaw object.
	 * @return List of ColumnType.
	 */
	public static List<ColumnType> getTablesawColumTypeList(Table table) {
		ColumnType[] columnTypes = table.columnTypes();

		List<ColumnType> columnTypeList = new ArrayList<>();
		if (columnTypes.length > 0) {
			for (int i = 0; i < columnTypes.length; ++i) {
				columnTypeList.add(columnTypes[i]);
			}
		}

		return columnTypeList;
	}

	/**
	 * Get a specified row of data from Tablesaw object.
	 * 
	 * @param table    A Tablesaw object.
	 * @param rowIndex A zero based row index.
	 * @return
	 */
	public static List<Object> getTablesawRowData(Table table, int rowIndex) {
		List<Object> rowData = new ArrayList<>();

		for (int columnIndex = 0; columnIndex < table.columnCount(); ++columnIndex) {
			Object objValue = table.get(rowIndex, columnIndex);
			rowData.add(objValue);
		}

		return rowData;
	}

	/**
	 * Get the data from Tablesaw object.
	 * 
	 * @param table A Tablesaw object.
	 * @return List of each row of data.
	 */
	public static List<List<Object>> getTablesawData(Table table) {
		List<List<Object>> data = new ArrayList<>(new ArrayList<>());

		for (int rowIndex = 0; rowIndex < table.rowCount(); ++rowIndex) {
			List<Object> rowData = getTablesawRowData(table, rowIndex);
			data.add(rowData);
		}

		return data;
	}

	/**
	 * Convert (print) the row data to String, useful in debug.
	 * 
	 * @param table     A Tablesaw object.
	 * @param rowIndex  A zero based row index.
	 * @param separator A separator string.
	 */
	public static String tablesawRowDataToString(Table table, int rowIndex, String separator) {
		List<Object> rowData = getTablesawRowData(table, rowIndex);
		String strRow = rowData.stream().map(Object::toString).collect(Collectors.joining(separator));
		return strRow;
	}
}
