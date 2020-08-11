Meta:
@feature itvdn_site
@tag site

Narrative:
  As a person
  I want to subscrube to itvdn mailing
  So that I can get news

Scenario: Search
Meta: @smoke
Given Customer open site
When Customer perform search with 'QA'
Then Customer see results


Scenario: Subscribe
Given Customer open site
When Customer subscribes to mailing with 'luckyguy@gmail.com'
Then Customer see success notification


Scenario: Customer cannot subscribe with invalid email format
Given Customer open site
When Customer subscribes to mailing with '<email>'
Then Customer see fail notification

Examples:
| email          |
| luckyguy@gmail |
| @gmail.com     |


Scenario: Customer can open any video course
Meta: @run
Given Customer open 'java-starter' video course