# Overview

This software system is designed to assist travel agencies in managing travel packages, itineraries (destinations), and passengers. It incorporates various design patterns to ensure flexibility, scalability, and maintainability.

The design patterns used here are: 
### 1. Composite Pattern

The composite pattern is utilized to represent travel packages, destinations, and activities as hierarchical structures.

### 2. Strategy Pattern

The strategy pattern is employed to dynamically change the cost calculation strategy for passengers based on their type.

### 3. Builder Pattern

The builder pattern is used for constructing complex objects, - travel package and especially passengers.

## Functionality 

```

//        1. Print itinerary of the travel package including:
//                1. travel package name,
//                2. destinations and details of the activities available at each destination, like name, cost, capacity and description.
        travelPackage1.display();

//        2. Print the passenger list of the travel package including:
//              1. package name,
//              2. passenger capacity,
//              3. number of passengers currently enrolled and
//              4. name and number of each passenger
        travelPackage1.displayPassengerDetails();

//        3. Print the details of an individual passenger including their
    //        1. name,
    //        2. passenger number,
    //        3. balance (if applicable),
    //        4. list of each activity they have signed up for, including the destination the at which the activity is taking place and the price the passenger paid for the activity.
        travelPackage1.getPassengers().get(0).displayInfo();


//        4. Print the details of all the activities that still have spaces available, including how many spaces are available.
        travelPackage1.displayAvailableActivities();

```


## High Level Diagram
![image](https://github.com/Just-A-Pixel/Travel-Manager/assets/58350132/6ba66895-dfc7-4f73-917a-24e0e761e599)

## Low Level Diagram

![image](https://github.com/Just-A-Pixel/Travel-Manager/assets/58350132/79560ccd-7902-4882-812f-abab663e4b49)

