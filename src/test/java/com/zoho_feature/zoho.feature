@zoho
Feature: BUSINESS APPLICTION
@login
Scenario Outline:
Given user get into Home Page
When user click on Signup button
Then user fill details "<Name>" "<Email>" "<Password>" "<Phone Number>" the Signup page

Examples:
|Name|Email|Password|Phone Number|
|Anandraj|anandraj123@mail.com|54321|9876543210|
|Raj|Raj123@gamil.com|0459847|123345778909|
