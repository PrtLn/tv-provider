angular.module('app.services', []).factory('Client', function($resource) {
  return $resource('/api/v1/clients/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
