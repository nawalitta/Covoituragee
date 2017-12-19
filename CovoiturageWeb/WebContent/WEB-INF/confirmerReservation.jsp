<%@ include file = "header.jsp" %>


<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
								<p>Conducteur : ${trajet.utilisateur.login}</p>
								
								<p>D�part :  ${trajet.villeDepart.labelVille}</p>
								
								<p>Arriv�e :  ${trajet.villeArrive.labelVille}</p>
								
								<p>Date D�part :   ${trajet.datedepart}</p>
								
								<p>Nombre de place disponible :  ${trajet.nbrPlaces}</p>
								
								<form method="post" action="reservation">
							        <label >Nombre de place � r�server </label>
							        <input type="text"  name="nbrplc"  required>
							        <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="reserver" >Envoyer une demande</button>
							  </form>
														
						
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>

<%@ include file = "footer.jsp" %>
