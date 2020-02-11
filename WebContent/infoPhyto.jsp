<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,mc.processor.DataRetriever,mc.vo.Phytochemical"
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
                                            <li><a href="index.jsp#food">Food</a></li>
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
						<div class="col-sm-12">
							<%
							DataRetriever dr = new DataRetriever();
						    String phyto = request.getParameter("phyto");	// get phytochemical name url parameter
						    Phytochemical phytoInfo = dr.getPhytochemicalsInfo(phyto);
							    %>
							    </span>
							    <table class="table table-bordered" width="100%">
												<thead>
													<tr>
														<th>Class</th>
														<th>Values</th>

													</tr>
												</thead>
												<tbody>
													<tr>
														<td><span style="font-weight: bold">
																Phytochemical Name </span></td>
														<td><span style="font-weight: bold"> <%=phyto
			%>
														</span></td>
													</tr>

													<%
		//out.println(phytoInfo.getBenefit().size());
		if(phytoInfo.getBenefit().size()> 0){
		%>
													<tr>
														<td><span style="font-weight: bold"> Benefit </span></td>
														<td><span style="font-weight: bold"> <%
				for (String benefit : phytoInfo.getBenefit()) {
					%> <%=benefit %><br /> <%
				}
				%>
														</span></td>
													</tr>
													<%} %>

													<%
		//out.println(phytoInfo.getProperty().size());
		if(phytoInfo.getProperty().size()> 0){
		%>
													<tr>
														<td><span style="font-weight: bold"> Property
														</span></td>
														<td><span style="font-weight: bold"> <%
				for (String property : phytoInfo.getProperty()) {
					%> <%=property %><br /> <%
				}
				%>
														</span></td>
													</tr>
													<%} %>
													
													<tr>
														<td colspan="2" style="text-align:center;"><a href="javascript:history.go(-1);"><button type="button" class="btn ipmcdBackButton btn-info btn-primary">Back</button></a></td>
													</tr>
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