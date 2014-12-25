var libraryModule = angular.module('libraryApp', [ 'ngRoute', 'ngCookies' ]);

var restUrl = 'http://localhost:8080/lib/';

libraryModule.config([ "$routeProvider", function($routeProvider) {
	return $routeProvider.when("/", {
		redirectTo : "/home"
	}).when("/home", {
		templateUrl : "home.html"
	}).when("/manageAuthors", {
		templateUrl : "manageAuthors.html"
	}).when("/test", {
		templateUrl : "test.html"
	}).when("/managePublisher", {
		templateUrl: "managePublisher.html"
	}).when("/manageBook", {
		templateUrl: "manageBook.html"
	}).when("/manageGenre", {
		templateUrl: "manageGenre.html"
	}).when("/bookSearch", {
		templateUrl: "searchBook.html"
	})
} ]);

libraryModule.controller('authorsCtrl', function($scope, $http, $cookieStore) {
	
	$http.get(restUrl + 'showAuthorListRest').success(function(data) {
		$scope.authors = data;
	});
	
	$scope.addAuthor = function() {
		if($scope.addAuthorFrm.$valid) {
		 $http.post(restUrl + 'addAuthorAction/' +$scope.authorName).
		  success(function(data) {
				$http.get(restUrl + 'showAuthorListRest').success(function(data) {
					$scope.authors = data;
					$scope.authorName="";
				});
		    });
		}
	};
	
	$scope.showUpdateModal = function(authId, oldAuthName) {
		$scope.oldAuthName = oldAuthName;
		$scope.authId = authId;
		$('#updateAuthorModal').modal('show');
	};

	$scope.deleteAuthor = function(authId) {
		$http.get(restUrl + 'deleteAuthorRest/'+authId).success(function(data) {
			$http.get(restUrl + 'showAuthorListRest').success(function(data) {
				$scope.authors = data;
			});
		});
	}
	
	$scope.updateAuthor = function()
	{
		$http.get(restUrl + 'updateAuthorRest/'+ $scope.authId+'/'+$scope.authorNameUpdate).success(function(data){
			$http.get(restUrl + 'showAuthorListRest').success(function(data) {
				$scope.authors = data;
			});
			$('#updateAuthorModal').modal('hide');
			$scope.authId="";
			$scope.authorNameUpdate="";
		});
	}
});

libraryModule.controller('publisherCtrl' ,  function($scope, $http, $cookieStore){
	$http.get(restUrl + 'showPublisherListRest').success(function(data) {
		$scope.publishers = data;
	});
	
	$scope.addPublisher = function() {
		if($scope.addPubForm.$valid) {
		 $http.post(restUrl + 'addPublisherAction/' +$scope.pubName+'/'+$scope.pubAddress+'/'+$scope.pubPhone).
		  success(function(data) {
				$http.get(restUrl + 'showPublisherListRest').success(function(data) {
					$scope.publishers = data;
					$scope.pubName="";
					$scope.pubAddress="";
					$scope.pubPhone="";
				});
		    });
		}
	};
	
	$scope.deletePublisher = function(pubId){
		$http.get(restUrl+'deletePublisherRest/'+pubId).success(function(data){
			$http.get(restUrl+'showPublisherListRest').success(function(data){
				$scope.publishers = data;
			});
		});
	};
	
	$scope.showPublisherModal = function(pubId, pubName, pubAddress, pubPhone){
		$scope.pubId = pubId;
		$scope.oldPubName = pubName;
		$scope.oldPubAddress = pubAddress;
		$scope.oldPubPhone = pubPhone;
		$('#updatePublisherModal').modal('show');
	};
	
	$scope.updatePublisher = function()
	{
		$http.get(restUrl + 'updatePublisherRest/'+ $scope.pubId+'/'+$scope.pubNameUpdate+'/'+$scope.pubAddressUpdate+'/'+$scope.pubPhoneUpdate)
		.success(function(data){
			$http.get(restUrl + 'showPublisherListRest').success(function(data) {
				$scope.publishers = data;
			});
			$('#updatePublisherModal').modal('hide');
		});
	}
});

