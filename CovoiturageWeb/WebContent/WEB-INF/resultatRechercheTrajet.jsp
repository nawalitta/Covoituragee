<%@ include file = "header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					   <h2>Liste des trajets planifi�s resultat</h2>
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
						<th>Conducteur </th>
						<th>Ville D�part</th>
						<th>Ville Arriv�e</th>
						<th>Etape</th>
						<th>Date D�part</th>
						<th>Heure D�part</th>
						<th>Nombre de place </th>
						<th>prix </th>
						<th>R�server</th>
						
					</tr>
				</thead>
				<c:forEach items="${listTrajets}" var="trajet">
					<tr>
					    <td class="info">${trajet.utilisateur.login}</td>
						<td class="info">${trajet.villeDepart.labelVille}</td>
						<td class="info">${trajet.villeArrive.labelVille}</td>
                        <c:set var='t' value=" " /> 
						<c:forEach items="${trajet.lesEtapes}" var="etape">
						 <c:set var='t' value="${t} ${etape.ville.labelVille} ->" /> 
							</c:forEach>
						<td class="info">${t}</td>
					
						
						<td class="info">${trajet.datedepart}</td>
						<td class="info" >${trajet.heureDepart}</td>
						<td class="success">${trajet.nbrPlaces}</td>
						<td class="success">${trajet.prix}</td>
					<td   class="danger"> <a class="pure-button"
					
             href="ReservationController?trajet_id=${trajet.idTrajet }&todo=reserverTrajet">R�server</a></td> 
						
						
					</tr>
				</c:forEach>
			</table>
		
</div>

<%@ include file = "footer.jsp" %>
