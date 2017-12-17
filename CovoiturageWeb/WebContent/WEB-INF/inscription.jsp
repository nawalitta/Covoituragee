<%@ include file = "header.jsp" %>

    <div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						<form class="form-signin" method="post" action="connexion">
						        <h2 class="form-signin-heading">Inscription </h2>
						        <div class="form-group">
							        <label for="inputEmail" class="sr-only">Nom Complet</label>
							        <input type="text" id="inputEmail"  name="nom" class="form-control" placeholder="Nom Complet" required autofocus>
						        </div>
						        <div class="form-group">
							        <label for="inputEmail" class="sr-only">Login</label>
							        <input type="text" id="inputEmail"  name="login" class="form-control" placeholder="Login" required autofocus>
						        </div>
						        <div class="form-group">
							        <label for="inputPassword" class="sr-only">Password</label>
							        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
						        </div>
						        <div class="form-group">
							        <label for="inputPassword" class="sr-only">Vérification mot de passe</label>
							        <input type="password" id="vinputPassword" name="vpassword" class="form-control" placeholder="Vérification mot de passe" required>
						        </div>
						        <div class="form-group">
								    <input type="email" class="form-control" id="exampleInputEmail1" name="mail" aria-describedby="emailHelp" placeholder="Enter email">
									<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						       </div>
						        <div class="form-group">
								    <input type="text" class="form-control" id="exampleInputEmail1" name="numTele" aria-describedby="emailHelp" placeholder="Numéro Téléphone">
						       </div>
						      <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="inscriptUser" >Créer un compte</button>
						       
       
                            </form>
					</div>
					<hr>
				</div>
			</div>
		</div>
	</div>
    
<%@ include file = "footer.jsp" %>
    