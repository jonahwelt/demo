<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
    <head>
        <title>First Web Application</title>
    </head>
    <body>
        <h1>Here are the list of ${name}'s todos:</h1>
        <table>
            <caption>Your todos are</caption>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Taget Date</th>
                    <th>Is it Done?</th>
                </tr>
                <tbody> 
                    <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </thead>
        </table>
    </br>
    <a href="/add-todo"> Add a todo</a>
    </body>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</html>