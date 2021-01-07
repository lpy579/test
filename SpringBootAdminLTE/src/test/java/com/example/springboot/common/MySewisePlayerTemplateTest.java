package com.example.springboot.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit test for MySewisePlayerTemplate.
 * 
 * @author bobyuan
 */
@Tag("junit5")
public class MySewisePlayerTemplateTest {
	private final String sewisePlayerJsUrl = "http://localhost:8080/plugins/sewise-player/player/sewise.player.min.js";
	private final String videoUrl = "http://localhost/shared_files/myvideo1.mp4";

	@Test
	void testGenerateJS() throws Exception {
		// minimum setup.
		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setVideoUrl(videoUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);

		MySewisePlayerTemplate template = new MySewisePlayerTemplate();
		String js = template.generateJS(opts);
		//System.out.println(js);

		Assertions.assertTrue(js.contains("<script type=\"text/javascript\""));
		Assertions.assertTrue(js.contains("server=vod&type=mp4&videourl=http%3A%2F%2Flocalhost%2Fshared_files%2Fmyvideo1.mp4"));
		Assertions.assertTrue(js.contains("</script>"));
	}

	@Test
	void testGenerateHTML() throws Exception {
		// minimum setup.
		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setVideoUrl(videoUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);

		MySewisePlayerTemplate template = new MySewisePlayerTemplate();
		String html = template.generateHTML(opts);
		//System.out.println(html);

		Assertions.assertTrue(html.contains("<html>"));
		Assertions.assertTrue(html.contains("<script type=\"text/javascript\""));
		Assertions.assertTrue(html.contains("server=vod&type=mp4&videourl=http%3A%2F%2Flocalhost%2Fshared_files%2Fmyvideo1.mp4"));
		Assertions.assertTrue(html.contains("</script>"));
		Assertions.assertTrue(html.contains("</html>"));
	}

	@Test
	@Disabled
	void testPreview() {
		try {
			// minimum setup.
			MySewisePlayerOptions opts = new MySewisePlayerOptions();
			opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
			opts.setVideoUrl(videoUrl);
			opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
			opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);

			MySewisePlayerTemplate template = new MySewisePlayerTemplate();
			template.preview(opts);
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail(e.getMessage());
		}
	}
}
