Feature: Verify amazon login

  Scenario Outline: verify user is able to successfully login to amazon with valid credentials
    Given User is on "www.Amazon.co.uk"


    Examples:
    |url|username|password|
    