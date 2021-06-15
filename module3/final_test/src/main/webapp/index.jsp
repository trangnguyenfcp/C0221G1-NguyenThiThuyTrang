<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2021
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Knight Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Knight - v2.2.1
  * Template URL: https://bootstrapmade.com/knight-free-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>


<!-- ======= Header ======= -->
<header id="header" class="d-flex align-items-center">
  <div class="container">

    <!-- The main logo is shown in mobile version only. The centered nav-logo in nav menu is displayed in desktop view  -->
    <div class="logo d-block d-lg-none">
      <a href="index.jsp"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>
    </div>

    <nav class="nav-menu d-none d-lg-block">
      <ul class="nav-inner">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li><a href="/employee">Employee</a></li>
        <li><a href="/customer">Customer</a></li>
        <li><a href="/product">Product</a></li>
        <li><a href="/contract">Contract</a></li>

        <li class="nav-logo"><a href="index.jsp"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>
        </li>


        <li>
          <div class="row footer-newsletter justify-content-center">
            <div class="#search">
              <form action="" method="post">
                <input type="email" name="email" placeholder="Search"><input type="submit"
                                                                             value="Search">
              </form>
            </div>
          </div>
        </li>
        <li class="drop-down"><a href="">Nguyễn Thị Thùy Trang</a>
          <ul>
            <li><a href="#about">Services</a></li>
            <li><a href="#team">Team</a></li>

            <li class="drop-down"><a href="#">Deep Drop</a>
              <ul>
                <li><a href="#">Deep Drop Down 1</a></li>
                <li><a href="#">Deep Drop Down 2</a></li>
                <li><a href="#">Deep Drop Down 3</a></li>
                <li><a href="#">Deep Drop Down 4</a></li>
                <li><a href="#">Deep Drop Down 5</a></li>
              </ul>
            </li>
          </ul>
        </li>
      </ul>
    </nav><!-- .nav-menu -->

  </div>
</header><!-- End Header -->

<main id="main">

  <!-- ======= Services Section ======= -->
  <section id="services" class="services">
    <div class="container">

      <div class="section-title" data-aos="fade-up">
        <h2>Services</h2>
        <p>Magnam dolores commodi suscipit eius consequatur ex aliquid fuga eum quidem</p>
      </div>

      <div class="row">
        <div class="col-lg-6 order-2 order-lg-1">
          <div class="icon-box mt-5 mt-lg-0" data-aos="fade-up">
            <i class="bx bx-receipt"></i>
            <h4>Item One</h4>
            <p>Consequuntur sunt aut quasi enim aliquam quae harum pariatur laboris nisi ut aliquip</p>
          </div>
          <div class="icon-box mt-5" data-aos="fade-up" data-aos-delay="100">
            <i class="bx bx-cube-alt"></i>
            <h4>Item Two</h4>
            <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt</p>
          </div>
          <div class="icon-box mt-5" data-aos="fade-up" data-aos-delay="200">
            <i class="bx bx-images"></i>
            <h4>Item Three</h4>
            <p>Aut suscipit aut cum nemo deleniti aut omnis. Doloribus ut maiores omnis facere</p>
          </div>
          <div class="icon-box mt-5" data-aos="fade-up" data-aos-delay="300">
            <i class="bx bx-shield"></i>
            <h4>Item Four</h4>
            <p>Expedita veritatis consequuntur nihil tempore laudantium vitae denat pacta</p>
          </div>
        </div>
        <div class="image col-lg-6 order-1 order-lg-2"
             style='background-image: url("https://i.pinimg.com/originals/3b/8a/d2/3b8ad2c7b1be2caf24321c852103598a.jpg");'
             data-aos="fade-left" data-aos-delay="100"></div>
      </div>

    </div>
  </section><!-- End Services Section -->
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer">

  <div class="footer-top">

    <div class="container">

      <div class="row justify-content-center">
        <div class="col-lg-6">
          <a href="#header" class="scrollto footer-logo"><img src="assets/img/hero-logo.png" alt=""></a>
          <h3>Knight</h3>
          <p>Et aut eum quis fuga eos sunt ipsa nihil. Labore corporis magni eligendi fuga maxime saepe
            commodi placeat.</p>
        </div>
      </div>
      <div class="social-links">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
      </div>

    </div>
  </div>

  <div class="container footer-bottom clearfix">
    <div class="copyright">
      &copy; Copyright <strong><span>Knight</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
      <!-- All the links in the footer should remain intact. -->
      <!-- You can delete the links only if you purchased the pro version. -->
      <!-- Licensing information: https://bootstrapmade.com/license/ -->
      <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/knight-free-bootstrap-theme/ -->
      Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
  </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

<!-- Vendor JS Files -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/jquery-sticky/jquery.sticky.js"></script>
<script src="assets/vendor/venobox/venobox.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="assets/vendor/aos/aos.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

</body>
</html>
