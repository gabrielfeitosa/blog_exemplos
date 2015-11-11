(function() {

	angular.module("app.focus",[]);

    angular.module("app.focus")
        .factory('focus', function($timeout, $window) {
            return function(id) {
                $timeout(function() {
                    var element = $window.document.getElementById(id);
                    console.log(element);
                    if (element)
                        element.focus();
                });
            };
        })

    angular.module("app.focus")
        .directive('gfEventFocus', function(focus) {
            return function(scope, elem, attr) {
                elem.on(attr.gfEventFocus, function() {
                    focus(attr.gfEventFocusId);
                });
                scope.$on('$destroy', function() {
                    elem.off(attr.gfEventFocus);
                });
            };
        });
})();