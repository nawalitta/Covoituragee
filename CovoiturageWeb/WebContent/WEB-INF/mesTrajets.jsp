<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Liste des trajets planifiés</h1>
	
	<div style="margin-top: 35px;">
		
				<table class="table" align="center">
					<thead>
						<tr>
							
							<th>Ville Départ</th>
							<th>Ville Arrivée</th>
							<th>Date Départ</th>
							<th>Heure Départ</th>
							<th>Nombre de place </th>
							<th>Supprimer</th>
							<th>Modifier</th>  
						</tr>
					</thead>
					<c:forEach items="${listTrajets}" var="trajet">
						<tr>
							<td class="info">${trajet.villeDepart.labelVille}</td>
							<td class="info">${trajet.villeArrive.labelVille}</td>
							<td class="info">${trajet.datedepart}</td>
							<td class="info" >${trajet.heureDepart}</td>
							<td class="success">${trajet.nbrPlaces}</td>
						<td   class="danger"> <a class="pure-button"
              href="TrajetController?trajet_id=${trajet.idTrajet }&todo=delTrajet">Supprimer</a></td>
							<td>
							<a class="pure-button"
		href="trajet?trajet_id=${trajet.idTrajet }&todo=modifierTrajet">Modifier</a></td>
						
						</tr>
					</c:forEach>
				</table>
			
	</div>
</body>
</html>