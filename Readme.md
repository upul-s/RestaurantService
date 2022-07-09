# Restaurant microservices code challenge
We are excited to see that you would love to join our great team and we look forward to getting you on board. However, first we want to get a bit of insight in your skill level so that's why we have created this fun challenge for you. 

## The Problem
We have two standalone services that are not communicating to each other:
- The Restaurant Service which contains some basic information about restaurants on our platform. This service is used by other teams to get restaurant data
- The Restaurant Management Service which is used by our agents to manage restaurant data / state 

These services work independently from one another but we need your help to make them communicate. The Restaurant Service needs to be made aware of status updates from the Restaurant Management Service.

Of course you could implement an API-call but we want a more scalable system so the solution of choice is an event driven ecosystem facilitated for example by Kafka. Kafka is already included in the setup but it is up to you to implement the messages.

## Requirements
- Implement the required user story.
- Implement **one** optional user story. We've got some on our backlog, but you can choose!
- Please use micro-commits and make sure that you include the .git files when you zip everything over to us!
- Please add a few tests in your favorite testing framework

## User stories
At JET we work with user stories to get our work done. That's why we created one for you, including the acceptance criteria.

### Get status updates from the management service (required)
As a restaurant owner I want to get status updates from the management service so my restaurant won't receive orders when we are closed.

**Acceptance criteria**
- The management service creates an event when a status is updated through the api
- The restaurant service consumes the event and updates the status of the restaurant

### Caching system (optional)
As a user I want to be able to see the restaurant list in peak hours with as little delay as possible, so I can quickly find a restaurant and order my food without having to deal with long loading times.

**Acceptance criteria:**
- Implement a service (e.g. redis) that will cache the restaurant list
- The restaurant service uses the cache for displaying restaurants. 
- When an update is made through the restaurant management system, the cache is updated.

### Database (optional)
As a developer I don't want to use the in-memory database for the Restaurant Service because if there is an outage we lose all the data.

**Acceptance criteria:**
- Implement a database of your choice for the Restaurant Service
- The database stores the data emitted from the Restaurant Management Service
- The in-memory 'database' is not used any more.

### Monitoring (optional)
As a developer I want to see the health of our services on a page. The page should let me see which service is healthy and which service are down.
We will put this page on a big TV screen in the office, so we don't need any alerting for now.

**Acceptance criteria:**
- There is a page that shows the health of our Restaurant Management Service and Restaurant Service.

### Your user story (optional)
Don't like what's on our backlog? As the team responsible for our domain, we don't shy away from new improvements or ideas.
If you're up for the task and have an idea that could benefit the team or services, please use this opportunity to write your own user story and implement the improvement.
It can be a code addition, a design or anything else you can think of.

**Acceptance criteria:**
- Your acceptance criteria

## The contents
In the zip-files you will find two java projects containing the Restaurant Management Service and the restaurant service. We prepared the dockerization for you, so no worries there. To get things running you have to do the following:

1. Setup a network called restaurant-services in your Docker environment<br>```docker network create -d bridge restaurant-services```
2. Start the restaurant service from the project root:<br>```docker-compose up```
3. Wait for the restaurant service to run and after that do the same for the Restaurant Management Service

We added Kafka to the docker-compose file of the restaurant service and the management service will create a topic on that instance. You are free to use this or switch it for example to RabbitMQ if that's a better option for you.

## Endpoints
1. Get a list from the restaurant service:<br> ```GET localhost:8081/restaurants/```
2. Update a restaurant status<br>```PUT localhost:8082/restaurant/{id}/status```

The PUT message requires the following payload:
```json
{
  "status": "open" //or closed
}
```

## Good luck
We hope that what we have prepared is useful for you and saves you some time setting everything up. If you want to start from scratch however that's ok for us as well.

We value your personal time so please do not spend more than 4 hours (max!) on this challenge. We are more interested in what you make and how you make it than how much you can make in the given time. We appreciate quality over quantity!

Good luck and we are excited to see what you can do!
