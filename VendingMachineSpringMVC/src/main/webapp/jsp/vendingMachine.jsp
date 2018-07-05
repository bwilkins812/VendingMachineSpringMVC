<%-- 
    Document   : vendingMachine
    Created on : May 17, 2018, 11:13:09 AM
    Author     : brettwilkins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SG Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body style="background-color: lightgray">
        <div class="container">
            <h1 align="center">SG Vending Machine</h1>
            <hr/>
            <div class="col-md-8" align="center">
                <c:forEach var="itemList" items="${itemList}">                 
                         <a href="${pageContext.request.contextPath}/itemSelection/${itemList.itemNumber}" class="btn btn-info"
                            style="height: 120px; width: 120px; margin-bottom: 20px; margin-left: 100px">
                             <p class="text-left">${itemList.itemNumber}</p>
                             <p class="text-center">${itemList.name}</p>
                             <p class="text-center">$${itemList.price}</p>
                             <p class="text-center">Quantity Left: ${itemList.quantity}</p>
                        </a>
                </c:forEach>
            </div> 
            <div id="addMoney" class="col-md-4">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h3>Total $ In</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12" align="center">
                        <input class="text-center" type="text" id="moneyDeposited" value="${deposit}" name="totalDollarsIn" placeholder="0.00" align="center" readonly>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-6" align="center">
                        <a href="${pageContext.request.contextPath}/depositMoney/addDollar" class="btn btn-primary" style="height: 35px; width: 125px; margin-bottom: 20px">Add Dollar</a>
                        <a href="${pageContext.request.contextPath}/depositMoney/addDime" class="btn btn-primary" style="height: 35px; width: 125px">Add Dime</a>
                    </div>
                    <div class="col-md-6" align="center">
                        <a href="${pageContext.request.contextPath}/depositMoney/addQuarter" class="btn btn-primary" style="height: 35px; width: 125px; margin-bottom: 20px">Add Quarter</a>
                        <a href="${pageContext.request.contextPath}/depositMoney/addNickel" class="btn btn-primary" style="height: 35px; width: 125px">Add Nickel</a>
                    </div>
                </div>
                <hr/>
            </div>
            <div id="messages" class="col-md-4">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h3>Messages</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12"  align="center">
                        <input class="text-center" style="width: 250px;" type="text" value="${messages}" id="messageBox" name="messages" placeholder="Messages" align="center" readonly>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12" align="center">
                        <label for="itemSelectedBox">
                            Item:
                        </label>
                        <input type="text" style="width: 50px;" name="itemSelectedBox" id="itemSelectedBox" value="${itemNumber}" placeholder="Item #" align="center" readonly>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12" align="center">
                        <a href="${pageContext.request.contextPath}/makePurchase" class="btn btn-success" style="height: 35px; width: 125px">Make Purchase</a>
                    </div>
                </div>
                <hr/> 
            </div>
            <div class="col-md-8">
            </div>
            <div id="changeReturn" class="col-md-4">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h3>Change</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12" align="center">
                        <input class="text-center" style="width: 300px;" id="changeBox" value="${change}" type="text" name="change" placeholder="$0.00" align="center" readonly>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-12" align="center">
                        <a href="${pageContext.request.contextPath}/returnChange" class="btn btn-danger" style="height: 35px; width: 125px">Return Change</a>
                    </div>
                </div> 
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>