package edu.zju.page;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.zju.page.db.DatabaseHelper;

@RestController
public class GreetingController
{

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/data")
	public List<Singer> data()
	{
		return DatabaseHelper.querySingers();
	}

	@RequestMapping(value = "/dsuncat", method = RequestMethod.POST)
	public String love(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return "Welcome," + name + " You are the [ " + counter.incrementAndGet()
				+ " ] one to be here, thanks for your support!";
	}
}