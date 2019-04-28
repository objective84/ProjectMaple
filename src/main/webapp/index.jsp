<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html ng-app="ProjectMaple">

    <head>
        <title>Project Maple</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/app.css"/>
        <script src="<%=request.getContextPath()%>/resources/node_modules/angular/angular.js"></script>
        <script src="<%=request.getContextPath()%>/resources/node_modules/jquery/dist/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/controller/FactoryController.js"></script>
    </head>
    <body>
        <div class="container" id="tree-container" ng-controller="FactoryController">
            <div>
                <ul id="maple" >
                    <li id="tree-top"> <a href="#">Factories</a>
                        <ul>
                            <li ng-repeat="factory in factories" on-finish-render>{{factory.name}}
                                <ul>
                                    <li ng-repeat="number in factory.numbers">{{number}}</li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>

                <input type="text" id="new-factory-name" placeholder="<Factory Name>">
                <input type="text" id="new-factory-lower" placeholder="<Lower Limit>">
                <input type="text" id="new-factory-upper" placeholder="<Upper Limit>">
                <br/>
                <input type="button" ng-click="onAddClick($('#new-factory-name'))" class="btn btn-primary btn-sm" value="Add Factory">
            </div>
        </div>
    </body>
</html>