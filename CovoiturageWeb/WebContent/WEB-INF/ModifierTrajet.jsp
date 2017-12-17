<%@ include file = "header.jsp" %>

<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
												
						<form method="post" action="trajet">
						
							<p> Modification  du trajet de ${vdepart.labelVille} à  ${varrive.labelVille} </p>
						
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
						              <label>   nmbre de place ?</label>
						              <div >
						                 <input type="text" value="${nbrplc}"    name="nbrp" >
						              </div>
						         </div>
						          <div >
						               <label  > Date départ ?</label>
						               <div >
						                  <input type="date"    id="depart" name="ddepart" >
						                </div>
						          </div>
						  
						           <div >
						                <label  > Heure départ </label>
						                 <div >
						                      <input type="time"   id="hdepart" name="hdepart" >
						                   </div>
						             </div>
						  
						  <button class="success" type="submit" name="todo" value="clickModifiertrajet" >Modifier Trajet</button>
						</form>
					</div>
					<hr>

			 <p class="text-center">Vous n’avez pas de compte? <a href ="/CovoiturageWeb/connexion?todo=inscript"> Inscrivez-vous </a><p>
				</div>
			</div>
		</div>
	</div>



<%@ include file = "footer.jsp" %>
