# WeatherApp
## Overview
* [About](#general-info)
* [Technologies](#technologies)
* [Properties](#properties)
* [Setup](#setup)
* [How it works](#how-it-works)

## About

This application shows the weather for 5 days based on the city that the user enters in the frontend.
Unfortunately, the API I am using occasionally returns coordinates for cities that do not exist. I will change the server in the future.

## Technologies
* Java 17
* Spring Boot 2.7
* Thymeleaf
* Maven
* RestClient

## Properties:
apiKey=your_api_key (paste form api.opencagedata.com)

## Setup
How to run ?
To run need ApiKey form api.opencagedata.com (it's a service name) Need only to create account and generate ApiKey(free to 2000 request). 

With set properties, just run app.

## How it works
1. When you run this program, you will show Poland and Warsaw because this is the default city.

![img_1.png](img_1.png)

2. You can change the city and country by entering the name of the city and country in the form and clicking the "Check" button.

![img_2.png](img_2.png)

3. You have information about the weather for each bigger city on the world.

![img_3.png](img_3.png)
4. Check the weather for the next 5 days; we have information about temperature, wind and precipitation. 



That's all. Thanks for your attention.