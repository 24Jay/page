package edu.zju.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer
{
	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
		System.out.println(".................................Hello ....................");
		System.out.println(".................................Spring ....................");
		LOGGER.debug("Here is a bug for u*************************************************");
		LOGGER.info("Here is a info for u*************************************************");
	}

	/**
	 * 设置tomcat端口
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container)
	{
		container.setPort(8080);
	}
	
}