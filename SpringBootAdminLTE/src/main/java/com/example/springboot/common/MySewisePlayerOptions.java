package com.example.springboot.common;

import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.util.Strings;

/**
 * An object holds all the Sewise Player options.
 * 
 * [SewisePlayer](https://github.com/jackzhang1204/sewise-player) is an open
 * source HTML5 video player.
 * 
 * @author bobyuan
 */
public class MySewisePlayerOptions {
	public static final String CONST_SERVER_VOD = "vod";
	public static final String CONST_SERVER_LIVE = "live";

	public static final String CONST_VIDEO_TYPE_MP4 = "mp4";

	public static final String CONST_LANG_EN_US = "en_US";
	public static final String CONST_LANG_ZH_CN = "zh_CN";

	public static final String CONST_SKIN_VOD_WHITE = "vodWhite";
	public static final String CONST_SKIN_LIVE_WHITE = "liveWhite";

	private String sewisePlayerJsUrl;
	private String serverType;
	private String videoType;
	private String videoUrl;
	private String sourceId;
	private boolean enableAutoStart;
	private long startTime;
	private String lang;
	private String logo;
	private String title;
	private long buffer;
	private String skin;
	private String fallbackUrls;
	private boolean enableTopbarDisplay;
	private boolean enableClarityButton;

	public MySewisePlayerOptions() {
		// set default values...
		sewisePlayerJsUrl = null;
		serverType = CONST_SERVER_VOD;
		videoType = CONST_VIDEO_TYPE_MP4;
		videoUrl = null;
		sourceId = null;
		enableAutoStart = false;
		startTime = 0;
		lang = CONST_LANG_EN_US;
		logo = null;
		title = null;
		buffer = 5;
		skin = CONST_SKIN_VOD_WHITE;
		fallbackUrls = null;
		enableTopbarDisplay = false;
		enableClarityButton = false;
	}

	private static void putMandatoryParam(Map<String, String> paramMap, String key, String value)
			throws IllegalArgumentException {
		if (Strings.isEmpty(value)) {
			throw new IllegalArgumentException("Mandatory property is missing: " + key);
		} else {
			paramMap.put(key, value);
		}
	}

	private static void putOptionalParam(Map<String, String> paramMap, String key, String value) {
		if (Strings.isEmpty(value)) {
			// do nothing.
		} else {
			paramMap.put(key, value);
		}
	}

	private static void putOptionalParam(Map<String, String> paramMap, String key, String value, String valueDefault) {
		if (Strings.isEmpty(value)) {
			paramMap.put(key, valueDefault);
		} else {
			paramMap.put(key, value);
		}
	}

	/**
	 * Build the URL to use Sewise Player.
	 * 
	 * @return The URL with options.
	 * @throws IllegalArgumentException If anything wrong in building the URL.
	 */
	public String buildUrl() throws IllegalArgumentException {
		try {
			// use LinkedHashMap to ensure the parameters inserted are in order.
			Map<String, String> paramMap = new LinkedHashMap<>();

			// mandatory properties.
			putMandatoryParam(paramMap, "server", serverType);
			putMandatoryParam(paramMap, "type", videoType);
			putMandatoryParam(paramMap, "videourl", videoUrl);

			// optional properties.
			putOptionalParam(paramMap, "sourceid", sourceId);
			putOptionalParam(paramMap, "lang", lang, CONST_LANG_EN_US);
			putOptionalParam(paramMap, "logo", logo);
			putOptionalParam(paramMap, "title", title);
			putOptionalParam(paramMap, "skin", skin, CONST_SKIN_VOD_WHITE);
			putOptionalParam(paramMap, "fallbackurls", fallbackUrls);

			// must-exist properties.
			paramMap.put("autostart", Boolean.toString(enableAutoStart));
			paramMap.put("starttime", Long.toString(startTime));
			paramMap.put("buffer", Long.toString(buffer));
			paramMap.put("topbardisplay", enableTopbarDisplay ? "enable" : "disable");
			paramMap.put("claritybutton", enableClarityButton ? "enable" : "disable");

			return MyCommonUtils.buildUrlString(sewisePlayerJsUrl, paramMap);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Error building URL with exception: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	// ---- Getter and Setter ----

	public String getSewisePlayerJsUrl() {
		return sewisePlayerJsUrl;
	}

	public void setSewisePlayerJsUrl(String sewisePlayerJsUrl) {
		this.sewisePlayerJsUrl = sewisePlayerJsUrl;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public boolean isEnableAutoStart() {
		return enableAutoStart;
	}

	public void setEnableAutoStart(boolean enableAutoStart) {
		this.enableAutoStart = enableAutoStart;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBuffer() {
		return buffer;
	}

	public void setBuffer(long buffer) {
		this.buffer = buffer;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getFallbackUrls() {
		return fallbackUrls;
	}

	public void setFallbackUrls(String fallbackUrls) {
		this.fallbackUrls = fallbackUrls;
	}

	public boolean isEnableTopbarDisplay() {
		return enableTopbarDisplay;
	}

	public void setEnableTopbarDisplay(boolean enableTopbarDisplay) {
		this.enableTopbarDisplay = enableTopbarDisplay;
	}

	public boolean isEnableClarityButton() {
		return enableClarityButton;
	}

	public void setEnableClarityButton(boolean enableClarityButton) {
		this.enableClarityButton = enableClarityButton;
	}
}
