<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Company Operations</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="resources/js/companyOperations.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
	
	<div class="container" ng-app="companyOperationsApp" ng-controller="companyOperationsController">
		<div class="alert alert-success" role="alert">
			<h1 align="center">{{message}}</h1>
		</div>
		<div>
			<h3>
				<span class="label label-default">Available functions</span>
				<input type="button" class="btn btn-success" value="Add Company" ng-click="setOperationName('addCompany')">
				<input type="button" class="btn btn-success" ng-click="setOperationName('getAllCompanies');getAllCompanies()" value="Get all companies">
				<input type="button" class="btn btn-success" ng-click="setOperationName('getCompanyDetails')" value="Get company details">
				<input type="submit" class="btn btn-success" ng-click="setOperationName('addBeneficialOwners');updateBeneficialOwners()" value="Add beneficial owners">
			</h3>
		</div>
		<div class="form-horizontal">
	        <div class="form-group" ng-show="operation=='getCompanyDetails' || operation=='updateCompany' || operation=='addBeneficialOwners'">
		        <div class="col-sm-10">
			    	<input class="form-control" type="text" name="companyId" id="companyId" ng-model="companyId" placeholder="Enter Company Id" />
			    </div>
			    <input type="button" class="col-sm-2 btn btn-success" ng-click="getCompanyDetails()" value="Get details" />			    
			</div>
		</div>
		<div id="addCompanyDiv" ng-show="showCompanyDiv">
			<div class="col-md-6 col-md-offset-3">
    			<h2>Company</h2>
			    <form name="form" role="form">
			        <div class="form-group">
			            <label for="username">Company Id</label>
			            <input type="text" name="companyId" id="companyId" class="form-control" ng-model="company.companyId" ng-disabled="operation=='addBeneficialOwners'" required />
			            
			            <label for="username">Company Name</label>
			            <input type="text" name="companyName" id="companyName" class="form-control" ng-model="company.companyName" ng-disabled="operation =='addBeneficialOwners'" required />
			        
			            <label>Address</label>
			            <input type="text" name="address" id="address" class="form-control" ng-model="company.address" ng-disabled="operation =='addBeneficialOwners'" required />
			        
			            <label>City</label>
			            <input type="text" name="city" id="city" class="form-control" ng-model="company.city" ng-disabled="operation =='addBeneficialOwners'" required />
			        
			            <label>Country</label>
			            <input type="text" name="country" id="coountry" class="form-control" ng-model="company.country" ng-disabled="operation =='addBeneficialOwners'" required />
			        
			            <label>Email</label>
			            <input type="email" name="email" id="email" class="form-control" ng-model="company.email" ng-disabled="operation =='addBeneficialOwners'" />
			        	<span style="color: red" class="error-message" ng-show="form.email.$dirty && form.email.$invalid">Please enter email in correct format</span><br/>
			        
			            <label>Phone Number</label>
			            <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" ng-model="company.phoneNumber" ng-maxlength="10" ng-minlength="10" ng-pattern="/^\d{10}$/" ng-disabled="operation =='addBeneficialOwners'" />
			        	<span style="color: red" class="error-message" ng-show="form.phoneNumber.$dirty && form.phoneNumber.$invalid">Please enter phone number in correct format</span><br/>

			            <label>Beneficial Owners</label>
			            <div class="form-horizontal" ng-repeat="owner in beneficialOwnersList">
			            	<div class="form-group">
			            		<div class="col-sm-11">
			            			<input type="text" class="form-control" ng-model="owner"/>
			            		</div>
								<button class="btn btn-danger col-sm-1" ng-click="removeOwner($index)" aria-label="Remove">x</button>
			            	</div>
			            </div>
			            <div class="form-horizontal">
			            	<div class="form-group">
				            	<div class="col-sm-11">
				            		<input type="text" class="form-control" name="beneficialOwner" placeholder="Add owner here and click on add button" ng-model="beneficialOwner"/>
				            	</div>
				            	<button class="btn btn-success col-sm-1" ng-click="addNewOwner()" aria-label="Add">+</button>
				            </div>
			            </div>
			        </div>
			        <div>
			            <button type="submit" ng-disabled="form.$invalid" ng-click="register()" class="btn btn-primary" ng-hide="operation != 'addCompany'">Submit</button>
			            <input type="submit" ng-disabled="form.$invalid" class="btn btn-success" ng-click="setOperationName('updateCompany');updateCompanyDetails()" ng-hide="operation == 'addCompany'" value="Update">
			        </div>
			    </form>
			</div>
		</div>
		<div id="companyListDiv" ng-show="companyList">
			<table class="table table-striped table-bordered">
				<thead>
					<th>Company ID</th>
					<th>Company Name</th>
					<th>Address</th>
					<th>City</th>
					<th>Country</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Beneficial Owners</th>
				</thead>
				<tr ng-repeat="company in companyList">
					<td>{{company.companyId}}</td>
					<td>{{company.companyName}}</td>
					<td>{{company.address}}</td>
					<td>{{company.city}}</td>
					<td>{{company.country}}</td>
					<td>{{company.email}}</td>
					<td>{{company.phoneNumber}}</td>
					<td>{{company.beneficialOwners}}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
