<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<link rel="stylesheet" href="forma.css">
<body>
<div class="wrapper">
    <div class="title">
      Create Profile
    </div>
    <form action="Registration" method="post">
    <div class="form">
       <div class="inputfield">
          <label>Name:</label>
          <input type="text" name="Person" class="input" placeholder="Input name for contact">
       </div>  
        <div class="inputfield">
          <label> Profile name:</label>
          <input type="text" name="User" class="input" placeholder="Input profile name">
       </div>  
       <div class="inputfield">
          <label>Password </label>
          <input type="password" name="Password" class="input" placeholder="Input password with at least 8 symbols">
       </div>  
      <div class="inputfield">
          <label>Confirm Password</label>
          <input type="password" name="Rep_password" class="input" placeholder="Input password with at least 8 symbols">
       </div> 
      <div class="inputfield">
        <input type="submit" value="Register" class="btn">
      </div>
    </div>
      </form>
</div>
</body>
</html>