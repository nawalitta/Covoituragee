<%@ include file = "header.jsp" %>

	<h1>Liste des trajets planifi�s</h1>
	
	<div style="margin-top: 35px;">
		
				<table class="table" align="center">
					<thead>
						<tr>
							
							<th>Ville D�part</th>
							<th>Ville Arriv�e</th>
							<th>Date D�part</th>
							<th>Heure D�part</th>
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
<%@ include file = "footer.jsp" %>
