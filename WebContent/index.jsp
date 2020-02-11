<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,mc.processor.DataRetriever" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
    </head>
    <body data-spy="scroll" data-target=".navbar-collapse">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <header id="main_menu" class="header navbar-fixed-top">            
            <div class="main_menu_bg">
                <div class="container">
                    <div class="row">
                        <div class="nave_menu">
                            <nav class="navbar navbar-default" id="navmenu">
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
                                            <li><a href="#home">Home</a></li>
                                            <li><a href="#food">Food</a></li>
                                            <li><a href="#intake">Intake</a></li>
                                            <li><a href="#blog">Preparation</a></li>
                                            <li><a href="#portfolio">Combination</a></li>
                                            <li><a href="#choose"> About us</a></li>
                                            <li><a href="#contact">Contact</a></li>


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
        </header> <!--End of header -->





        <section id="home" class="home">
            <div class="overlay">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 ">
                                    <div class="main_home wow fadeInUp" data-wow-duration="700ms">
                                        <h1>Malay Confinement Dietary</h1>
                                        <p class="subtitle">Ontology Model and Web Semantic Representation</p>

                                        <div class="home_btn">
                                            <a href="#intake" class="btn btn-primary">LEARN MORE</a>
                                        </div>

                                    </div>
                                </div>
                               
                    </div>
                </div>
            </div>
        </section>


