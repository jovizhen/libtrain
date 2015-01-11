package com.gcit.jms;


public class ReadMe
{

	/*
	 * configuration for Spring JMS
	 * 
	 * 	<!-- JMS -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>3.10-FINAL</version>
		</dependency>
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>3.10.1</version>
		</dependency>
		<dependency>
			<groupId>org.apache.activemq</groupId>
			<artifactId>activemq-core</artifactId>
			<version>5.7.0</version>
		</dependency>
		
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.2.2</version>
		</dependency>

		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jms</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
		
		1. download and start activeMQ by open command line at /bin and key in "activemq start"
		
		2.Bean @Bean(name = "jmsConnectionFactory")-->@Bean(name = "jmsTemplate")
		
		3.@Bean(name="publisherQueue") and Queue Listener @Bean(name="publisherMessageListener")
		
		4.Register Listener in Servlet-context.xml
		
		5.See HomeController for using examples 
	 * 
	 */
}
