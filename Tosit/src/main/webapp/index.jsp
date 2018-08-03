<%@ page import="com.aneon.po.User" %>
    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <meta name="description" content="">
            <meta name="author" content="">
            <title>Tosit教学管理系统</title>

            <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
            <link rel="apple-touch-icon" href="apple-touch-icon.png">

            <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
            <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="resources/css/tooplate-style.css">
        </head>

        <body class="abc" onload="check(); return false;">
            <script>
                function check() {
          <% User user = (User)session.getAttribute("User");
                    if (user != null) { %>
                        $("#zh").css("display", "none");
                        $("#mm").css("display", "none");
                        $("#loginBtn").css("display", "none");
                        $("#name").html('<%=  user.getName() %>');
                        $("#hello").css("display", "inline");
                        $("#backend").css("display", "inline");
          <%  } %>
      }
            </script>

            <!-- 顶部导航栏 -->
            <nav class="navbar navbar-expand-lg bg-light navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">TOSIT学员管理系统</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <form class="form-inline my-2 my-lg-0" id="navbarNavDropdown">
                        <input type="text" placeholder="用户名" name="zh" id="zh" class="form-control mr-sm-2 ">
                        <input type="password" placeholder="密码" name="mm" id="mm" class="form-control mr-sm-2">
                        <button class="btn btn-secondary" onclick="login(); return false;" id="loginBtn">登录</button>
                        <a class="text-dark " id="hello" style="display: none">
                            <span id="name"></span>，您好</a>
                        <a class="text-dark ml-sm-2" id="backend" href="pages/backend.jsp" style="display: none">进入后台</a>
                    </form>
                </div>
            </nav>

            <section class="first-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="text-content">
                                <h2>Welcome To Tosit</h2>
                                <div class="line-dec"></div>
                                <span>这是一个简单易用的教学系统</span>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class="second-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <div class="icon">
                                    <img src="resources/img/first-icon.png" alt="">
                                </div>
                                <h4>Efficient</h4>
                                <p>Help training teachers (including administrators) to effectively manage training projects and students.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <div class="icon">
                                    <img src="resources/img/second-icon.png" alt="">
                                </div>
                                <h4>Practical</h4>
                                <p>Perfect coverage of daily management operations and complete functions,and avoid a lot of mistakes in management</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <div class="icon">
                                    <img src="resources/img/third-icon.png" alt="">
                                </div>
                                <h4>Concise</h4>
                                <p>The interface is crisp and concise, and the daily tasks are done easily.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <div class="icon">
                                    <img src="resources/img/fourth-icon.png" alt="">
                                </div>
                                <h4>Cooperation</h4>
                                <p>Help teachers and students cooperate to complete projects, facilitate group management and control.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <ul>
                                <li>
                                    <a href="https://github.com/charliepublic/Stupid">
                                        <i class="fa fa-github"></i>
                                    </a>
                                </li>
                            </ul>
                            <p>Copyright &copy; 2018 四只小猪</p>
                        </div>
                    </div>
                </div>
            </footer>

            <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

            <script src="resources/js/index.js"></script>

        </body>

        </html>