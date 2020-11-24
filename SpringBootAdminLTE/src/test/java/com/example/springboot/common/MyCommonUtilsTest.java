package com.example.springboot.common;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyCommonUtilsTest {

	@Test
	void testSaveToTextFileUTF8() {
		// fail("Not yet implemented");
	}

	@Test
	void testLoadFromTextFileUTF8() {
		// fail("Not yet implemented");
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
