<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Inscription </title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet">
     <link href="https://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        

  </head>

<body>


    <div class="container">

      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
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
	        <input type="password" id="vinputPassword" name="password" class="form-control" placeholder="Vérification mot de passe" required>
        </div>
        <div class="form-group">
			<label for="exampleInputEmail1">Email address</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
			<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
       </div>
       
      <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="inscript" >Sign in</button>
       
       
      </form>

    </div> <!-- /container -->

</body>
</html>