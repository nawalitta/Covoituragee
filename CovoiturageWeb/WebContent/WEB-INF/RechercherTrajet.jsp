<%@ include file = "header.jsp" %>


	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						
<form method="post" action="trajet">
  <div >
    <label  >D’où partez-vous ?</label>
    <div>
      <select   id="vdepart" name="vdepart" >
      
    	  <c:forEach items="${listville}" var="vid" >
    	  
		<option value="${vid.idVille}" >  ${vid.labelVille}</option> 
	</c:forEach>
	
				</select> 
    </div>
  </div>
  <div >
    <label > Où allez-vous ?</label>
    <div >
    
      <select    id="varrive" name="varrive" >
      
      <c:forEach items="${listville}" var="via" >
		<option value="${via.idVille}"  >  ${via.labelVille}</option> 
		</c:forEach>
      </select>
    </div>
  </div>
  
  <div >
    <label  > Date départ ?</label>
    <div >
      <input type="date"   id="depart" name="ddepart" >
    </div>
  </div>
  <button type="submit" name="todo" value="recherchetrajet" > Rechercher </button>
</form>
					</div>
					<hr>

				</div>
			</div>
		</div>
	</div>



  


<%@ include file = "footer.jsp" %>
