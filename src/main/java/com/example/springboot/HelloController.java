package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Hashtable;
import java.util.UUID;

@RestController
public class HelloController {

	private Map<UUID, String> apps = new Hashtable<>();

	@RequestMapping("/")
	public String index() {
		return "Apps registry version 2.0 Committed but not deployed from MBP";
	}

	@PostMapping("/apps")
	@ResponseBody
	public String postApps(@RequestParam UUID id, @RequestParam String title) {
		apps.put(id, title);
		return String.format("The app with id %s and title %s is added", id, title);
	}

	@GetMapping("/apps")
	@ResponseBody
	public String getApps(){
		StringBuffer sb = new StringBuffer().append("This is our apps: \n");
		for (Map.Entry<UUID,String> entry : apps.entrySet()) {
			sb.append(entry.getKey() + " : " + entry.getValue()).append("\n"); 
			
		}

		return sb.toString();
	}


	@RequestMapping("/anna")
	public String anna() {
		return "Anna!!!";
	}

}