<section id="food" class="food">
            <div class="container">
                <div class="row" align="center">
                    <div class="food_border_raund text-center"></div>
                    <div class="main_food_area sections text-center">
                        <div class="head_title text-center">
                            <h2>Learn More About The Food</h2>
                            <div class="separator"></div>

                        </div>
                        <div class="col-sm-1">
                            <div class="single_food">
                                <div class="single_food_icon">
                                    <img src="" alt="" /> 
                                </div>

                                <h3>&nbsp;</h3>
                                <p>&nbsp;</p>
                           
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single_food">
                            <a href="" data-toggle="modal" data-target="#meats">
                                <div class="single_food_icon">
                                    <img src="assets/images/meats.png" alt="" /> 
                                </div>

                                <h3>MEATS</h3>
                                <p>Meats that are allowed and restricted to be taken.</p>
                           </a>
                            </div>
                            </div>
                            
                            <div class="modal fade" id="meats" role="dialog">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Choose one</h4>
							        </div>
							        <div class="modal-body">
							          <a href="allowed.jsp?action=Meats"><button type="button" class="btn ipmcd btn-info btn-primary">Allowed Meats</button></a>
							          <a href="notallowed.jsp?action=Meats"><button type="button" class="btn ipmcd btn-info btn-primary">Restricted Meats</button></a>
							        </div>
							      </div>
							    </div>
							  </div>
                        <div class="col-sm-2">
                            <div class="single_food">
                            <a href="" data-toggle="modal" data-target="#vegetables">
                                <div class="single_food_icon">
                                    <img src="assets/images/vegetables.png" alt="" /> 
                                </div>

                                <h3>Vegetables</h3>
                                <p>Vegetables that are allowed and restricted to be taken.</p>
                           </a>
                            </div>
                        </div>
                        <div class="modal fade" id="vegetables" role="dialog">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Choose one</h4>
							        </div>
							        <div class="modal-body">
							          <a href="allowed.jsp?action=Vegetables"><button type="button" class="btn ipmcd btn-info btn-primary">Allowed Vegetables</button></a>
							          <a href="notallowed.jsp?action=Vegetables"><button type="button" class="btn ipmcd btn-info btn-primary">Restricted Vegetables</button></a>
							        </div>
							      </div>
							    </div>
							  </div>
                        <div class="col-sm-2">
                            <div class="single_food">
                            	<a href="" data-toggle="modal" data-target="#fruits">
                                <div class="single_food_icon">
                                    <img src="assets/images/fruits.png" alt="" /> 
                                </div>

                                <h3>Fruits</h3>
                                <p>Fruits that are allowed and restricted to be taken.</p>
                           </a>
                            </div>
                        </div>
                        <div class="modal fade" id="fruits" role="dialog">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Choose one</h4>
							        </div>
							        <div class="modal-body">
							          <a href="allowed.jsp?action=Fruits"><button type="button" class="btn ipmcd btn-info btn-primary">Allowed Fruits</button></a>
							          <a href="notallowed.jsp?action=Fruits"><button type="button" class="btn ipmcd btn-info btn-primary">Restricted Fruits</button></a>
							        </div>
							      </div>
							    </div>
							  </div>
                        <div class="col-sm-2">
                            <div class="single_food">
                            <a href="" data-toggle="modal" data-target="#herbs">
                                <div class="single_food_icon">
                                    <img src="assets/images/herbs.png" alt="" /> 
                                </div>

                                <h3>Herbs</h3>
                                <p>Herbs that are allowed and restricted to be taken.</p>
                           </a>
                            </div>
                        </div>
                         <div class="modal fade" id="herbs" role="dialog">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Choose one</h4>
							        </div>
							        <div class="modal-body">
							          <a href="allowed.jsp?action=Herbs"><button type="button" class="btn ipmcd btn-info btn-primary">Allowed Herbs</button></a>
							          <a href="notallowed.jsp?action=Herbs"><button type="button" class="btn ipmcd btn-info btn-primary">Restricted Herbs</button></a>
							        </div>
							      </div>
							    </div>
							  </div>
                        <div class="col-sm-2">
                            <div class="single_food">
                            <a href="" data-toggle="modal" data-target="#others">
                                <div class="single_food_icon">
                                    <img src="assets/images/others.png" alt="" /> 
                                </div>

                                <h3>Others</h3>
                                <p>Other foods that are allowed and restricted to be taken.</p>
                           </a>
                            </div>
                        </div>
                         <div class="modal fade" id="others" role="dialog">
							    <div class="modal-dialog modal-sm">
							      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							          <h4 class="modal-title">Choose one</h4>
							        </div>
							        <div class="modal-body">
							          <a href="allowed.jsp?action=Others"><button type="button" class="btn ipmcd btn-info btn-primary">Allowed Others</button></a>
							          <a href="notallowed.jsp?action=Others"><button type="button" class="btn ipmcd btn-info btn-primary">Restricted Others</button></a>
							        </div>
							      </div>
							    </div>
							  </div>
                        <div class="col-sm-1">
                            <div class="single_food">
                                <div class="single_food_icon">
                                    <img src="" alt="" /> 
                                </div>

                                <h3>&nbsp;</h3>
                                <p>&nbsp;</p>
                           
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        </section>



        


        <section id="blog" class="blog">
            <div class="container">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="main_blog_area text-center sections">
                            <div class="head_title">
                                <h2>Learn what you can do with each type of preparation method</h2>
                                <div class="separator"></div>
                                <p>Different kind of foods have different types of preparation methods. Each type of preparation methods have their own purposes. <br/>Find out more here! </p>
                            </div>

                            <div class="main_blog_content">
                                <ul class="main_blog">
                                		<a href="preparation.jsp?method=Freeze">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Freeze.png"   /> </div>
                                        <h4>FREEZE</h4>
                                        <p>Storing food below 0 degree celsius.</p>

                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Dry">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Dry.png" alt="" /></div>
                                        <h4>DRY</h4>
                                        <p>Eliminating the moisture of the food to preserve it.</p>

                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Raw">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Raw.png" alt="" /></div>
                                        <h4>RAW</h4>
                                        <p>Eating the food as it is or blending it to make a juice.</p>
                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Steaming">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Steaming.png" alt="" /></div>
                                        <h4>STEAM</h4>
                                        <p>Boiling water below the food to cook it by the steam.</p>
                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Frying">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Frying.png" alt="" /></div>
                                        <h4>FRY</h4>
                                        <p>Cooking food by using a little bit of oil.</p>
                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Boiling">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Boiling.png" alt="" /></div>
                                        <h4>BOIL</h4>
                                        <p>Cooking food in water until bubbles pop out.</p>

                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Grilling">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Grilling.png" alt="" /></div>
                                        <h4>GRILL</h4>
                                        <p>Cooking food in the oven it putting it on grill rack.</p>

                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Microwaving">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Microwaving.png" alt="" /></div>
                                        <h4>MICROWAVE</h4>
                                        <p>Reheating food by using a microwave.</p>
                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Cook_and_Drain">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Cook_and_Drain.png" alt="" /></div>
                                        <h4>COOK AND DRAIN</h4>
                                        <p>Steam, boil, grill or fry food then drain them.</p>

                                    </li>
                                    </a>
                                    <a href="preparation.jsp?method=Reheat">
                                    <li class="single_blog_content">
                                        <div class="lol">
                                        <img src="assets/images/Reheat.png" alt="" /></div>
                                        <h4>REHEAT</h4>
                                        <p>Reheating food by using a stove.</p>
                                    </li>
                                    </a>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </section>


