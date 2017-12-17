<%@ include file = "header.jsp" %>

<h1>Liste des trajets planifiés resultat</h1>
	
	<div style="margin-top: 35px;">
		
				<table class="table" align="center">
					<thead>
						<tr>
							<th>Conducteur </th>
							<th>Ville Départ</th>
							<th>Ville Arrivée</th>
							<th>Date Départ</th>
							<th>Heure Départ</th>
							<th>Nombre de place </th>
							<th>Réserver</th>
							
						</tr>
					</thead>
					<c:forEach items="${listTrajets}" var="trajet">
						<tr>
						    <td class="info">${trajet.utilisateur.login}</td>
							<td class="info">${trajet.villeDepart.labelVille}</td>
							<td class="info">${trajet.villeArrive.labelVille}</td>
							<td class="info">${trajet.datedepart}</td>
							<td class="info" >${trajet.heureDepart}</td>
							<td class="success">${trajet.nbrPlaces}</td>
						<td   class="danger"> <a class="pure-button"
              href="TrajetController?trajet_id=${trajet.idTrajet }&todo=delTrajet">Réserver</a></td> 
							
							
						</tr>
					</c:forEach>
				</table>
			
	</div>

<%@ include file = "footer.jsp" %>
