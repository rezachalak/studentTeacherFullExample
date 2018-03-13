<%--
  Created by IntelliJ IDEA.
  User: reza
  Date: 2/7/18
  Time: 4:46 PM
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
            <form id="AddStudent" action="/api/school/student/add" method="get" onsubmit='Ajax("/api/school/student/add")'>
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
            <form id="AddTeacher" action="/api/school/teacher/add" method="get" onsubmit='Ajax("/api/school/teacher/add")'>
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

    <nav>
        <ul>
            <form id="RemoveStudent" action="/api/school/student/remove" method="get" onsubmit='Ajax("/api/school/student/remove")'>
                Student's ID to remove:<br>
                <input type="text" name="id" value=""><br>
                <br><br>
                <input type="submit" value="Submit">
            </form>

        </ul>
        <ul>
            <form id="RemoveTeacher" action="/api/school/teacher/remove" method="get" onsubmit='Ajax("/api/school/teacher/remove")'>
                Teacher's ID to remove:<br>
                <input type="text" name="id" value=""><br>
                <br><br>
                <input type="submit" value="Submit">
            </form>

        </ul>
    </nav>

    <%--<input id="ListOfStudents" type="submit" onclick="window.location= '/api/school/student/getList';" value="show Students List"--%>
<%--onsubmit=ajax()>--%>
    <input type="button" name="showS" value="showStudentsList" onclick='Ajax("/api/school/student/getList")' >
    <input type="button" name="showT" value="showTeachersList" onclick='Ajax("/api/school/teacher/getList")' >
    <%--<input id="ListOfTeachers" type="submit" onclick="window.location='/api/school/teacher/getList';" value="show Teachers List"--%>
    <%--onsubmit="return submitForm(this)">--%>
    <article id="info">

    </article>

    <footer>Implemented by RESTful Web Service</footer>

</div>

<script>

    function Ajax(address) {
        console.log("I am here;");
        var xmlhttp =new XMLHttpRequest();
        // if (window.XMLHttpRequest) {
        //     xmlhttp = new XMLHttpRequest();
        // } else
        //     xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        // }
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("info").innerHTML =
                    this.responseText;
            }else {
                document.alert("OOps Something's wrong!");
            }
        };
        xmlhttp.open("GET",address,true);
        xmlhttp.setRequestHeader("Content-type", "application/json");
        xmlhttp.send();//form.FormData

    }

    // $(document).ready(function(){
    //     $("#").click(function(){
    //         $.get("https://api.myjson.com/bins/p3z17", function(data, status){
    //             // alert("Data: " + data + "\nStatus: " + status);
    //             console.log(data);
    //
    //             document.getElementById("t").innerHTML =status;
    //             // tableMaker(data);
    //
    //
    //         });
    //     });
    // });
    //
    // function tableMaker(input){
    //     var str = '<table class="table" max-width = 50% ><thead><tr>';
    //     str += '<th scope="col">id</th>';
    //     str += '<th scope="col">supervisor</th>'
    //     str += '<th scope="col">name</th></tr>'
    //     str += '</thead><tbody>';
    //     for (var i =0 ; i< input.length  ; i++) {
    //         str += '<tr><th scope="row"></tr>'
    //         str +='<td>'+input[i].id +'</td>';
    //         str +='<td>'+input[i].superviserId +'</td>';
    //         str +='<td>'+input[i].name +'</td>';
    //     }
    //     str += '</tbody></table>';
    //     return str;
    //     // document.getElementById("t").innerHTML =str;
    // }

</script>

</body>
</html>