<section id="intake" class="service">
            <div class="container">
                <div class="row">
                    <div class="service_border_raund text-center"></div>
                    <div class="main_service_area sections text-center">
                        <div class="head_title text-center">
                            <h2>DISHES FOR YOUR MEAL TIME</h2>
                            <div class="separator"></div>

                        </div>
                        <a href="intake.jsp?intake=breakfast">
                        <div class="col-sm-4">
                            <div class="single_service">
                                <div class="single_service_icon">
                                    <img src="assets/images/apple.png" alt="" />
                                </div>

                                <h3>BREAKFAST</h3>
                                <p>Learn what you can take best for your breakfast based on midwives' and dietician's preference.</p>
                            </div>
                        </div>
                        </a>
                        <a href="intake.jsp?intake=lunch">
                        <div class="col-sm-4">
                            <div class="single_service">
                                <div class="single_service_icon">
                                    <img src="assets/images/bawang.png" alt="" />
                                </div>

                                <h3>LUNCH</h3>
                                <p>Learn what you can take best for your lunch based on midwives' and dietician's preference.</p>
                            </div>
                        </div>
                        </a>
                        <a href="intake.jsp?intake=dinner">
                        <div class="col-sm-4">
                            <div class="single_service">
                                <div class="single_service_icon">
                                    <img src="assets/images/fish.png" alt="" />
                                </div>

                                <h3>DINNER</h3>
                                <p>Learn what you can take best for your dinner based on midwives' and dietician's preference.</p>
                            </div>
                        </div>
					</a>
                    </div>
                </div>
            </div>
        </section>
        

        <section id="portfolio" class="portfolio">
            <div class="container">
                <div class="row">
                    <div class="main_mix_content text-center sections">
                        <div class="head_title">
                            <h2>See which food can be combined together here.</h2>
                        </div>
                        <div class="main_mix_menu">
                            <ul>
                            		<li class="btn btn-primary filter" data-filter=".all" style="display:none;">all</li>
                                <li class="btn btn-primary filter" data-filter=".vege">VEGETABLES</li>
                                <li class="btn btn-primary filter" data-filter=".herbs">HERBS</li>
                                <li class="btn btn-primary filter" data-filter=".fruits">FRUITS</li>
                                <li class="btn btn-primary filter" data-filter=".meat">MEAT</li>
                                <li class="btn btn-primary filter" data-filter=".others">OTHERS</li>
                            </ul>
                        </div>

                        <div id="mixcontent" class="mixcontent">
                            <%
    DataRetriever dr = new DataRetriever();
    ArrayList<String> allowedVeges = dr.getAllAllowedVegetables();
    
    for (String veges : allowedVeges ) {
    	veges = veges.replace("_", " ");
    	%>
                            <div class="col-md-4 mix vege no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= veges %>.jpg" alt="<%= veges %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= veges %></h2>
                                            <p>CLICK TO KNOW MORE</p>
                                            <% veges = veges.replace(" ", "_"); %>
                                            <a href="ipdetails.jsp?food=<%= veges %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
    }
    
    ArrayList<String> allowedHerbs = dr.getAllAllowedHerbs();
    
    for (String herbs : allowedHerbs ) {
    	herbs = herbs.replace("_", " ");
    	%>
                            <div class="col-md-4 mix herbs no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= herbs %>.jpg" alt="<%= herbs %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= herbs %></h2>
                                            <p>CLICK TO KNOW MORE</p>
                                            <% herbs = herbs.replace(" ", "_"); %>
                                            <a href="ipdetails.jsp?food=<%= herbs %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                                        <%
    }
    
    ArrayList<String> allowedFruits = dr.getAllAllowedFruits();
    
    for (String fruits : allowedFruits ) {
    	fruits = fruits.replace("_", " ");
    	%>
                            <div class="col-md-4 mix fruits no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%=fruits %>.jpg" alt="<%=fruits %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%=fruits %></h2>
                                            <p>CLICK TO KNOW MORE</p>
                                            <% fruits = fruits.replace(" ", "_"); %>
                                            <a href="ipdetails.jsp?food=<%= fruits %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
}

ArrayList<String> allowedMeats = dr.getAllAllowedMeats();
for (String meats : allowedMeats ) {
	meats = meats.replace("_", " ");
%>
                            <div class="col-md-4 mix meat no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= meats %>.jpg" alt="<%= meats %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= meats %></h2>
                                            <p>CLICK TO KNOW MORE</p>
                                            <% meats = meats.replace(" ", "_"); %>
                                            <a href="ipdetails.jsp?food=<%= meats %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <%
}

ArrayList<String> allowedOthers = dr.getAllAllowedOthers();

