# CompanyOperations_RestWithAngular

## Synopsis

CompanyOperations_RestWithAngular(Github name) is a sample project to demo the usage of spring mvc rest api using angular js. The project provides basic functionalities suc as creating a company, updating a company, getting details of a company  and listing all companies in repository. Angular js is used as main scripting framework and bootstrap css is used for styling. Onserver side, spring rest is used for exposing the functionalities. A simple in memory list with single intance is being used as repository for all company related operations.

## Usage

There are various operations supported by this app

### Getting details of a company using companyId
 eg; curl -X GET "https://companyoperations.herokuapp.com/getCompanyDetails/{companyId}"
 curl -X GET "https://companyoperations.herokuapp.com/getCompanyDetails/1"
 
### Getting details of all the registered companies
 eg; curl -X GET "https://companyoperations.herokuapp.com/getAllCompanies"

### Registering/Updatin/Adding a beneficial owner 
eg; curl -H "Content-Type: application/json" -X POST -d '{"companyId":"2","companyName":"2","address":"2","city":"2","country":"India","email":"b@b.com","phoneNumber":"1234567899","beneficialOwners":["owner1"]}' "https://companyoperations.herokuapp.com/addCompany"

## Contributors

Shashank Pandey (shasha.libra@gmail.com)
