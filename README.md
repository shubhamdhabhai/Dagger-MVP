# Dagger-MVP
This is sample to show how dagger works with MVP architecture.  

## Overview
This sample uses two api sources one is [Github repo list](https://developer.github.com/v3/repos/#list-user-repositories) for a particular user.
Another is [List of jobs] (https://github.com/workforce-data-initiative/skills-api/wiki/API-Overview). These are open apis so we do not need authentication for this.
On the home screen there are two buttons, **Get Github Repo List** takes us to the screen to get public repo list of the username we enter.
and **Get job list** takes us to the screen where on clicking **Get Jobs** it fetches the list of jobs.

## In depth implementation
This sample shows how we can use dagger to remove dependencies from presenter so that we can write test cases by mocking api services or other dependencies that are required. This also shows how **Dependent Components** works with different scopes.
There are 5 scopes.
