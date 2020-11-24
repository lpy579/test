package com.example.springboot.common;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyDataTablesTemplateTest {

	@Test
	@Disabled
	void test_generateBodyJS_001() {
		MyDataTablesTemplate template = new MyDataTablesTemplate();
		template.add("table1");
		template.add("table2", "{ paging: false, ordering: false, info: false }");
		
		String html = template.generateBodyJS_001();
		System.out.println(html);
	}

	@Test
	void test_generateBodyJS_002() throws Exception {
		MyDataTablesTemplate template = new MyDataTablesTemplate();
		template.add("table1");
		template.add("table2", "{ paging: false, ordering: false, info: false }");
		
		String html = template.generateBodyJS_002();
		System.out.println(html);
	}
}
