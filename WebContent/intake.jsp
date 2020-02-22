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

        <section class="secondPageIsi">
                <div class="container">
		    			<div class="row">
		    			 
					<div class="col-sm-12">
						<section id="portfolio" class="portfolio">
            <div class="container">
                <div class="row">
                
                    <div class="main_mix_content sections">
                    <ol class="breadcrumb">
						  <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
						  <li class="breadcrumb-item active"><a href="index.jsp#intake">Intake</a></li>
						  <li class="breadcrumb-item active"><%=  request.getParameter("intake") %></li>
						</ol>
                        <div class="head_title text-center ">
                            <h2>Suggestions for <%=  request.getParameter("intake") %>.</h2>

                        <div id="mixcontent" class="mixcontent">
                        
                            <%
                            String intake = request.getParameter("intake");
						    DataRetriever dr = new DataRetriever();
						    ArrayList<String> dishes = dr.getFoodsForIntake(intake);
						    String dishReplace = "";
						  
						    for (String dish : dishes ) {
						    	dishReplace = dish.replace("_", " ");
						    	if(dr.getParentClass(dish).equals("Dish")){
						    	%>
                            <div class="col-md-4 mix no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= dishReplace %>.jpg" alt="<%= dishReplace %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= dishReplace %></h2>
                                                <p>CLICK TO KNOW ITS INGREDIENTS</p>
                                            <a href="ingredients.jsp?dish=<%= dish %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
						    	}else{
						    		%>
						    			<div class="col-md-4 mix no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= dishReplace %>.jpg" alt="<%= dishReplace %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= dishReplace %></h2>
                                                <p>CLICK TO KNOW MORE</p>
                                            <a href="ipdetails.jsp?food=<%= dish %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
						    		<%
						    		
						    	}
						    	}
						    
						    	%>

                           
                            <div class="gap"></div>
                        </div>
                    </div>                     
                </div>
            </div>
            </div>
        </section> <!-- End of portfolio two Section -->       
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