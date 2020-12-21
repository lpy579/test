package com.example.springboot.config;

import java.io.IOException;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Application wide configuration, and beans.
 * 
 * @author bobyuan
 */
@Configuration
public class AppConfig {
	public static final String ENV_SERVER_TYPE = "SERVER_TYPE";
	public static final boolean IS_IN_PRODUCTION = isInProduction();
	
	/**
	 * Test if this server is in production.
	 * @return true if Linux and environment variable: SERVER_TYPE=prod
	 */
	private static boolean isInProduction() {
		if (SystemUtils.IS_OS_UNIX) {
			// For production environment, set to true.
			String serverType = System.getProperty(ENV_SERVER_TYPE).toLowerCase();
			if ("prod".equals(serverType)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Change the behavior of Jackson Object Mapper.
	 * Used in returing an object (as JSON) from controller.
	 */
	@Bean
	@Primary
	@ConditionalOnMissingBean(ObjectMapper.class)
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();

		// 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
		// Include.Include.ALWAYS 默认
		// Include.NON_DEFAULT 属性为默认值不序列化
		// Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
		// Include.NON_NULL 属性为NULL 不序列化
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		// 字段保留，将null值转为""
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
					throws IOException, JsonProcessingException {
				jsonGenerator.writeString("");
			}
		});
		return objectMapper;
	}
}
