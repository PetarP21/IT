<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="users.User" %>
<%@ page import="users.Skill"%>
 
<!DOCTYPE html>
<html>
<head>
<title>Начало</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<% User user = (User) session.getAttribute("sessionUser");  %>


 <header> </header>
 <div class="container">
 <div class="content">
 <div class="profile_picture"> 
 <img src="images/male.svg" alt="">
 </div>
 
 <form action="user" method="post">
  <input type="hidden" name="id" value="<%= user.getId() %>">
 <div class="my_info">
 <h2>Профилна информация</h2>
 <label>Име:</label>
 <input type="text" name="personal_name" value="<%= user.getPersonalName() %>">
 
 <label>Работа:</label>
 <input type="text" name="job_title" value="<%= user.getJobTitle() %>">
 
 
 <label>Описание:</label>
 <input type="text" name="description" value="<%= user.getDescription() %>">
 </div>
 
 <h2 class="centered">Умения</h2>
 <div id="card1">

 <div class="card_column_one">
 <h3>Професионални</h3>
 <% int i=0;
 for(Skill skill:user.getProfesionalSkill()){%>
  <input type="text" name="profSkillName<%=i %>" value="<%= skill.getSkillName()%>">
  <input type="range" name="profSkillLevel<%=i %>" value="<%= skill.getLevel()%>" style="width:100%" min=0 max=100 step=10>
  
 <%
 i++;
 }
  %>


 
  </div>
  <div class="card_column_two">
  
   <h3>Личностни</h3>
   
   <% int j=0;
 for(Skill skill:user.getPersonalSkill()){%>
  <input type="text" name="personalSkillName<%=j %>" value="<%= skill.getSkillName()%>">
  <input type="range" name="personalSkillLevel<%=j %>" value="<%= skill.getLevel()%>" style="width:100%" min=0 max=100 step=10>
  
 <%
 j++;
 }
  %>
  </div>
   </div>
 
 
 <h2 class="centered">Контакти</h2>
 <div id="card2">
  <div class="card_column_one">
   <label>Имейл:</label>
 <input type="text" name="email" value="<%= user.getEmail() %>">
   <label>Телефон:</label>
 <input type="text" name="phone_number" value="<%= user.getPhone() %>">

  </div>
 
   <div class="card_column_two">
      <label>Град:</label>
 <input type="text" name="city" value="<%= user.getAddress().getCity() %>">
      <label>Улица:</label>
 <input type="text" name="street" value="<%= user.getAddress().getStreet() %>">

   
   </div>
    <center><input type="submit" value="Edit"></center>
 </div>
 </form>
</div>
</div>

 <footer> </footer>
</body>
</html>