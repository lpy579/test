package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.common.MySewisePlayerOptions;
import com.example.springboot.common.MySewisePlayerTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/examples/others")
public class OthersController {
	private String WEBAPP_ROOT_URL = getWebAppRootUrl();
	
    @GetMapping
    public String index() {
        return "redirect:/examples/others/sewiseplayer";
    }
    
	private String getWebAppRootUrl() {
		String rootUrl = "http://localhost:8080";
		return rootUrl;
	}

	@GetMapping("/sewiseplayer")
	public String sewisePlayerExample(Model model) throws JsonProcessingException {
		String sewisePlayerJsUrl = WEBAPP_ROOT_URL + "/plugins/sewise-player/player/sewise.player.min.js";
		//String videoUrl = "http://jackzhang1204.github.io/materials/mov_bbb.mp4";
		String videoUrl = WEBAPP_ROOT_URL + "/myfiles/mov_bbb.mp4";
		
		MySewisePlayerOptions opts = new MySewisePlayerOptions();
		opts.setSewisePlayerJsUrl(sewisePlayerJsUrl);
		opts.setServerType(MySewisePlayerOptions.CONST_SERVER_VOD);
		opts.setVideoType(MySewisePlayerOptions.CONST_VIDEO_TYPE_MP4);
		opts.setVideoUrl(videoUrl);
		opts.setEnableAutoStart(true);
		opts.setLang(MySewisePlayerOptions.CONST_LANG_ZH_CN);
		
		MySewisePlayerTemplate template = new MySewisePlayerTemplate();
		String sewisePlayerJs = template.generateJS(opts);
		
		model.addAttribute("sewisePlayerJs", sewisePlayerJs);
		return "examples/others/sewiseplayer";
	}

}
