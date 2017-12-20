<%@ include file = "header.jsp" %>
   
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						<form class="form-signin" method="post" action="voiture">
						<%if(session.getAttribute("ajout") != null && session.getAttribute("ajout").equals("false")) {%>
       						 <button class="btn btn-lg btn-primary btn-block" type="submit" name="voiture" value="ajouter" >Ajouter voiture</button>
      				  <%    } %>
        			       <%if(session.getAttribute("ajout") != null && session.getAttribute("ajout").equals("true")) {%>
                              <button class="btn btn-lg btn-primary btn-block" type="submit" name="voiture" value="supprimer" >Supprimer voiture</button>
                              <button class="btn btn-lg btn-primary btn-block" type="submit" name="voiture" value="modifier" >Modifier voiture</button>
                       <% } %>
                      </form>
                      <form class="form-signin" method="post" action="trajet">
                              <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="listerTrajets" >Lister les trajets planifiés</button>                              
                      </form>
                      <form class="form-signin" method="post" action="reservation">
                              <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="listerMesReservations" >Lister les reservations</button>
                               <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="listerMesNotifications" >Lister les notifications</button>
                              
                      </form>
				     </div>
					<hr>
				</div>
			</div>
		</div>
	</div>
	
	
<%@ include file = "footer.jsp" %>