mapleApp.controller('FactoryController', function ($scope, $http, $uibModal, $log) {
    const url = "http://localhost:8080/ProjectMaple/factory";
    $scope.factory = {
        id: null,
        name: "",
        upperLimit: 300,
        lowerLimit: 0,
        numbers: []
    };
    $scope.addPanelToggled = false;
    $scope.factories = [];

    $scope.getFactoryList = function () {
        $http.get(url).then(function (data) {
            $scope.factories = data.data;
        });
    };
    $scope.getFactoryList();

    $scope.onAddClick = function (ev, $element) {
        $http.post(url + '/add', this.factory)
            .then(reload)
    };

    $scope.onGenerateClick = function (id) {
        const modalInstance = $uibModal.open({
            templateUrl: 'generateModal.html',
            controller: 'GenerateController',
            resolve: {
                items: {
                    id: id
                }
            }
        });

        modalInstance.result.then(function () {
            $scope.getFactoryList();
        }, function () {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.onEditClick = function(id){
        for(let i = 0; i < $scope.factories.length; i++){
            if($scope.factories[i].id === id){
                $scope.factory = $scope.factories[i];
                if(!$('#addFactory').hasClass('show'))
                    $('#addFactory').collapse();
                return;
            }
        }
    }

    function reload(success) {
        if (success) {
            $scope.getFactoryList();
        }
    }
});