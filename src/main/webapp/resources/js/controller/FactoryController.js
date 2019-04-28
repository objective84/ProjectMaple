mapleApp.controller('FactoryController', ['$scope', '$http',
    function ($scope, $http) {
        var url = "http://localhost:8080/ProjectMaple";
        var self = this;
        self.factory = {
            id: null,
            name: "",
            upperLimit: 300,
            lowerLimit: 0,
            numbers: []
        };
        self.factories = [];

        self.getFactoryList = function () {
            $http.get(url + '/factory').then(function (data) {
                $scope.factories = data.data;
            });
        };
        self.getFactoryList();

        $scope.onAddClick = function (){
            var name = $('#new-factory-name')[0].value;
            alert(name);
        };
    }]);