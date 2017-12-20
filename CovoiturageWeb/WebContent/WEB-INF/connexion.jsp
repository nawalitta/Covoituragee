
<%@ include file = "header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						<form class="form-signin" method="post" action="connexion">
        <h2 class="form-signin-heading">CONNEXION </h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail"  name="login" class="form-control" placeholder="Login" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="connect" >Sign in</button>
      </form>
					</div>
					<hr>

			 <p class="text-center">Vous n avez pas de compte? <a href ="/CovoiturageWeb/connexion?todo=inscript"> Inscrivez-vous </a><p>
				</div>
			</div>
		</div>
	</div>
	
<%@ include file = "footer.jsp" %>
