    angular.module("ehr").directive("display",["displayService",function(displayService){
        return {
            restrict:"E",
            templateUrl:"/main_template/views/display.html",
            
            link:function(scope){
                scope.displayContent = displayService.displayContent;
                scope.display=displayService.displayContent.default;
                scope.toggleDisplay = function(x){
                    scope.display=x;
                }
            }
        }
    }])