<%@ include file = "header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					   <h2>Liste des Réservations </h2>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
<div style="margin-top: 35px;">
	
			<table class="table" align="center">
				<thead>
					<tr>
						<th>Conducteur</th>
						<th>Nombre de place réservée</th>
						<th>Validee </th>
						<th>Ville Départ</th>
						<th>Ville Arrivée</th>
						<th>Date Départ</th>
						<th>Heure Départ</th>
						<th>Annuler</th> 
					</tr>
				</thead>
				<c:forEach items="${listReservation}" var="res">
					<tr>
					    <td class="info">${res.id.trajet.utilisateur.nomComplet}</td>
						<td class="info">${res.nbrPlaceReserve}</td>
						<td class="info">${res.confirme}</td>
						<td class="info">${res.id.trajet.villeDepart.labelVille}</td>
						<td class="info" >${res.id.trajet.villeArrive.labelVille}</td>
						<td class="info">${res.id.trajet.datedepart}</td>
						<td class="info" >${res.id.trajet.heureDepart}</td>
						<td class="danger"> <a class="pure-button"
            					 href="ReservationController?trj=${res.id.trajet.idTrajet}&todo=AnnulerReservation">Annuler</a></td>
						<td>
					
					</tr>
				</c:forEach>
			</table>
		
</div>

	
<%@ include file = "footer.jsp" %>
