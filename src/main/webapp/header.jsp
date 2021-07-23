<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light navbar-custom" style="background-color: #17a2b8">
  <a class="navbar-brand" style="color: #fff" href="#">User Management System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse navbar-custom" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
      	<c:set var="username" value="${sessionScope.username}" />
      	<jsp:useBean id="userService" class="com.training.service.UserService"/>
      	<c:set var="type">${userService.getUserDetailFromUsername(username).type}</c:set>
      	<c:if test="${type}">
        <a class="nav-link" style="color: #fff" href="usersList">Home <span class="sr-only">(current)</span></a>
        </c:if>
      </li>
      <li class="nav-item">
        <a class="nav-link" style="color: #fff" href="logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>