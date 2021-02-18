@tag
Feature: To validate the login page
Background: 
Given url should be open

@loginandComposemail
Scenario: validate login with id
When Enter valid name "disharoy1"
And Enter valid password "xyz123"
And click on login button
Then login success "disha roy"

#Scenario: this is to compose a mail
When Click on the compose button
When Enter mail id 
When Enter subject
When Enter the message 
When Click on the send button
Then Message sent successfully

