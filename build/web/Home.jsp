 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

        <!-- Core theme JS-->
        <script src="js/scripts_home.js"></script>
        <link href="css/styles_home.css" rel="stylesheet" />
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->


    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav" style="padding: 5px !important;">
            <div class="container" style="margin-left: 40px; margin-right: 30px">
                <a class="navbar-brand" href="home"><img src="images/Logo/Logo_Black.png" style="height: 50px" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">                            
                        <li class="nav-item"><a class="nav-link" href="#sliders">Sliders</a></li>
                        <li class="nav-item"><a class="nav-link" href="#subjects">Subjects</a></li>
                        <li class="nav-item"><a class="nav-link" href="#posts">Posts</a></li>
                        <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <!--        <header class="masthead" style="background-image: url('images/bg-header.jpg')">
                    <div class="container">
                        <div class="masthead-subheading">Welcome To Quiz Question!</div>
                        <div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
                        <a class="btn btn-primary btn-xl text-uppercase" href="#subjects">Tell Me More</a>
                    </div>
                </header>-->

        <!-- Slider --!>
        <!-- Carousel -->
        <section class="page-section bg-light" id="sliders" style="padding-top: 5px">
            <div id="demo" class="carousel slide" data-bs-ride="carousel">

                <!-- Indicators/dots -->
                <div class="carousel-indicators">
                    <c:forEach begin="0" end="${requestScope.totalSliderShow - 1}" var="sl">
                        <button type="button" data-bs-target="#demo" data-bs-slide-to="${sl}" class="${sl == 0?"active":""}"></button>
                    </c:forEach>
                </div>

                <!-- The slideshow/carousel -->
                <div class="carousel-inner">
                    <c:forEach items="${sessionScope.listSlider}" var="sl">
                        <div class="carousel-item ${sl.sliderId == sessionScope.minSliderId?"active":""}">
                            <a href="subject-detail?id=${sl.subId}"><img src="uploads/${sl.sliderUrl}" alt="" class="d-block w-100"></a>

                        </div>
                    </c:forEach>
                </div>

                <!-- Left and right controls/icons -->
                <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </button>
            </div>
        </section>

        <!-- Subjects-->
        <section class="page-section bg-light" id="subjects" style="padding-top: 0px">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Subjects</h2>
                </div>
                <div class="row">
                    <c:forEach items="${listSubjects}" var="S">
                        <div class="col-lg-4 col-sm-6 mb-4">
                            <!-- Portfolio item 1-->
                            <div class="subjects-item">
                                <a class="subjects-link" data-bs-toggle="modal" href="#S${S.subjectId}">
                                    <div class="subjects-hover">
                                        <div class="subjects-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                    </div>
                                    <img class="img-fluid mx-auto d-block" src="${S.thumbnail}" alt="..." />
                                </a>
                                <div class="subjects-caption">
                                    <div class="subjects-caption-heading">${S.subjectName}</div>
                                </div>
                            </div>
                        </div>

                        <div class="subjects-modal modal fade" id="S${S.subjectId}" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="close-modal" data-bs-dismiss="modal"><img src="assets/img_home/close-icon.svg" alt="Close modal" /></div>
                                    <div class="container">
                                        <div class="row justify-content-center">
                                            <div class="col-lg-8">
                                                <div class="modal-body">
                                                    <!-- Project details-->
                                                    <h2 class="text-uppercase">${S.subjectName}</h2>
                                                    <img class="img-fluid d-block mx-auto" src="${S.thumbnail}" alt="..." />
                                                    <p>${S.description}</p>
                                                    <button class="btn btn-primary btn-xl text-uppercase" data-bs-dismiss="modal" type="button">
                                                        <i class="fas fa-xmark me-1"></i>
                                                        Close ${S.subjectName}
                                                    </button>
                                                    <a href="subject-detail?id=${S.getSubjectId()}" class="btn btn-primary btn-xl text-uppercase">
                                                        Detail of ${S.subjectName}
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>


        <!-- Post-->
        <section class="page-section" id="posts">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Post</h2>
                </div>
                <ul class="timeline">
                    <c:forEach items="${list3FirstPosts}" var="P">
                        <li class="${P.postId % 2 == 1?"timeline-inverted":""}">
                            <div class="timeline-image"><img class="rounded-circle img-fluid" src="images/${P.thumbnail}" alt="..." /></div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>${P.created_date}</h4>
                                    <h4 class="subheading">${P.title}</h4>
                                </div>
                                <div class="timeline-body"><p class="text-muted">${P.content}</p></div>
                            </div>
                        </li>
                    </c:forEach>

                    <li class="timeline-inverted">
                        <div class="timeline-image">
                            <h4>
                                Be Part
                                <br />
                                Of Our
                                <br />
                                Story!
                            </h4>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
        <!-- Clients-->
        <div class="py-5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img_home/logos/microsoft.svg" alt="..." aria-label="Microsoft Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img_home/logos/google.svg" alt="..." aria-label="Google Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img_home/logos/facebook.svg" alt="..." aria-label="Facebook Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img_home/logos/ibm.svg" alt="..." aria-label="IBM Logo" /></a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-start">Copyright &copy; Your Website 2023</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-end">
                        <a class="link-dark text-decoration-none me-3" href="#!">Privacy Policy</a>
                        <a class="link-dark text-decoration-none" href="#!">Terms of Use</a>
                    </div>
                </div>
            </div>
        </footer>

    </body>
    <style>
        #mainNav .navbar-nav .nav-item .nav-link.active, #mainNav .navbar-nav .nav-item .nav-link:hover {
            color: #9e8a41 !important;
        }
    </style>
</html>
