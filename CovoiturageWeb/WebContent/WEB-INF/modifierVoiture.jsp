<%@ include file = "header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
		<form class="form-signin" method="post" action="voiture">
        <h2 class="form-signin-heading">Veuillez remplir les champs obligatoires</h2>
        <label for="inputEmail" class="sr-only">Modèle :</label>
        <input type="text" id="modele"  name="modele" class="form-control" placeholder="Modèle "  value="${modele}"   required autofocus>
        <select name="gabarit">
                <option value="${idGabaritSelectionne}" selected>${libelleGabaritSelectionne}</option>
	        <c:forEach var="gabarit"  items="${nonlistGabarit}" >
	            <option value="${gabarit.idGabarit}">${gabarit.libelleGabarit}</option>
	       </c:forEach>
		</select>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="voiture" value="modifierVoiture">Modifier</button>
      </form>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
<%@ include file = "footer.jsp" %>