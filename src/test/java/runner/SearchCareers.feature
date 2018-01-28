Feature: Search Avanade careers
	The purpose of this feature is to test possibility of searching job offers on Avanade website according to requirements

Scenario: User opens Avanade website and look for job offers according to his requirements

	Given User opens Avanade website	
	And User navigate to the /CAREERS/ and opens /ROLES AND LOCATIONS/		
	When User chooses /All Locations/ from /Countries/ drop-down menu	
	And User clicks on /Search/ button	
	And User enters /Krakow/ in /SearchBox/ field
	Then User checks if there is more than /5/ results for location Krakow 
	And User enters /Warsaw/ in /SearchBox/ field
	Then User checks if there is at least /1/ result for location Warsaw 
	And User enters sentence: /entry level/ in /SearchBox/ field 
	And User checks if on of results is position /Entry Level Software Engineer, Seattle/
	Then User open job offer and checks if one of the qualifications is /Strong time management skills/
	
	

	
