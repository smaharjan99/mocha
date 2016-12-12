angular.module('ehr').directive('headerDir',['displayService',function(displayService){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/header.html',
        link:function(scope){
            scope.displayContent = displayService.displayContent;
        }
    }
}]);

angular.module('ehr').directive('navbarDir',function(){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/navbar.html'
    }
});

angular.module('ehr').directive('slideDir',function(){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/slide.html'
    }
});

angular.module('ehr').directive('subcontainDir',function(){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/subcontain.html'
    }
});


angular.module('ehr').directive('formDir',function(){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/form.html'
    }
  });  

angular.module('ehr').directive('footerDir',function(){
    return{
        restrict: "EAC",
        templateUrl: '/main_template/views/footer.html'
    }
});