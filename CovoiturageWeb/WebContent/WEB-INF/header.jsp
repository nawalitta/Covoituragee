<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" href="enno/css/jquery.bxslider.css">
	<link rel="stylesheet" type="text/css" href="enno/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="enno/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="enno/css/set1.css" />
	<link href="enno/css/overwrite.css" rel="stylesheet">
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
						<li role="presentation" class="active"><a href="controller">Home</a></li>
						<li role="presentation"><a href="TrajetController?&todo=listerTrajets">Services</a></li>
							<li role="presentation" ><a href="TrajetController">Ajouter Trajet</a></li>
						<li role="presentation"><a href="/CovoiturageWeb/connexion">Mon Compte</a></li>
						<li role="presentation"><a href="TrajetController?&todo=clickRecherche">Contact</a></li>	
						
						<% if (session.getAttribute("connecter") != null && session.getAttribute("connecter").equals("ok")) { %>
						<li role="presentation"><a href="/CovoiturageWeb/deconnexion">Déconnexion</a></li>
						<% } %>				
					</ul>
				</div>
			</div>			
		</div>
	</nav>