<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
       <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>Add Todo page</title>
    </head>

    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.min.js"></script>

    <body>
        <div class="container">
            <h1>Enter Todo details: </h1>
            <form method="post">
                Description: <input type="text" name="description">
                Target Date: <input type="date" name="date">
                <input type="submit" class="btn btn-success">
            </form>

        </div>
    </body>
</html>