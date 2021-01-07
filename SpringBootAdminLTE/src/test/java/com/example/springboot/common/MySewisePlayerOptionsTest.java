package com.example.springboot.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit test for MySewisePlayerOptions.
 * 
 * @author bobyuan
 */
@Tag("junit5")
class MySewisePlayerOptionsTest {
	@Test
	void test_buildUrl_1() throws Exception {
		String sewisePlayerJsUrl = "../player/sewise.player.min.js";
		//String videoUrl = "http://jackzhang1204.github.io/materials/mov_bbb.mp4";
		String videoUrl = "http://localhost/shared_files/myvideo1.mp4";
		String fallbackUrls = "http://jackzhang1204.github.io";

		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);
		opts.setVideoUrl(videoUrl);
		opts.setSourceId("1");
		opts.setEnableAutoStart(true);
		opts.setStartTime(10);
		opts.setLang(MySewisePlayerOptions.CONST_LANG_ZH_CN);
		opts.setLogo("http://onvod.sewise.com/libs/swfplayer/skin/images/logo.png");
		opts.setTitle("VodVideo");
		opts.setBuffer(15);
		opts.setSkin(MySewisePlayerOptions.CONST_SKIN_VOD_WHITE);
		opts.setFallbackUrls(fallbackUrls);
		opts.setEnableTopbarDisplay(false);
		opts.setEnableClarityButton(true);
		
		String jsSrc = opts.buildUrl();
		//System.out.println(jsSrc);
		
		Assertions.assertTrue(jsSrc.startsWith("../player/sewise.player.min.js?"));
		Assertions.assertTrue(jsSrc.contains("?server=vod&type=mp4"));
		Assertions.assertTrue(jsSrc.contains("&videourl=http%3A%2F%2Flocalhost%2Fshared_files%2Fmyvideo1.mp4"));
		Assertions.assertTrue(jsSrc.contains("&sourceid=1"));
		Assertions.assertTrue(jsSrc.contains("&autostart=true"));
		Assertions.assertTrue(jsSrc.contains("&starttime=10"));
		Assertions.assertTrue(jsSrc.contains("&lang=zh_CN"));
		Assertions.assertTrue(jsSrc.contains("&logo=http%3A%2F%2Fonvod.sewise.com%2Flibs%2Fswfplayer%2Fskin%2Fimages%2Flogo.png"));
		Assertions.assertTrue(jsSrc.contains("&title=VodVideo"));
		Assertions.assertTrue(jsSrc.contains("&buffer=15"));
		Assertions.assertTrue(jsSrc.contains("&fallbackurls=http%3A%2F%2Fjackzhang1204.github.io"));
		Assertions.assertTrue(jsSrc.contains("&topbardisplay=disable"));
		Assertions.assertTrue(jsSrc.contains("&claritybutton=enable"));
	}
	
	@Test
	void test_buildUrl_2() throws Exception {
		String sewisePlayerJsUrl = "http://localhost:8080/player/sewise.player.min.js";
		//String videoUrl = "http://jackzhang1204.github.io/materials/mov_bbb.mp4";
		String videoUrl = "http://localhost/shared_files/myvideo1.mp4";
		String fallbackUrls = "http://jackzhang1204.github.io";

		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);
		opts.setVideoUrl(videoUrl);
		//b.setSourceId(null);
		opts.setEnableAutoStart(false);
		opts.setStartTime(0);
		opts.setLang(MySewisePlayerOptions.CONST_LANG_ZH_CN);
		opts.setLogo("http://onvod.sewise.com/libs/swfplayer/skin/images/logo.png");
		opts.setTitle("VodVideo");
		opts.setBuffer(10);
		opts.setSkin(MySewisePlayerOptions.CONST_SKIN_VOD_WHITE);
		opts.setFallbackUrls(fallbackUrls);
		opts.setEnableTopbarDisplay(true);
		opts.setEnableClarityButton(false);
		
		String jsSrc = opts.buildUrl();
		//System.out.println(jsSrc);
		
		Assertions.assertTrue(jsSrc.startsWith("http://localhost:8080/player/sewise.player.min.js?"));
		Assertions.assertTrue(jsSrc.contains("?server=vod&type=mp4"));
		Assertions.assertTrue(jsSrc.contains("&videourl=http%3A%2F%2Flocalhost%2Fshared_files%2Fmyvideo1.mp4"));
		Assertions.assertFalse(jsSrc.contains("&sourceid="));
		Assertions.assertTrue(jsSrc.contains("&autostart=false"));
		Assertions.assertTrue(jsSrc.contains("&starttime=0"));
		Assertions.assertTrue(jsSrc.contains("&lang=zh_CN"));
		Assertions.assertTrue(jsSrc.contains("&logo=http%3A%2F%2Fonvod.sewise.com%2Flibs%2Fswfplayer%2Fskin%2Fimages%2Flogo.png"));
		Assertions.assertTrue(jsSrc.contains("&title=VodVideo"));
		Assertions.assertTrue(jsSrc.contains("&buffer=10"));
		Assertions.assertTrue(jsSrc.contains("&fallbackurls=http%3A%2F%2Fjackzhang1204.github.io"));
		Assertions.assertTrue(jsSrc.contains("&topbardisplay=enable"));
		Assertions.assertTrue(jsSrc.contains("&claritybutton=disable"));
	}
	
	@Test
	void test_buildUrl_min() throws Exception {
		String sewisePlayerJsUrl = "http://localhost:8080/player/sewise.player.min.js";
		String videoUrl = "http://jackzhang1204.github.io/materials/mov_bbb.mp4";

		//minimum setup.
		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setVideoUrl(videoUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);

		String jsSrc = opts.buildUrl();
		//System.out.println(jsSrc);
		
		Assertions.assertTrue(jsSrc.startsWith("http://localhost:8080/player/sewise.player.min.js?"));
		Assertions.assertTrue(jsSrc.contains("?server=vod&type=mp4"));
		Assertions.assertTrue(jsSrc.contains("&videourl=http%3A%2F%2Fjackzhang1204.github.io%2Fmaterials%2Fmov_bbb.mp4"));
		Assertions.assertFalse(jsSrc.contains("&sourceid="));
		Assertions.assertTrue(jsSrc.contains("&autostart=false"));
		Assertions.assertTrue(jsSrc.contains("&starttime=0"));
		Assertions.assertTrue(jsSrc.contains("&lang=en_US"));
		Assertions.assertFalse(jsSrc.contains("&logo="));
		Assertions.assertFalse(jsSrc.contains("&title="));
		Assertions.assertTrue(jsSrc.contains("&buffer=5"));
		Assertions.assertFalse(jsSrc.contains("&fallbackurls="));
		Assertions.assertTrue(jsSrc.contains("&topbardisplay=disable"));
		Assertions.assertTrue(jsSrc.contains("&claritybutton=disable"));
	}
}
