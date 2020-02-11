"use strict";


jQuery(document).ready(function ($) {
		
    /*---------------------------------------------*
     * Mobile menu
     ---------------------------------------------*/
    $('#bs-example-navbar-collapse-1').find('a[href*=#]:not([href=#])').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: (target.offset().top - 40)
                }, 1000);
                if ($('.navbar-toggle').css('display') != 'none') {
                    $(this).parents('.container').find(".navbar-toggle").trigger("click");
                }
                return false;
            }
        }
    });

    /*---------------------------------------------*
     * filter
     ---------------------------------------------*/
    (function(){
        'use strict';
    	var $ = jQuery;
    	$.fn.extend({
    		filterTable: function(){
    			return this.each(function(){
    				$(this).on('keyup', function(e){
    					$('.filterTable_no_results').remove();
    					var $this = $(this), 
                            search = $this.val().toLowerCase(), 
                            target = $this.attr('data-filters'), 
                            $target = $(target), 
                            $rows = $target.find('tbody tr');
                            
    					if(search == '') {
    						$rows.show(); 
    					} else {
    						$rows.each(function(){
    							var $this = $(this);
    							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
    						})
    						if($target.find('tbody tr:visible').size() === 0) {
    							var col_count = $target.find('tr').first().find('td').size();
    							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
    							$target.find('tbody').append(no_results);
    						}
    					}
    				});
    			});
    		}
    	});
    	$('[data-action="filter"]').filterTable();
    })(jQuery);

    $(function(){
        // attach table filter plugin to inputs
    	$('[data-action="filter"]').filterTable();
    	
    	$('.container').on('click', '.panel-heading span.filter', function(e){
    		var $this = $(this), 
    			$panel = $this.parents('.panel');
    		
    		$panel.find('.panel-body').slideToggle();
    		if($this.css('display') != 'none') {
    			$panel.find('.panel-body input').focus();
    		}
    	});
    	$('[data-toggle="tooltip"]').tooltip();
    })
    
    /*---------------------------------------------*
     * STICKY scroll
     ---------------------------------------------*/

    $.localScroll();



    /*---------------------------------------------*
     * WOW
     ---------------------------------------------*/

    var wow = new WOW({
        mobile: false // trigger animations on mobile devices (default is true)
    });
    wow.init();


    /*---------------------------------------------*
     * Counter 
     ---------------------------------------------*/

    $('.statistic-counter').counterUp({
        delay: 10,
        time: 2000
    });
    $('.statistic').counterUp({
        delay: 10,
        time: 2000
    });





    /* ---------------------------------------------------------------------
     Carousel
     ---------------------------------------------------------------------= */

    $('.main_home_slider').owlCarousel({
        responsiveClass: true,
        autoplay: false,
        items: 1,
        loop: true,
        dots: true,
        nav: false,
        navText: [
            "<i class='lnr lnr-chevron-left'></i>",
            "<i class='lnr lnr-chevron-right'></i>"
        ],
        autoplayHoverPause: true

    });


    $('.main_team_content').owlCarousel({
        responsiveClass: true,
        autoplay: false,
        items: 1,
        loop: true,
        dots: false,
        nav: true,
        navText: [
            "<i class='lnr lnr-chevron-left'></i>",
            "<i class='lnr lnr-chevron-right'></i>"
        ],
        autoplayHoverPause: true

    });


    $('.main_blog').owlCarousel({
        responsiveClass: true,
        autoplay: false,
        items: 4,
        loop: true,
        dots: false,
        nav: true,
        navText: [
            "<i class='lnr lnr-chevron-left'></i>",
            "<i class='lnr lnr-chevron-right'></i>"
        ],
        autoplayHoverPause: true

    });

    $('.main_gellary_content').owlCarousel({
        responsiveClass: true,
        autoplay: false,
        items: 1,
        loop: true,
        dots: false,
        nav: true,
        navText: [
            "<i class='lnr lnr-chevron-left'></i>",
            "<i class='lnr lnr-chevron-right'></i>"
        ],
        autoplayHoverPause: true

    });




//	$('.chart').easyPieChart({
//		animate: 2000,
//           scaleColor: false,
//            lineWidth: 10,
//            lineCap: 'square',
//            size: 130,
//            trackColor: false,
//           barColor: '#498af3',
//            onStep: function (from, to, percent) {
//                $(this.el).find('.percent').text(Math.round(percent));
//            }
//	});











// main-menu-scroll

    jQuery(window).scroll(function () {
        var top = jQuery(document).scrollTop();
        var height = 300;
        //alert(batas);

        if (top > height) {
            jQuery('.navbar-fixed-top').addClass('menu-scroll');
        } else {
            jQuery('.navbar-fixed-top').removeClass('menu-scroll');
        }
    });

// scroll Up

    $(window).scroll(function () {
        if ($(this).scrollTop() > 600) {
            $('.scrollup').fadeIn('slow');
        } else {
            $('.scrollup').fadeOut('slow');
        }
    });
    $('.scrollup').click(function () {
        $("html, body").animate({scrollTop: 0}, 1000);
        return false;
    });



//    $('#menu').slicknav();

    $('#mixcontent').mixItUp({
        animation: {
            animateResizeContainer: false,
            effects: 'fade rotateX(-45deg) translateY(-10%)'
        }
    });


    $('.dropdown-menu').click(function (e) {
        e.stopPropagation();
    });


    //End
});




$(document).on("scroll", function () {
    if ($(document).scrollTop() > 120) {
        $("nav").addClass("small");
    } else {
        $("nav").removeClass("small");
    }
});

$(document).on('click','.navbar-collapse.in',function(e) {
    if( $(e.target).is('a') ) {
        $(this).collapse('hide');
    }
});

