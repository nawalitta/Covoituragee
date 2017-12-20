<%@ include file = "header.jsp" %>


<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					   <h2>Liste des trajets planifiés </h2>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
<div class="container">

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
							<td class="info">${trajet.nbrPlaces}</td>
						<td   class="danger"> <a class="pure-button"
              href="TrajetController?trajet_id=${trajet.idTrajet }&todo=delTrajet">Supprimer</a></td>
							<td class="success">
							<a class="pure-button"
		href="trajet?trajet_id=${trajet.idTrajet }&todo=modifierTrajet">Modifier</a></td>
						
						</tr>
					</c:forEach>
				</table>
			
	</div>
	<hr>
</div>
	
		
<%@ include file = "footer.jsp" %>
	
