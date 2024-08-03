    <%@ include file = "common/header.jspf"%>
    <%@ include file = "common/navigation.jspf"%>

    <body>
        <div class="container">
            <h1>Welcome ${username}</h1>
            <a href="list-todos">Manage</a> your Todos
        </div>
        
        <script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>