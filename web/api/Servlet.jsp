<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: mrezachalak
  Date: 2/27/18
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>School Management System</title>
    <style>
        div.container {
            width: 100%;
            border: 1px solid gray;
        }

        header, footer {
            padding: 1em;
            color: white;
            background-color: black;
            clear: left;
            text-align: center;
        }

        nav {
            float: left;
            max-width: 160px;
            margin: 20px;
            padding: 1em;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
        }

        nav ul a {
            text-decoration: none;
        }

        article {
            margin-left: 170px;
            border-left: 1px solid gray;
            padding: 1em;
            overflow: hidden;
        }
    </style>
</head>

<body>
<div class="container">

    <header>
        <h1>Student Teacher</h1>
    </header>

    <nav>
        <ul>
            <pre>Student Addition Form:</pre>
            <form id="AddStudent" action="/AddStudent" method="post" >
                Student's ID:<br>
                <input type="text" name="id" value=""><br>
                Student's name:<br>
                <input type="text" name="name" value=""><br>
                Age:<br>
                <input type="text" name="age" value=""><br>
                Student's Department:<br>
                <input type="text" name="department" value=""><br>
                Student's teacher ID:<br>
                <input type="text" name="teacherid" value="">
                <br><br>
                <input type="submit" value="Submit">
            </form>

        </ul>
    </nav>

    <nav>
        <ul>
            <pre>Teacher Addition Form:</pre>
            <form id="AddTeacher" action="/AddTeacher" method="post" onsubmit="return submitForm(this);">
                Teacher's ID:<br>
                <input type="text" name="id" value=""><br>
                Teacher's name:<br>
                <input type="text" name="name" value=""><br>
                Teacher's Department:<br>
                <input type="text" name="department" value=""><br>
                <br><br>
                <input type="submit" value="Submit">
            </form>

        </ul>
    </nav>
    <article id="info">

    </article>

    <nav>
        <ul>
            <form id="RemoveStudent" action="/RemoveStudent" method="post" onsubmit="return submitForm(this);">
                Student's ID to remove:<br>
                <input type="text" name="id" value=""><br>
                Student's name:<br>
                <br><br>
                <input type="submit" value="Submit">
            </form>

        </ul>
    </nav>

    <%--<article>--%>
        <%--<h1>London</h1>--%>
        <%--<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>--%>
        <%--<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>--%>
    <%--</article>--%>
    <input id="ListOfStudents" type="submit" onclick="window.location= '/ListOfStudents';" value="show Students List" onsubmit="return submitForm(this)">
    <input id="ListOfTeachers" type="submit" onclick="window.location='/ListOfTeachers';" value="show Teachers List" onsubmit="return submitForm(this)">

    <footer>Implemented by Java Servlet/JSP </footer>

</div>

<script>
    function submitForm(form) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for older browsers
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onsubmit = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("id").innerHTML =
                    this.responseText;
            }
        };
        xmlhttp.open(form.method, form.address, true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send(form.FormData);//form.FormData

    }
</script>

</body>
</html>
