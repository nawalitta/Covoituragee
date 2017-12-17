<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form method="post" action="trajet">

<p> Modification  du trajet de ${vdepart.labelVille} à  ${varrive.labelVille} </p>

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
      <input type="text" value="${nbrplc}"    name="nbrp" >
    </div>
  </div>
   <div >
    <label  > Date départ ?</label>
    <div >
     <!--  <input type="date"  value="${ddepart}"  id="depart" name="ddepart" > --> 
       <input type="date"    id="depart" name="ddepart" >
    </div>
  </div>
  
  <div >
    <label  > Heure départ </label>
    <div >
      <!--  <input type="time"   value="${hdepart}"  id="hdepart" name="hdepart" >--> 
            <input type="time"   id="hdepart" name="hdepart" >
      
    </div>
  </div>
  
  <button class="success" type="submit" name="todo" value="clickModifiertrajet" >Modifier Trajet</button>
</form>



</body>
</html>