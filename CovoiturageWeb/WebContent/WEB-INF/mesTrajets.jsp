<%@ include file = "header.jsp" %>



<div class="container">
	<div class="row">
		<%  if(  request.getAttribute("success") != null &&  (request.getAttribute("success").equals("ok")  )) {%>
		
		
	<div class="alert alert-success">
    <strong>Success!</strong> Trajet Ajouté avec succèes ! 
    </div>
    
	          <%} %>
	
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
							<th>Etape</th>
							<th>Date Départ</th>
							<th>Heure Départ</th>
							<th>Nombre de place </th>
							<th>prix </th>
							<th>Supprimer</th>
							<th>Modifier</th>  
						</tr>
					</thead>
					<c:forEach items="${listTrajets}" var="trajet">
						<tr>
							<td class="info">${trajet.villeDepart.labelVille}</td>
							<td class="info">${trajet.villeArrive.labelVille}</td>
							
							 <c:set var='t' value=" " /> 
						<c:forEach items="${trajet.lesEtapes}" var="etape">
						 <c:set var='t' value="${t} ${etape.ville.labelVille} ->" /> 
							</c:forEach>
						<td class="info">${t}</td>
							
							<td class="info">${trajet.datedepart}</td>
							<td class="info" >${trajet.heureDepart}</td>
							<td class="info">${trajet.nbrPlaces}</td>
							<td class="info" >${trajet.prix}</td>
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
	
