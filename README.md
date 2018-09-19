# springboot-activeMq
springboot整合activeMq
1、在springboot的官网拿到工程，并且导入activeMq的依赖

2、application.properties文件
 spring.activemq.broker-url=tcp://192.168.66.43:61616 
spring.activemq.in-memory=true
spring.activemq.pool.enabled=false  
(如果 spring.activemq.pool.enabled=true,那么需要加入activemq连接池的依赖：
<dependency>
			<groupId>org.apache.activemq</groupId>
			<artifactId>activemq-pool</artifactId>
			<!-- <version>5.7.0</version> -->
		</dependency>
）
3、producer的写法
   使用JmsMessagingTemplate的convertAndSend(destination,message)方法，将信息发送到activeMq的服务器

4、consumer写法
   使用@JmsListener(destination=”在producer中传过来的dstination值”)

5、测试（使用springboot的测试）

6、犯过的一个错误
测试的时候，未在testActivemq方法上面加一个@Test注解，导致出现错误：
在springboot使用test测试。如果在方法上没有加@Test注解，就会出现这样的错误：java.lang.Exception: No runnable methods
	at org.junit.runners.BlockJUnit4ClassRunner.validateInstanceMethods(BlockJUnit4ClassRunner.java:191)
	at org.junit.runners.BlockJUnit4ClassRunner.collectInitializationErrors(BlockJUnit4ClassRunner.java:128)
	at org.junit.runners.ParentRunner.validate(ParentRunner.java:416)
	at org.junit.runners.ParentRunner.<init>(ParentRunner.java:84)
	at org.junit.runners.BlockJUnit4ClassRunner.<init>(BlockJUnit4ClassRunner.java:65)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.<init>(SpringJUnit4ClassRunner.java:137)
	at org.springframework.test.context.junit4.SpringRunner.<init>(SpringRunner.java:49)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at org.junit.internal.builders.AnnotatedBuilder.buildRunner(AnnotatedBuilder.java:104)
	at org.junit.internal.builders.AnnotatedBuilder.runnerForClass(AnnotatedBuilder.java:86)
	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
	at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:26)
	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
	at org.junit.internal.requests.ClassRequest.getRunner(ClassRequest.java:33)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.createUnfilteredTest(JUnit4TestLoader.java:87)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.createTest(JUnit4TestLoader.java:73)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.loadTests(JUnit4TestLoader.java:46)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:522)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)



