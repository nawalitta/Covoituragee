<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eNno Bootstrap Template</title>

    <!-- Bootstrap -->
    <link href="enno/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="enno/css/animate.css">
	<link rel="stylesheet" href="enno/css/font-awesome.min.css">
	<link rel="stylesheet" href="enno/css/font-awesome.css">
	<link rel="stylesheet" href="enno/css/jquery.bxslider.css">
	<link href="enno/css/overwrite.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="enno/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="enno/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="enno/css/set1.css" />
	<link href="enno/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><span>eNno</span></a>
			</div>
			<div class="navbar-collapse collapse">							
				<div class="menu">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
						<li role="presentation"><a href="TrajetController?&todo=listerTrajet">Services</a></li>
						<li role="presentation" ><a href="TrajetController">Ajouter Trajet</a></li>
						<li role="presentation"><a href="connexion.jsp">Mon Compte</a></li>
						<li role="presentation"><a href="TrajetController?&todo=clickRecherche">Contact</a></li>						
					</ul>
				</div>
			</div>			
		</div>
	</nav>
	
	
   
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="portfolios">
					<div class="text-center">
						<form class="form-signin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail"  name="login" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="todo" value="connect" >Sign in</button>
      </form>
					</div>
					<hr>
					
				</div>
			</div>
		</div>
	</div>
	
	
	
	<footer>
		<div class="inner-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-4 f-about">
						<a href="index.html"><h1><span>e</span>Nno</h1></a>
						<p>Lorem ipsum dolor sit amet consectetur adipiscing elit Cras suscipit arcu libero
						vestibulum volutpat libero sollicitudin vitae Curabitur ac aliquam  consectetur adipiscing elit Cras suscipit arcu libero
						</p>
					</div>
					<div class="col-md-4 l-posts">
						<h3 class="widgetheading">Latest Posts</h3>
						<ul>
							<li><a href="#">This is awesome post title</a></li>
							<li><a href="#">Awesome features are awesome</a></li>
							<li><a href="#">Create your own awesome website</a></li>
							<li><a href="#">Wow, this is fourth post title</a></li>
						</ul>
					</div>
					<div class="col-md-4 f-contact">
						<h3 class="widgetheading">Stay in touch</h3>
						<a href="#"><p><i class="fa fa-envelope"></i> example@gmail.com</p></a>
						<p><i class="fa fa-phone"></i>  +345 578 59 45 416</p>
						<p><i class="fa fa-home"></i> Enno inc  |  PO Box 23456 
							Little Lonsdale St, New York <br>
							Victoria 8011 USA</p>
					</div>
				</div>
			</div>
		</div>
			
		<div class="last-div">
			<div class="container">
				<div class="row">
					<div class="copyright">
						© 2014 eNno Multi-purpose theme | <a target="_blank" href="http://bootstraptaste.com">Bootstraptaste</a>
					</div>	
                    <!-- 
                        All links in the footer should remain intact. 
                        Licenseing information is available at: http://bootstraptaste.com/license/
                        You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=eNno
                    -->			
				</div>
			</div>
			<div class="container">
				<div class="row">
					<ul class="social-network">
						<li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest fa-1x"></i></a></li>
						<li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus fa-1x"></i></a></li>
					</ul>
				</div>
			</div>
			<a href="" class="scrollup"><i class="fa fa-chevron-up"></i></a>	
		</div>			
	</footer>
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="enno/js/bootstrap.min.js"></script>
	<script src="enno/js/wow.min.js"></script>
	<script src="enno/js/jquery.easing.1.3.js"></script>
	<script src="enno/js/jquery.isotope.min.js"></script>
	<script src="enno/js/jquery.bxslider.min.js"></script>
	<script type="text/javascript" src="enno/js/fliplightbox.min.js"></script>
	<script src="enno/js/functions.js"></script>
	<script type="text/javascript">$('.portfolio').flipLightBox()</script>
  </body>
</html>