/**
 * 
 */

var app = angular.module("myFriendsApp", []);


app.controller("myFriendsController", function($scope, $http) {
	
	$scope.resource = '/AngularRestfulWebServiceExample/aca/friends/';
	$scope.defaultImage = 'https://thumb7.shutterstock.com/display_pic_with_logo/957031/195921401/stock-vector-two-people-icon-195921401.jpg';
	$scope.useDefaultImage = false;

	$scope.getFriend = function(id) {
		var response = $http.get($scope.resource + id );
		response.success(function(data) {
			console.log("getFriend data: " + angular.toJson(data, false));

			$scope.friend = data;
			$scope.operation="update";
			$scope.isSaveDisabled = false;
			$scope.isDeleteDisabled = false;
			$scope.searchLastName = '';	
			$scope.useDefaultImage = false;
			//$scope.idReadOnly = true;
		});

		response.error(function(data, status, headers, config) {
			alert("AJAX failed to get data, status=" + status);
		});
	};

	$scope.searchFriend = function(lastName) {
		$scope.navTitle = 'Search Results';

		//alert("search for friend by last name: " + lastName);

		var response = $http.get($scope.resource + 'lastname/' + lastName);
		response.success(function(data) {
			$scope.friends = data;
			$scope.clearForm();
//			$scope.$apply();

//			console.log("[searchFriend] # of items: " + data.length);
//			angular.forEach(data, function(element) {
//			console.log("[searchFriend] friend: " + element.lastName);
//			});

		});

		response.error(function(data, status, headers, config) {
			alert("AJAX failed to get data, status=" + status);
		});
	};

	$scope.clearForm = function() {
		$scope.friend = {
				id:'',
				firstName:'',
				lastName:'',				
				image:''				
		};
		$scope.useDefaultImage = true;
	};

	$scope.addNew = function(element) {
		$scope.operation="create";
		$scope.clearForm();
		main.id.focus();
		$scope.isSaveDisabled = false;
		$scope.isDeleteDisabled = true;
	};

	$scope.saveFriend = function(id) {
		$scope.jsonObj = angular.toJson($scope.friend, false);
		console.log("[update] data: " + $scope.jsonObj);

		if ($scope.operation == "update") {
			var response = $http.put($scope.resource + id, $scope.jsonObj);
			response.success(function(data, status) {
				console.log("Inside update operation..." + angular.toJson(data, false) + ", status=" + status);
				$scope.resetSearch();
			});

			response.error(function(data, status) {
				alert("AJAX failed to get data, status=" + status);
			});
		} else if ($scope.operation == "create") {
			var response = $http.post($scope.resource, $scope.jsonObj);
			response.success(function(data, status) {
				console.log("Inside create operation..." + angular.toJson(data, false) + ", status=" + status);
				$scope.resetSearch();
			});

			response.error(function(data, status) {
				alert("AJAX failed to get data, status=" + status, scope);
			});
		}
	};

	$scope.deleteFriend = function(id) {						
		var response = $http.delete('$scope.resource' + id);		

		response.success(function(data) {				
			$scope.resetSearch();			
		});

		response.error(function(data, status) {
			alert("AJAX failed to get data, status=" + status);
			$scope.resetSearch();
		});
	};

	$scope.resetSearch = function() {			
		$scope.operation="";
		$scope.clearForm();
		$scope.isSaveDisabled = true;
		$scope.isDeleteDisabled = true;
		$scope.navTitle = 'My Friends';
		$scope.searchLastName = '';			

		var response = $http.get($scope.resource);
		response.success(function(data) {
			$scope.friends = data;		
			console.log("retrieved friends");
		});

		response.error(function(data, status, headers, config) {
			alert("AJAX failed to get data, status=" + status);
		});
	};
	
	$scope.resetSearch();
	
});	
