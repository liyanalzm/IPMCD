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
                        <div class="nave_menu"><%@ include file="navSecond.jsp" %>
                            </div>
                        </div>	
                    </div>

                </div>

            </div>
        </header> <!--End of header -->





        <section class="secondPageIsi">
                <div class="container">
                    <div class="row">
                    <% String searchTerm = request.getParameter("searchTerm"); %>
                    		<h2>Search results for "<%= searchTerm %>"</h2>
                    		<div class="panel panel-success">
					<table class="table table-hover" id="task-table">
						<thead>
							<tr>
								<th>#</th>
								<th>Results</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<%
						    	
						    boolean found = false;
						    int count=1;
						    	if (searchTerm != null && !searchTerm.equals("")) {
						    		searchTerm = searchTerm.toLowerCase();
						    		DataRetriever dr = new DataRetriever();
						    		ArrayList<String> allFood = dr.getAllFoods();
						    		String origName;
						    		
						    		
						    		
						    		for (String food : allFood) {
						    			origName = food;
						    			food = food.replace('-', ' ');
						    			food = food.replace('_', ' ');
						    			food = food.toLowerCase();
						    			if (food.indexOf(searchTerm) != -1) {
						    				%>
							<tr>
								<td><%= count %></td>
								<td><%=food %></td>
								<td style="text-align:right"><a href="info.jsp?food=<%= origName %>" ><button class="btn btn-primary">Details</button></a>&nbsp;<a href="ipdetails.jsp?food=<%= origName %>" ><button class="btn btn-primary">Recipes</button></a></td>
							</tr>
							<% 
								count++;
						    			
						    			found = true;
					    			}
						    		}
					    		
					    		
					    	 	String searchTermPhyto = searchTerm;
					    		searchTermPhyto = searchTermPhyto.toLowerCase();
					    		ArrayList<String> allPhytochemicals = dr.getAllPhytochemicals();
					    		
					    		for (String phytochemical : allPhytochemicals) {
					    			origName = phytochemical;    			
					    			phytochemical = phytochemical.replace('-', ' ');
					    			phytochemical = phytochemical.replace('_', ' ');
					    			phytochemical = phytochemical.toLowerCase();
					    			if (phytochemical.indexOf(searchTermPhyto) != -1) {
					    				%>
							<tr>
								<td><%= count %></td>
								<td><%=phytochemical %></td>
								<td style="text-align:right"><a href="infoPhyto.jsp?phyto=<%= origName %>" ><button class="btn btn-primary">Details</button></a></td>
							</tr>
							<%
								count++;
					    			
			    				found = true;
					    			}
					    		}
						    	
					    		String searchTermDish = searchTerm;
					    		searchTermDish = searchTermDish.toLowerCase();
					    		ArrayList<String> allDishes = dr.getAllDishes();
					    		
					    		for (String dish : allDishes) {
					    			origName = dish;    			
					    			dish = dish.replace('-', ' ');
					    			dish = dish.replace('_', ' ');
					    			dish = dish.toLowerCase();
					    			if (dish.indexOf(searchTermDish) != -1) {
					    				%>
							<tr>
								<td><%= count %></td>
								<td><%=dish %></td>
								<td style="text-align:right"><a href="ingredients.jsp?dish=<%= origName %>" ><button class="btn btn-primary">Ingredients</button></a></td>
							</tr>
							<%
								count++;
					    			
			    				found = true;
					    			}
					    		}
						    		}
						    	
						    	
					    		
			    	if(!found){
						%>
							<tr>
								<td colspan="3">The term you searched is not in the Malay Confinement Dietary list</td>
								
								</tr>
									<% } %>
						</tbody>
					</table>
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