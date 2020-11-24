package com.example.springboot.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class MyCommonUtils {
	/**
	 * Save the text content (in UTF-8) to given file, using Apache Commons IO.
	 * 
	 * @param file    The full file name with path.
	 * @param content The text content to be saved.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void saveToTextFileUTF8(File file, String content) throws IOException {
		final String ENCODING_UTF8 = "utf-8";
		FileUtils.writeStringToFile(file, content, ENCODING_UTF8);
	}

	/**
	 * Load the text content (in UTF-8) from given file, using Apache Commons IO.
	 * 
	 * @param file The full file name with path.
	 * @return The text content in that file.
	 * @throws IOException
	 */
	public static String loadFromTextFileUTF8(File file) throws IOException {
		final String ENCODING_UTF8 = "utf-8";
		String content = FileUtils.readFileToString(file, ENCODING_UTF8);
		return content;
	}

	/**
	 * Open a default browser to the given URL.
	 * https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
	 * 
	 * @param url
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws Exception
	 */
	public static void browse(String url) throws IOException {
		// use runtime to open browser.
		String os = System.getProperty("os.name", "").toLowerCase();
		Runtime runtime = Runtime.getRuntime();
		if (os.indexOf("mac") >= 0) { // Mac
			runtime.exec("open " + url);
		} else if (os.indexOf("win") >= 0) { // Windows
			runtime.exec("rundll32 url.dll,FileProtocolHandler \"" + url + "\"");
		} else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) { // Unix or Linux.
			runtime.exec("xdg-open " + url);
		} else {
			throw new RuntimeException("Not able to detect the OS: " + os);
		}
	}
	
	/**
	 * Save the HTML content into a temporary file, and open browser to view it.
	 * 
	 * @param htmlContent The full HTML content in String.
	 * @throws Exception
	 */
	public static void previewHTML(final String htmlContent) throws Exception {
		// generate a temporary file.
		String fileName = "previewHTML" + System.currentTimeMillis() + ".html";
		Path filePath = Paths.get(System.getProperty("java.io.tmpdir"), fileName);
		String tempHtmlFile = filePath.toString();
		// System.out.println(tempHtmlFile);

		// write the HTML content into that file.
		File htmlFile = new File(tempHtmlFile);
		try (OutputStream os = new FileOutputStream(htmlFile);
				Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
			w.write(htmlContent);
		}

		// open browser to view that file.
		browse(tempHtmlFile);
	}
}
