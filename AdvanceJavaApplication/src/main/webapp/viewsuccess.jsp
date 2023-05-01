<%@page import="com.sai.advanceapplication.viewusers.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style >
table{
margin: auto;
text-align: center;
}
.container{
  width: 100%;
    background:linear-gradient(to top,rgba(0,0,0,0.5)50%,rgba(0,0,0,0.5)50%),url(websiteimage.jpg)50%;
    background-position: center;
    background-size: cover;
    height: 109vh;
    color: white;
    text-align: center;
    margin-top: 20px; 
    }
</style>
</head>
<body>
<div class="container">
<h1>List of Users</h1>
<table border="1">
<tr>
<th>User Name</th>
<th>Email</th>
<th>Country</th>
<th>Qualification</th>
<th>Gender</th>
<th>Address</th>
<th>Action</th>
</tr>
<%   List<User>users= (List<User>) request.getAttribute("users"); %>
<c:forEach  items="${users }"  var="user" >
<tr>

<td> ${user.username}</td>
<td> ${user.email}</td>
<td> ${user.country}</td>
<td> ${user.qualification}</td>
<td> ${user.gender}</td>
<td> ${user.address}</td>
<td> 
 <a href="#"><button>Edit</button> </a>
<a href="DeleteServlet?user=${ user.username}&email=${user.email}"><button>Delete</button> </a>
 </td>


</tr>
</c:forEach>
</table>
<h1 ><a href="index.html"><button> Home </button></a></h1>
</div>
</body>
</html>