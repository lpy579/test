package com.example.springboot.common;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("junit5")
class MyCommonUtilsTest {

	@Test
	void test_saveToTextFileUTF8() {
		// fail("Not yet implemented");
	}

	@Test
	void test_loadFromTextFileUTF8() {
		// fail("Not yet implemented");
	}
	
	@Test
	void test_buildUrlString_basic() throws URISyntaxException {
		String baseUrl = "http://localhost";
		Map<String, String> paramMap = new LinkedHashMap<>();
		paramMap.put("key1", "value1");
		paramMap.put("key2", "value2");
		paramMap.put("key3", "value3");
		
		String url = MyCommonUtils.buildUrlString(baseUrl, paramMap);
		//System.out.println(url);
		//http://localhost?key1=value1&key2=value2&key3=value3
		
		Assertions.assertEquals(baseUrl + "?key1=value1&key2=value2&key3=value3", url);
	}

	@Test
	void test_buildUrlString_ext() throws URISyntaxException {
		String baseUrl = "http://localhost:8080";
		Map<String, String> paramMap = new LinkedHashMap<>();
		paramMap.put("key1", "");
		paramMap.put("key2", " ");
		paramMap.put("key3", " he llo ");
		paramMap.put("key4", "你好");
		paramMap.put("key5", " 世 界 ");
		paramMap.put("key6", null);
		paramMap.put("中文", "http://gamil.google.com/?q=中文");
		
		String url = MyCommonUtils.buildUrlString(baseUrl, paramMap);
		System.out.println(url);
		//http://localhost:8080?key1=&key2=+&key3=+he+llo+&key4=%E4%BD%A0%E5%A5%BD&key5=+%E4%B8%96+%E7%95%8C+&%E4%B8%AD%E6%96%87=http%3A%2F%2Fgamil.google.com%2F%3Fq%3D%E4%B8%AD%E6%96%87
		
		Assertions.assertTrue(url.startsWith(baseUrl + "?key1=&"));
		Assertions.assertTrue(url.contains("&key2=+"));
		Assertions.assertTrue(url.contains("&key3=+he+llo"));
		Assertions.assertTrue(url.contains("&key4=%E4%BD%A0%E5%A5%BD"));
		Assertions.assertTrue(url.contains("&key5=+%E4%B8%96+%E7%95%8C+"));
		Assertions.assertFalse(url.contains("&key6="));
		Assertions.assertTrue(url.contains("&%E4%B8%AD%E6%96%87=http%3A%2F%2Fgamil.google.com%2F%3Fq%3D%E4%B8%AD%E6%96%87"));
	}
	
	@Test
	@Disabled
	void test_browse1() {
		String url = "http://www.baidu.com";
		try {
			MyCommonUtils.browse(url);
		} catch (Exception e) {
			fail("Failed with exception: " + e.getMessage());
		}
	}

	@Test
	@Disabled
	void test_browse2() throws IOException {
		// generate a temporary file.
		String fileName = "temp" + System.currentTimeMillis() + ".html";
		Path filePath = Paths.get(System.getProperty("java.io.tmpdir"), fileName);
		String tempHtmlFile = filePath.toString();
		// System.out.println(tempHtmlFile);

		// write the HTML content into that file.
		String htmlContent = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "Hello World!\n" + "</body>\n" + "</html>";
		File htmlFile = new File(tempHtmlFile);
		try (OutputStream os = new FileOutputStream(htmlFile);
				Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
			w.write(htmlContent);
		}

		try {
			MyCommonUtils.browse(tempHtmlFile);
		} catch (Exception e) {
			fail("Failed with exception: " + e.getMessage());
		} finally {
			// htmlFile.delete();
		}
	}
	
	@Test
	@Disabled
	void test_previewHTML() {
		// write the HTML content into that file.
		String htmlContent = "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "Hello World!\n" + "</body>\n" + "</html>";
		try {
			MyCommonUtils.previewHTML(htmlContent);
		} catch (Exception e) {
			fail("Failed with exception: " + e.getMessage());
		}
	}
}
