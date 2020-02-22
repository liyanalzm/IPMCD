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
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        <style>
		.clickable{
		    cursor: pointer;   
		}

		.panel-heading div {
			margin-top: -18px;
			font-size: 15px;
		}
		.panel-heading div span{
			margin-left:5px;
		}
		.panel-body{
			display: none;
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
                            <%@ include file="navSecond.jsp" %>
                            </div>
                        </div>	
                    </div>

                </div>

            </div>
        </header> <!--End of header -->
<% 
						String action = request.getParameter("action");
					%>
        <section class="secondPageIsi">
                <div class="container">
    			<div class="row">
    			<ol class="breadcrumb">
						  <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
						  <li class="breadcrumb-item active"><a href="index.jsp#food">Food</a></li>
						  <li class="breadcrumb-item active">Allowed <%=  action %></li>
						</ol>
			<div class="col-sm-12">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="panel-title">Lists of Allowed <%= action %></h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body">
								<i class="fa fa-filter"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="task-table-filter" data-action="filter" data-filters="#task-table" placeholder="Filter Tasks" />
					</div>
					<table class="table table-hover" id="task-table">
						<thead>
							<tr>
								<th>#</th>
								<th>Foods</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
						<% 
								
							
								DataRetriever dr = new DataRetriever();
                                 ArrayList<String> allowedFood = null;
                                 
                                 /**To retrieve all allowed foods based on each category**/
                                 if(action.equalsIgnoreCase("Vegetables")){
                                	 	allowedFood = dr.getAllAllowedVegetables();
                                 }else if(action.equalsIgnoreCase("Meats")){
         							allowedFood = dr.getAllAllowedMeats();
                                 }else if(action.equalsIgnoreCase("Fruits")){
         							allowedFood = dr.getAllAllowedFruits();
                                 }else if(action.equalsIgnoreCase("Herbs")){
         							allowedFood = dr.getAllAllowedHerbs();
                                 }else if(action.equalsIgnoreCase("Others")){
         							allowedFood = dr.getAllAllowedOthers();
                                 }
         								    
									int count = 1; 
								    for (String food : allowedFood ) {
						    			String foodSpace = food.replace("_", " ");
										%>
										<tr>
											<td><%= count %></td>
											<td><%= foodSpace %></td>
											<td><a href="info.jsp?food=<%= food %>" ><button class="btn btn-primary">Details</button></a></td>
							</tr>
							<% 
										count++;
									}
    							    %>
						</tbody>
					</table>
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