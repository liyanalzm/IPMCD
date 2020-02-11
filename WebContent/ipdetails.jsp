<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,mc.processor.DataRetriever"
    %>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Malay Confinement Dietary</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <!--Google fonts Link-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,500i,700,700i" rel="stylesheet">

        <link rel="stylesheet" href="assets/css/skills/progressbar.css">
        <link rel="stylesheet" href="assets/css/skills/style.css">
        <link rel="stylesheet" href="assets/css/fonticons.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/styleSecond.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        <style>
		.img-circle {
		    border-radius: 50%;
		     border: 0px solid #ccc;
		     max-width:50%;
		}
        </style>
       
    </head>
    <body data-spy="scroll" data-target=".navbar-collapse">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
		<div class="whole">
        <header class="header navbar-fixed-top">            
            <div class="main_menu_bg">
            <div class="secondPage">
                <div class="container">
                    <div class="row">
                        <div class="nave_menu">
                            <nav class="navbar navbar-default " id="navmenu">
                            	
                                <div class="container-fluid">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                        <a class="navbar-brand" href="#home">
                                            <img src="assets/images/logo.png"/>
                                        </a>
                                    </div>
	
                                    <!-- Collect the nav links, forms, and other content for toggling -->



                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                                        <ul class="nav navbar-nav navbar-right">
                                            <li><a href="index.jsp">Home</a></li>
                                            <li><a href="index.jsp#intake">Intake</a></li>
                                            <li><a href="index.jsp#blog">Preparation</a></li>
                                            <li><a href="index.jsp#portfolio">Combination</a></li>
                                            <li><a href="index.jsp#choose"> About us</a></li>
                                            <li><a href="index.jsp#contact">Contact</a></li>


                                            <li>
                                                <a href="#"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                                    <span class="fa fa-search"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <form class="navbar-form" role="search">
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" placeholder="Search">
                                                            </div>
                                                        </form>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>


                                    </div>

                                </div>
                                
                            </nav>
                            </div>
                        </div>	
                    </div>

                </div>

            </div>
        </header> <!--End of header -->

        <section class="secondPageIsi">
        			
                <div class="container">
    			<div class="row">
                    <div class="main_mix_content sections">
                    		<!--  IMAGE HEADER -->
                        <div class="head_title text-center">
                        <%
                            String getFood = request.getParameter("food");
                                		%>
                        					<img src="assets/images/<%= getFood.replace("_"," ") %>.jpg" class="img-circle" height="180px"/><br/>
                            <h2><%=  getFood.replace("_"," ") %></h2>
						</div>
						
						<!--  START CONTENT -->
                        <div id="mixcontent" class="mixcontent">
                        
                            <%
						    DataRetriever dr = new DataRetriever();
						    ArrayList<String> methodsList = dr.getPreparationMethod(getFood);
						    String methodReplace = "";
						    for (String method : methodsList ) {
						    	methodReplace = method.replace("_", " ");
						    	%>
						    	<!--  START LOOPING FOR PREPARATION METHOD -->
                            <div class="panel-group" id="accordion">
							  <div class="panel panel-default">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							         <img src="assets/images/<%= method %>.png" alt="" width="25px" /><a data-toggle="collapse" href="#<%= method %>">&nbsp;<%= methodReplace %></a>
							      </h4>
							    </div>
							    <%
							      if(!(methodsList.size()==1 && methodsList.get(0).equals("Raw"))){
							    	  %>
							    <!--  INNER OF PREPARATION METHOD WHICH ARE DISHES, INGREDIENTS AND INTAKE TIME -->
							    <div id="<%= method %>" class="panel-collapse collapse">		
							      <div class="panel-body">
							         
							      <%
								    ArrayList<String> dishList = dr.getDish(method,getFood);
								    String dishReplace = "";
								    if(dishList.size()>0){
								    for (String dish : dishList ) {
								    	dishReplace = dish.replace("_", " ");
								    	
								    	%>
								    	<!--  START LOOPING FOR DISHES WHERE THERE ARE THIS CURRENT FOOD AS AN INGREDIENT -->
								    	 <div class="panel-group" id="accordion2">
							              <div class="panel panel-default">
							                  <div class="panel-heading">
							                      <h4 class="panel-title">
							        <a data-toggle="collapse" data-parent="#accordion2" href="#<%= dish %>">
							        <img src="assets/images/<%= dishReplace %>.jpg" alt="" height="30px" /> &nbsp;<%= dishReplace %>
							        </a>
							        </h4>
							        </div>
							        <!--  INNER OF DISHES WHICH ARE INGREDIENTS AND INTAKE TIME -->
							        <div id="<%= dish %>" class="panel-collapse collapse">
                      					<div class="panel-body">
                      					<h5> Ingredients: </h5>
                      					<ul class="list-group">
                      					
							       <%
							       	
								    ArrayList<String> ingredientList = dr.getIngredient(dish);
								    String ingReplace = "";
								    for (String ing : ingredientList ) {
								    	ingReplace = ing.replace("_", " ");
								    	%>
								    	
								    	<!--  START LOOPING FOR INGREDIENTS -->
								    	
							        <li class="list-group-item"><%= ingReplace %></li>
							        <% } %>
							        </ul>
							        <!--  STOP LOOPING FOR INGREDIENTS -->
							        
							        <h5>Taken for: </h5>
							        	<ul class="list-group">
                      					
							       <%
								    ArrayList<String> intakeList = dr.getIntakeTime(dish);
								    for (String intake : intakeList ) {
								    	%>
								    	<!--  START LOOPING FOR INTAKE TIME -->
							        <li class="list-group-item"><%= intake %></li>
							        <% }%>
							        </ul>
							        <!--  STOP LOOPING FOR INTAKE TIME -->
												 </div>
							                  </div>
							              </div>
							          </div>
							        
							      <% }} %>
<%  }else{ %>
<div id="<%= method %>" class="panel-collapse collapse in">
	<div class="panel-body">
	<h5>Made into: </h5>
							        	<ul class="list-group">
                      					
							       <%
								    ArrayList<String> purposeList = dr.getPurpose(getFood);
								    for (String purpose : purposeList ) {
								    	%>
								    	<!--  START LOOPING FOR INTAKE TIME -->
							        <li class="list-group-item"><%= purpose %></li>
							        <% }%>
							        </ul>
	<h5> Taken for: </h5>
	<ul class="list-group">
	<%
ArrayList<String> intake = dr.getIntakeOthers(getFood);
for (String in : intake ) {
	
	%>
		<!--  START LOOPING FOR INTAKE TIME -->
<li class="list-group-item"><%= in %></li>
<% }%>
</ul>
<!--  STOP LOOPING FOR INTAKE TIME -->

		 </div>
      </div>
  </div>
</div>
<%} %> 
<!--  STOP LOOPING FOR DISHES-->
</div>
</div>
</div>
	
	
	
						    <% } %>
                     
                     <!--  STOP LOOPING FOR PREPARATION METHOD-->      
                            <div class="gap"></div>
                        </div>
                    </div>                     
                </div>
            </div>
                    
                </div>
        </section>
        
        
        
        
        
        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/jquery.mixitup.min.js"></script>
        <script src="assets/js/jquery.easing.1.3.js"></script>
        <script src="assets/css/skills/inview.min.js"></script>
        <script src="assets/css/skills/progressbar.js"></script>
        <script src="assets/css/skills/main.js"></script>



        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
	</div>
    </body>
</html>