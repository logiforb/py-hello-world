<%@tag description="mymain" pageEncoding="UTF-8"%>
<%@attribute name="mymaintitle" required="true"%>
<%@attribute name="subheadingtitle" required="true"%>
<%@attribute name="subheadingtext"%>
<%@attribute name="mycontextpath" required="true"%>
<%@taglib prefix="mytags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${mycontextpath}/resources/favicon/favicon.ico">

    <title>${mymaintitle}</title>

    <!-- Bootstrap core CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${mycontextpath}/resources/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li><a href="${mycontextpath}/">Home</a></li>
          <li><a href="${mycontextpath}/admin">Administration</a></li>
          <li><a href="${mycontextpath}/logout">Logout</a></li>
        </ul>
        <h3 class="text-muted">Project name</h3>
      </div>

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>${subheadingtitle}</h4>
          <mytags:ifnotnull value="${subheadingtext}">
              <p>${subheadingtext}</p>
          </mytags:ifnotnull>
          <jsp:doBody />

        </div>
      </div>

      <div class="footer">
        <p>&nbsp;</p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
