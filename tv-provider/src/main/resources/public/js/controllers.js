angular.module('app.controllers', []).controller('ClientListController', function($scope, $state, popupService, $window, Client) {
  $scope.clients = Client.query(); //fetch all clients. Issues a GET to /api/vi/clients

  $scope.deleteClient = function(client) { // Delete a Client. Issues a DELETE to /api/v1/clients/:id
    if (popupService.showPopup('Really delete this?')) {
      client.$delete(function() {
        $scope.clients = Client.query(); 
        $state.go('clients');
      });
    }
  };
}).controller('ClientViewController', function($scope, $stateParams, Client) {
  $scope.client = Client.get({ id: $stateParams.id }); //Get a single client.Issues a GET to /api/v1/clients/:id
}).controller('ClientCreateController', function($scope, $state, $stateParams, Client) {
  $scope.client = new Client();  //create new client instance. Properties will be set via ng-model on UI

  $scope.addClient = function() { //create a new client. Issues a POST to /api/v1/clients
    $scope.client.$save(function() {
      $state.go('clients'); // on success go back to the list i.e. clients state.
    });
  };
}).controller('ClientEditController', function($scope, $state, $stateParams, Client) {
  $scope.updateClient = function() { //Update the edited client. Issues a PUT to /api/v1/clients/:id
    $scope.client.$update(function() {
      $state.go('clients'); // on success go back to the list i.e. clients state.
    });
  };

  $scope.loadClient = function() { //Issues a GET request to /api/v1/clients/:id to get a client to update
    $scope.client = Client.get({ id: $stateParams.id });
  };

  $scope.loadClient(); // Load a client which can be edited on UI
});
