package com.example.springboot.common;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.springboot.config.AppConfig;

/**
 * A template processing engine for [SewisePlayer](https://github.com/jackzhang1204/sewise-player).
 * 
 * @author bobyuan
 */
public class MySewisePlayerTemplate {
	//private static final String SEWISEPLAYER_SIMPLE_001 = "sewiseplayer_simple_001";
	private static final String SEWISEPLAYER_SIMPLE_002 = "sewiseplayer_simple_002";
	
	private TemplateEngine engine;

	
	/**
	 * Default constructor.
	 */
	public MySewisePlayerTemplate() {
		boolean enableCache = AppConfig.IS_IN_PRODUCTION;
		engine = MyThymeleafUtils.newTemplateEngine(enableCache);
	}
	
	/**
	 * Generate the JavaScript tag.
	 * 
	 * @throws URISyntaxException 
	 * @throws MalformedURLException 
	 */
	public String generateJS(final MySewisePlayerOptions opts) throws IllegalArgumentException  {
		String sewisePlayerJsSrc = opts.buildUrl();
		String TEMPLATE_STR = "<script type=\"text/javascript\" src=\"%s\"></script>";
		return String.format(TEMPLATE_STR, sewisePlayerJsSrc);
	}
	
	/**
	 * Generate the whole HTML.
	 * @throws URISyntaxException 
	 * @throws MalformedURLException 
	 */
	public String generateHTML(final MySewisePlayerOptions opts) throws IllegalArgumentException {
		String sewisePlayerJs = generateJS(opts);
		
		Context context = new Context();
		context.setVariable("sewisePlayerJs", sewisePlayerJs);
		return engine.process(SEWISEPLAYER_SIMPLE_002, context);
	}
	
	/**
	 * Save the HTML into a temporary file, and open browser to view it.
	 * 
	 * @param videoUrl The URL to the video.
	 * @throws Exception
	 */
	public void preview(final MySewisePlayerOptions opts) throws Exception {
		String htmlContent = generateHTML(opts);
		MyCommonUtils.previewHTML(htmlContent);
	}
}
