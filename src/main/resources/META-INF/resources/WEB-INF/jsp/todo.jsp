<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
       <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <title>Add Todo page</title>
    </head>

    <body>
        <div class="container">
            <h1>Enter Todo details: </h1>
            <%--@elvariable id="todo" type="ToDo"--%>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description: </form:label>
                    <form:input type="text" path="description" required="required" />
                    <form:errors path="description" cssClass="text-warning" />
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target date: </form:label>
                    <form:input type="text" path="TargetDate" required="required" />
                    <form:errors path="TargetDate" cssClass="text-warning" />
                </fieldset>
                Done: <form:checkbox path="done" value="${todo.done}"/>
                <form:input type="hidden" path="id" />
                <input type="submit" class="btn btn-success">
            </form:form>

        </div>

        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
        <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">$('#TargetDate').datepicker({
            format: 'yyyy-mm-dd',
        });
        </script>
    </body>
</html>