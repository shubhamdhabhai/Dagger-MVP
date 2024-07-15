# Dagger-MVP
This is sample to show how dagger works with MVP architecture.  

## Overview
This sample uses two api sources one is [Github repo list](https://developer.github.com/v3/repos/#list-user-repositories) for a particular user.
Another is [List of jobs](https://github.com/workforce-data-initiative/skills-api/wiki/API-Overview). These are open apis so we do not need authentication for this.
On the home screen there are two buttons, **Get Github Repo List** takes us to the screen to get public repo list of the username we enter.
and **Get job list** takes us to the screen where on clicking **Get Jobs** it fetches the list of jobs.

## Under the hood
This sample shows how we can use dagger to remove dependencies from presenter so that we can write test cases by mocking api services or other dependencies that are required. This also shows how **Dependent Components** works with different scopes.
There are 5 scopes with dependency shown in the diagram.  

                                      
![Alt text](/dagger_diagram.png)

I have explained everything in detail [here](https://shubhamdhabhai.github.io/2018/01/24/Understanding-Dagger.html)

## Usefull reads
Here are some nice articles to refer.  
 [A superb sample covering real world scenerio](https://github.com/abhishekBansal/android-mvp-retrofit2-dagger2-rxjava2-testing).  
 [Dependency Injection with Dagger 2](https://guides.codepath.com/android/dependency-injection-with-dagger-2).  
 [An  Introduction to Dagger 2](https://dzone.com/articles/an-introduction-to-dagger-2-android-di-part-1-3).  
 [Dagger 2. Part II. Custom scopes, Component dependencies, Subcomponents](https://proandroiddev.com/dagger-2-part-ii-custom-scopes-component-dependencies-subcomponents-697c1fa1cfc).  
