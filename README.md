Proposal for a Java-based client for the Maconomy 2.x REST API.

TODO: (in no particular order)

* Handle template-links
* Support different Maconomy data types: String, Boolean, Integer, Real, Popup, Time, Data, TimeDuration, Amount
* Set format header appropriately. Necessary for prints and certain other actions
* Set language header appropriately
* Move authentication to request/response filter
* Support login with domain credentials
* Implement navigation strategy for singleton containers
* Handle file up- and download as well as prints
* Handle batch import actions
* Support foreign-key searches
* Implement Performance logger using a request/response filter
* Implement filtering, sorting and field selection for filter queries
* Code generator for typed API, input from either xml files or specification webservice
* Guide on how to use this codebase in integrations, stand-alone tools etc (packaging)
* Unit test with typed API, e.g. JobBudgetTable rather than simply Table
* Support the environment web service
* Provide list of standard, common containers from Maconomy