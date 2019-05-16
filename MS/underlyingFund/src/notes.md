### Order of execution:
1. Eureka
2. cloud Config
3. Zuul gateway
4. ms1, ms2, ms3

## STEP 30
### API gateway

Service typically in a micro services architecture you'd have 100 of my services that are talking to each other and there are common features that we would need to implement for all these micro services. 
- You would want to make sure that every call to every micro service is authenticated.
- You also want to implement things like rate limit for a specific client.
- you'd want all these micro services to be fault tolerant if there is a service that I am depended on and it's not up I should be able to give some default response back 
- and in a typical micro service environment they should also be some kind of service aggregation that should be provided.

So these are kinds of features that are common across all the micro services and these are features

the API gateway would take care of providing common features like authentication making sure that all service calls are logged.

### Implement a simple API gateway using Zuul

---

# STEP 35
### Distributed tracing.

Let's say there is a small defect.
This service is not really working fine and you would want to debug it.

How do you do that.

We'll look at the look at the currency calculation service do we look at the currency exchange service or

We'll look at the API gateway.

How do you find out where the defect is and how do I know what is happening in total with that specific request.

One of the most important things with implementing a micro services architecture is we would need

to have something called distributed tracing.

I would want one place where I can go and see what happened with a specific request.

I would want to have one single centralized location where I can see the complete chain of what happened with a specific request.

This is especially important because there are variety of components that are involved.

When we talk about the typical micro service architecture until now we looked at that different.micro services we talked about API gateways we talked about naming server we talked about configuration server.

I want n number of components are involved.

If you want to solve a problem and if you want to debug a problem through this you would need a centralized kind of information.

And that's where this distributed tracing comes into picture.


###  Spring cloud sleuth with Zipkin

> 1.1. Zipkin

There are a variety of options that are present for distributed tracing.

What we'll do in this section is to use something called Spring cloud sleuth with Zipkin

One of the important things is to assign a unique ID to a request.

So let's say a request is going through a set of application components.

It's going through the API gateway to the currency calculation service.

Are going through the API gateway and the currency exchange service how do I identify that this request is the same one.
the only way I can identify that is by assigning ID to this request and that's what spring cloud sleuth. spring cloud sleuth would assign a unique ID to a request so that I can trace it across.

> 1.2. zipkin 

Components zipkin is what we call a distributed tracing system.

What we would do is all the log from all these services we would put it in MQ.( we would use rabbitMQ.)

And we would send it out to the zipkin server where it is consolidated.

And we would be able to look through the different requests and find what happened with the specific request.

Don't worry this sounds complex in the next steps we would start with implementing spring cloud sleuth and after that we would start implementing zipkin

---

# ms > rabbitMQ > ZipkinTacingServer(springBoot project)
- Can create ZipkinTacingServer(springBoot project) after SB 2.0
1. Start Rabbit MQ

> /usr/local/sbin/rabbitmq-server

2. download Zipkin jar and run it along with rabbit MQ

>  RABBIT_URI=amqp://localhost java -jar zipkin-server-2.12.9-exec.jar

>  RABBIT_URI=amqo://localhost java -jar ./Documents/Github/zipkin-server-2.12.9-exec.jar

3. Add dependencies in ms/s:

```
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
		</dependency>
```

4. launch : 
- http://localhost:9411/zipkin/
- http://localhost:8761/ - eureka

5. side notes - unix commands

> lsof -n | grep LISTEN
> lsof -n -i4TCP:[PORT] | grep LISTEN | awk '{ print $2 }' | xargs kill





