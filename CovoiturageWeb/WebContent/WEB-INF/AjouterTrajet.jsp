<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>




<form method="post">
  <div >
    <label  >D’où partez-vous ?</label>
    <div>
      <select   id="vdepart" name="vdepart" >
      
    	  <c:forEach items="${listville}" var="vid" >
    	  
		<option value="${vid.idVille}" >  ${vid.labelVille}</option> 
	</c:forEach>
				</select>
		
 
    </div>
  </div>
  <div >
    <label > Où allez-vous ?</label>
    <div >
    
      <select    id="varrive" name="varrive" >
      
      <c:forEach items="${listville}" var="via" >
		<option value="${via.idVille}"  >  ${via.labelVille}</option> 
		</c:forEach>
      </select>
    </div>
  </div>
  
  
  
   <div >
    <label>   nmbre de place ?</label>
    <div >
      <input type="text"  id="nbrp"   name="nbrp" >
    </div>
  </div>
   <div >
    <label  > Date départ ?</label>
    <div >
      <input type="date"   id="depart" name="ddepart" >
    </div>
  </div>
  
  <div >
    <label  > Heure départ </label>
    <div >
      <input type="time"  id="hdepart" name="hdepart" >
    </div>
  </div>
  
  <button type="submit" name="todo" value="ajoutrajet" >Ajouter Trajet</button>
</form>





</body>
</html>