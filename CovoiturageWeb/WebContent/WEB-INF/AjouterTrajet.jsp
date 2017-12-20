<%@ include file = "header.jsp" %>



	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						
<form method="post">
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
    <label>  prix trajet </label>
    <div >
      <input type="text"   name="prixt" >
    </div>
  </div>
   <div >
    <label>   nmbre de place ?</label>
    <div >
      <input type="text"  id="nbrp"   name="nbrp" >
    </div>
  </div>
   <div >
    <label  > Date départ ?</label>
    <div >
      <input type="date"   id="depart" name="ddepart" >
    </div>
  </div>
  
  <div >
    <label  > Heure départ </label>
    <div >
      <input type="time"  id="hdepart" name="hdepart" >
    </div>
  </div>
  
  <c:if test="${nbrEtapes}=!0">
  <div >
    <label > Saisir les étapes </label>
    <div >
    </c:if>
    

<c:forEach  begin="1"  end="${nbrEtapes}" var="i" >
    <div >
    <label > Etape  ${i} </label>
    <div >
      <select      name="etape${i}"  >
      
      <c:forEach items="${listville}" var="via" >
		<option value="${via.idVille}"  >  ${via.labelVille}</option> 
		</c:forEach>
      </select>
      
      <label > Prix   </label>
            <input type="text"   name="prix${i}" >
      
     
      
    </div>
  </div>
</c:forEach>
  
  <br>
  
              <input type='hidden'   name="success" value="ok" >
  
  <button type="submit" name="todo" value="ajoutrajet" >Ajouter Trajet</button>
  
  
  
  
</form>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>



<%@ include file = "footer.jsp" %>