for (String others : allowedOthers ) {
	others = others.replace("_", " ");
%>
                            <div class="col-md-4 mix others no-padding">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/<%= others %>.jpg" alt="<%= others %>" />
                                    <div class="mixi_portfolio_overlay">
                                        <div class="overflow_hover_text">
                                            <h2><%= others %></h2>
                                            <p>CLICK TO KNOW MORE</p>
                                            <% others = others.replace(" ", "_"); %>
                                            <a href="ipdetails.jsp?food=<%= others %>"><i class="fa fa-chevron-circle-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                           

                           
                            <div class="gap"></div>
                        </div>
                    </div>                     
                </div>
            </div>
        </section> <!-- End of portfolio two Section -->        


        <section id="choose" class="choose greenbackground">
            <div class="container">
                <div class="row">
                    <div class="main_choose_area sections text-center">
                        <div class="lesson_title">                      
                            <p>About this project.</p>
                        </div>
                        <div class="main_choose_content">
                            <div class="single_choose_content">
                                <div class="singel_choose_img">
                                    <img src="assets/images/choose.png" alt="" />
                                </div>

                                <h2>Malay Confinement Dietary</h2>
                                <p>This website is a semantic web representation of an ontology model that focuses on the dietary of Malay mothers in confinement. The intake and preparation scope is an integration from the previous ontology models which are the combinations of the Malay Confinement Dietary, medicinal herbs and phytochemicals. Check out the previous ontology model <a href="../index.jsp.html">here</a>.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        


        <section id="contact" class="footer_widget">
            <div class="container">
                <div class="row">
                    <div class="main_widget">


                        <div class="row">

                            <div class="col-sm-4  col-xs-12">
                                <div class="single_widget wow fadeIn" data-wow-duration="800ms">
                                    <h4 class="footer_title">CONTACT</h4>
                                    <div class="separator4"></div>
                                    <ul>
                                        <li><a href=""><i class="fa fa-envelope"></i> info@guitarchoose.com</a></li>
                                        <li><a href=""><i class="fa fa-phone"></i> 0123 456 789 0112</a></li>
                                        <li><a href=""><i class="fa fa-map-marker"></i> Greenplatz Ben 29, Germany 60435</a></li>
                                        <li><a href=""><i class="fa fa-fax"></i> (0012) 654 356 445</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_widget wow fadeIn" data-wow-duration="800ms">
                                    <h4 class="footer_title">LATEST NEWS</h4>
                                    <div class="separator4"></div>

                                    <div class="footer_gellary">
                                        <img src="assets/images/fg1.jpg" alt="" />
                                        <img src="assets/images/fg2.jpg" alt="" />
                                        <img src="assets/images/fg3.jpg" alt="" />
                                        <img src="assets/images/fg4.jpg" alt="" />
                                        <img src="assets/images/fg5.jpg" alt="" />
                                        <img src="assets/images/fg6.jpg" alt="" />
                                        <img src="assets/images/fg7.jpg" alt="" />
                                        <img src="assets/images/fg8.jpg" alt="" />
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_widget wow fadeIn" data-wow-duration="800ms">
                                    <div class="footer_logo">
                                        <img src="assets/images/footerlogo.png" alt="" />
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut in egestas lectus. 
                                        Etiam tempor odio tellus, at bibendum neque faucibus quis. Sed vel facilisis elit. </p>
                                    <p>Nullam fringilla pharetra diam non accumsan. Morbi eget aliquam mauris. 
                                        Etiam vehicula efficitur mi.</p>


                                    <a class="weblink" href="https://bootstrapthemes.co">https://bootstrapthemes.co</a>
                                </div>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </section>





        <footer id="footer" class="footer">
            <div class="container">
                <div class="main_footer">
                    <div class="row">

                        <div class="col-sm-6 col-xs-12">
                            <div class="copyright_text">
                                <p class=" wow fadeInRight" data-wow-duration="1s">Made with <i class="fa fa-heart"></i> by <a href="https://bootstrapthemes.co">Bootstrap Themes</a>2016. All Rights Reserved</p>
                            </div>
                        </div>

                        <div class="col-sm-6 col-xs-12">
                            <div class="footer_socail">
                                <a href=""><i class="fa fa-facebook"></i></a>
                                <a href=""><i class="fa fa-twitter"></i></a>
                                <a href=""><i class="fa fa-google-plus"></i></a>
                                <a href=""><i class="fa fa-rss"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>



        <!-- START SCROLL TO TOP  -->

        <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>

        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/jquery.mixitup.min.js"></script>
        <script src="assets/js/jquery.easing.1.3.js"></script>
        <script src="assets/css/skills/inview.min.js"></script>
        <script src="assets/css/skills/progressbar.js"></script>
        <script src="assets/css/skills/main.js"></script>

        <!--This is link only for gmaps-->
        <script src="http://maps.google.com/maps/api/js"></script>
        <script src="assets/js/gmaps.min.js"></script>
        <script>
            var map = new GMaps({
                el: '.ourmaps',
                scrollwheel: false,
                lat: -12.043333,
                lng: -77.028333
            });
        </script>



        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>

						 
							
    </body>
</html>
