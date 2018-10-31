Feature: searching for airline tickets and comparing prices 

Scenario Outline:
User is able to search for tickets from United airlines and American airlines and compare prices 

	Given  user is at united airlines homepage "<homepage1>" 
	When  user selects "oneway" 
	And  user enters location "from" "<from>" 
	And user selects "phl" 
	And user enters location "to" "<to>" 
	And user selects "iad" 
	And user selects "date" 
	And user enters "depdate" 
	And user selects "travelers" 
	And user selects "addtravelers" 
	And user clicks "closetravelers" 
	And user clicks "findflight" 
	And user waits 5 seconds 
	And user is on the search result page
	And user prints the results
	And user navigates to "<homepage2>" 
	And user selects "one-way" 
	And user clears "fromaa" 
	And user enters location "fromaa" "<from>" 
	And user enters key down to select PHL at "fromaa" 
	And user enters location "toaa" "<to>" 
	And user enters key down to select IAD at "toaa" 
	And user selects 2 "passengers" 
	And user selects "aadate" 
	And user selects "aadepdate" 
	And user selects "search" 
	And user is on the search result page
	Then user compares prices between both airlines
	
	
	
	
	
	Examples: 
		|from				|to					|homepage1						|homepage2						|
		|phl				|iad				|https://www.united.com/en/us/	|https://www.aa.com/homePage.do	|
		
		
		
		
		
