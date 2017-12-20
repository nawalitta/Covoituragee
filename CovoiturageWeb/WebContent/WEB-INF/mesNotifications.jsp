<%@ include file = "header.jsp" %>


<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					   <h2>Liste des notifications</h2>
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
						<th>Nom </th>
						<th>Nombre de place réservée</th>
						<th>Validee </th>
						<th>Ville Départ</th>
						<th>Ville Arrivée</th>
						<th>Date Départ</th>
						<th>Heure Départ</th>
						<th>Valider</th>
						<th>Ignorer</th>  
					</tr>
				</thead>
				<c:forEach items="${listNotifications}" var="notif">
					<tr>
						<td class="info">${notif.id.user.nomComplet}</td>
						<td class="info">${notif.nbrPlaceReserve}</td>
						<td class="info">${notif.confirme}</td>
						<td class="info">${notif.id.trajet.villeDepart.labelVille}</td>
						<td class="info" >${notif.id.trajet.villeArrive.labelVille}</td>
						<td class="info">${notif.id.trajet.datedepart}</td>
						<td class="info" >${notif.id.trajet.heureDepart}</td>
					<td   class="success"> <a class="pure-button"
             href="ReservationController?trajet_id=${notif.id.trajet.idTrajet}&id=${notif.id.user.login}&todo=ValiderReservation">Valider</a></td>
						<td class="danger">
						<a class="pure-button"
	href="ReservationController?trajet_id=${notif.id.trajet.idTrajet}&id=${notif.id.user.login}&todo=IgnorerReservation">Ignorer</a></td>
					
					</tr>
				</c:forEach>
			</table>
		
</div>
<%@ include file = "footer.jsp" %>