libraryModule.controller('branchController', function($scope, $http){
	$http.get(restUrl + 'showBranchListRest').success(function(data){
		$scope.branches = data;
	});
	
	$scope.showBranchModal = function(branchId, branchName, branchAddress){
		$scope.branchId = branchId;
		$scope.oldName = branchName;
		$scope.oldAddress = branchAddress;
		$('#updateBranchModal').modal('show');
	}
	
	$scope.addBranch = function(){
		$http.get(restUrl+'addBranchAction/'+$scope.branchName+'/'+$scope.branchAddress).success(function(data){
			$http.get(restUrl+'showBranchListRest').success(function(data){
				$scope.branches = data;
				$scope.branchName = "";
				$scope.branchAddress = "";
			});
		});
	}
	
	$scope.deleteBranch = function(branchId){
		$http.get(restUrl + '/deleteBranchRest/'+ branchId).success(function(data){
			$http.get(restUrl + 'showBranchListRest').success(function(data){
				$scope.branches = data;
			});
		});
	}
	
	$scope.updataBranch = function(){
		$http.get(restUrl + 'updateBranchRest/'+$scope.branchId+'/'+$scope.branchNameUpdate+'/'+$scope.branchAddress)
		.success(function(data){
			$http.get(restUrl + 'showBranchListRest').success(function(data){
				$scope.branches = data;
				$('#updateBranchModal').modal('hide');
			});
		});
	}
});

libraryModule.controller('genreController', function($scope, $http, $cookieStore) {
	$http.get(restUrl + 'showGenreListRest').success(function(data){
		$scope.genres = data;
	});
	
	$scope.addGenre = function() {
		 $http.post(restUrl + 'addGenreAction/' +$scope.genreName).
		  success(function(data) {
				$http.get(restUrl + 'showGenreListRest').success(function(data) {
					$scope.genres = data;
					$scope.genreName="";
		    });
		  });
	};
});

libraryModule.controller('bookController', function($scope, $http, $cookieStore) {
	$http.get(restUrl + 'showAuthorListRest').success(function(data){
		$scope.authorOptions = data;
	});
	
	$http.get(restUrl + 'showGenreListRest').success(function(data){
		$scope.genreOptions = data;
	});
	
	$http.get(restUrl + 'showPublisherListRest').success(function(data){
		$scope.pubOptions = data;
	});
	$http.get(restUrl + 'showBookListRest').success(function(data){
		$scope.books = data;
	});
	
	$scope.addBook = function(){
		$http.get(restUrl + "addBookAction/"+$scope.title+"/"+$scope.selectedPub.id+"/"+$scope.selectedAuthors+"/"+$scope.selectedGenres).
		success(function(data){
			$http.get(restUrl + 'showBookListRest').success(function(data){
				$scope.books = data;
			});
			$scope.title="";
			$scope.selectedPub="";
			$scope.selectedAuthors=null;
			$scope.selectedGenres=null;
			
		});
	};
	
});


libraryModule.controller('bookSearchController', function($scope, $http, $cookieStore) {
	$http.get(restUrl + 'showAuthorListRest').success(function(data){
		$scope.authorOptions = data;
	});
	
	$http.get(restUrl + 'showGenreListRest').success(function(data){
		$scope.genreOptions = data;
	});
	
	$http.get(restUrl + 'showPublisherListRest').success(function(data){
		$scope.pubOptions = data;
	});
	
	$scope.searchBook=function(){
		$scope.searchStr = restUrl+'seachBookAction/'+$scope.keyWord;
		

		if ($scope.filterAuthor != null)
			$scope.searchStr += "/" + $scope.filterAuthor.id;
		else
			$scope.searchStr += "/" + "NONE";
		if ($scope.filterPub != null)
			$scope.searchStr += "/" + $scope.filterPub.id;
		else
			$scope.searchStr += "/" + "NONE";

		if ($scope.filterGenre != null)
			$scope.searchStr += "/" + $scope.filterGenre.id;
		else
			$scope.searchStr += "/" + "NONE";
		
		$http.get($scope.searchStr).success(function(data){
			$scope.searchResult = data;
		});

	};
});

libraryModule.controller('testCtrl', function($scope, $http, $cookieStore) {
	$scope.testVar = $cookieStore.get('sample');
});
