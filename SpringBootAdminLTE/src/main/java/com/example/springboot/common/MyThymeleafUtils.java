package com.example.springboot.common;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Utility functions for Thymeleaf.
 * 
 * @author bobyuan
 */
public class MyThymeleafUtils {
	/** The template path under resources folder */
	public static final String TEMPLATE_PREFIX = "templates/mythymeleaf/";

	/** The template file extension */
	public static final String TEMPLATE_SUFFIX = ".html";

	/**
	 * Create a new TemplateEngine, it will specify the template resources.
	 * 
	 * @param enableCache Set to true in production.
	 * @return A Thymeleaf template engine.
	 */
	public static TemplateEngine newTemplateEngine(boolean enableCache) {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		// set the template location in resources.
		templateResolver.setPrefix(TEMPLATE_PREFIX);
		templateResolver.setSuffix(TEMPLATE_SUFFIX);
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCacheable(enableCache);

		// initialize the Thymeleaf template engine.
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(templateResolver);

		return engine;
	}
}
