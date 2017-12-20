<%@ include file = "header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					   <h2>En voiture ! Prenez la route en bonne compagnie.</h2>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="portfolios">
				<div class="text-center">
					
					<form method="post" action="trajet">
					  <div >
					    <label  >D'o� partez-vous ?</label>
					    <div>
					      <select   id="vdepart" name="vdepart" >
					      
					    	  <c:forEach items="${listville}" var="vid" >
					  	  
					<option value="${vid.idVille}" >  ${vid.labelVille}</option> 
					</c:forEach>
					
							</select> 
					  </div>
					</div>
					<div >
					  <label > D'o� allez-vous ?</label>
					  <div >
					  
					    <select    id="varrive" name="varrive" >
					    
					    <c:forEach items="${listville}" var="via" >
					<option value="${via.idVille}"  >  ${via.labelVille}</option> 
					</c:forEach>
					      </select>
					    </div>
					  </div>
					  
					  <div >
					    <label  > Date d�part ?</label>
					    <div >
					      <input type="date"   id="depart" name="ddepart" >
					    </div>
					  </div>
					  <br/>
					  <button type="submit" name="todo" value="recherchetrajet" > Rechercher </button>
					</form>
				</div>
				<hr>

			</div>
		</div>
	</div>
</div>

<%@ include file = "footer.jsp" %>
