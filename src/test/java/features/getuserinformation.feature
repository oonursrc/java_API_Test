Feature: Query User Information


    Scenario Outline: Verify user information query API functionality
        Given Query User Information is going to be executed
        When Query User Information API executed with <username>
        Then Query operation for <username> is successful and response code is 200
        Examples:
        |username|
        |admin|
        |dev  |