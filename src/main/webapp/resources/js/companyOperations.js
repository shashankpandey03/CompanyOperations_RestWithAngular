angular.module('companyOperationsApp', []);

angular.module('companyOperationsApp').controller('companyOperationsController', function ($scope, $http, $window) {

	$scope.message = null;
	$scope.company = {};
	$scope.companyList = null;
	$scope.companyId;
	$scope.operation = {};
	$scope.beneficialOwners = [];
	$scope.baseURL = '';
	$scope.showCompanyDiv = false;
	$scope.beneficialOwner = null;
	
	$scope.addNewOwner = function () {
		$scope.beneficialOwnersList.push($scope.beneficialOwner);
		$scope.beneficialOwner = null;
	};
	
	$scope.removeOwner = function (index) {
		$scope.beneficialOwnersList.splice(index, 1);
	};
	
	
	$scope.setOperationName = function(operationName) {
		$scope.operation = operationName;
		$scope.beneficialOwner = null;
		$scope.message = null;
		
		if($scope.operation == 'addCompany') {
			$scope.company = {};
			$scope.beneficialOwnersList = [];
			$scope.companyList = null;
			$scope.showCompanyDiv = true;
		} else if($scope.operation == 'getAllCompanies') {
			$scope.showCompanyDiv = false;
		} else if ($scope.operation =='getCompanyDetails' || $scope.operation=='updateCompany' || $scope.operation =='addBeneficialOwners') {
			if($scope.operation !='updateCompany') {
				$scope.beneficialOwnersList = [];
			}
			$scope.companyList = null;
			$scope.showCompanyDiv = false;
		}
	};
	
	$scope.register = function() {
		var url = $scope.baseURL + $scope.operation;
		
		$scope.company.beneficialOwners = $scope.beneficialOwnersList;
		
		var responsePromise = postData(url,$scope.company);
		responsePromise.success(function(data, status, headers, config) {
			$scope.message = data.statusMessage;
			$window.scrollTo(0, 0);
		});
		responsePromise.error(function(data, status, headers, config) {
			$scope.message = "Operation unsuccessful!";
			$window.scrollTo(0, 0);
	    });
	};
	
	$scope.getAllCompanies = function() {
		var responsePromise = $http.get($scope.baseURL + $scope.operation);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.message = data.statusMessage;
	    	$scope.companyList = data.data;
	    	$window.scrollTo(0, 0);
	    });
	    responsePromise.error(function(data, status, headers, config) {
	    	$scope.message = "Operation unsuccessful!";
	    	$window.scrollTo(0, 0);
	    });
	};
	
	$scope.getCompanyDetails = function() {
		
		var url = $scope.baseURL + 'getCompanyDetails' + '/' + $scope.companyId;
		var responsePromise = $http.get(url);
	    responsePromise.success(function(data, status, headers, config) {
	    	if(data.statusCode == 200) {
		    	$scope.company = data.data;
		    	$scope.beneficialOwnersList = $scope.company.beneficialOwners;
		    	
		    	if($scope.operation=='getCompanyDetails' || $scope.operation=='updateCompany' || $scope.operation=='addBeneficialOwners') {
					$scope.showCompanyDiv = true;
				}
	    	} else {
	    		$scope.showCompanyDiv = false;
	    	}
    		$scope.message = data.statusMessage;
    		$window.scrollTo(0, 0);
	    });
	    responsePromise.error(function(data, status, headers, config) {
	    	$scope.message = "Operation unsuccessful!";
			$scope.showCompanyDiv = false;
			$window.scrollTo(0, 0);
	    });
	};
	
	$scope.updateCompanyDetails = function() {
		//$scope.operation = '';
		var url = $scope.baseURL + $scope.operation + '/' + $scope.companyId;
		
		$scope.company.beneficialOwners = $scope.beneficialOwnersList;
		
		var responsePromise = postData(url,$scope.company);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.company = data.data;
	    	$scope.message = data.statusMessage;
	    	$window.scrollTo(0, 0);
	    });
	    responsePromise.error(function(data, status, headers, config) {
	    	$scope.message = "Operation unsuccessful!";
	    	$window.scrollTo(0, 0);
	    });
	};

	function postData(url,data) {
		
		var response = $http({
						url: url, 
						method: "POST",
						data: angular.toJson(data),
						headers: {'Content-Type': 'application/json'}
					});
		return response;
	}
	
});
