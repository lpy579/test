package com.example.springboot.common;

import org.apache.commons.lang3.SystemUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Utility functions for Thymeleaf.
 * 
 * @author bobyuan
 */
public class MyThymeleafUtils {

	/**
	 * Create a new TemplateEngine, it will specify the template resources.
	 * 
	 * @return
	 */
	public static TemplateEngine newTemplateEngine() {
		final String TEMPLATE_PREFIX = "templates/mythymeleaf/";
		final String TEMPLATE_SUFFIX = ".html";

		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

		// set the template location in resources.
		templateResolver.setPrefix(TEMPLATE_PREFIX);
		templateResolver.setSuffix(TEMPLATE_SUFFIX);
		templateResolver.setTemplateMode("HTML");

		if (SystemUtils.IS_OS_WINDOWS) {
			// Windows is for development, set to false.
			templateResolver.setCacheable(false);
		} else {
			// For production environment, set to true.
			templateResolver.setCacheable(true);
		}

		// initialize the Thymeleaf template engine.
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(templateResolver);

		return engine;
	}

}
