package br.com.jrcsofthouse;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreedingController {
	
	private static final String template = "Hello, %s";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeding")	
	public Greeding greeding(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeding(counter.incrementAndGet(), String.format(template, name));
		
	}

}
