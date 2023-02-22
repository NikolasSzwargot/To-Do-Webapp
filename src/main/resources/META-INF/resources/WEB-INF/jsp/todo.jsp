<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <%--@elvariable id="todo" type="ToDo"--%>
            <form:form method="post" modelAttribute="todo">
                Description: <form:input type="text" path="description" required="required" />
                <form:errors path="description" cssClass="text-warning" />
                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <input type="submit" class="btn btn-success">
            </form:form>

        </div>
    </body>
</html>