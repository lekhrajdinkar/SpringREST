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

