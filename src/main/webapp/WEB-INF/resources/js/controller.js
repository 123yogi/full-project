var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

       $scope.addToCart = function(chairId){
        $http.put('http://localhost:8080/niittraining/viewcart/' + chairId).success(function ()
        {
            alert('Product successfully added to the cart!');
        });
    };

    });