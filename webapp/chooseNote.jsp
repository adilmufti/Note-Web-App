<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ucl.ac.uk.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Your Note</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">

    <p>Click on a note title to see the full note.</p>
    <ul>
        <%
            List<Note> ournotes = (ArrayList<Note>) request.getAttribute("notes");
            for (Note note : ournotes)
            {
        %>
            <li>><%=note.getTitle()%>
            </li>
        <% } %>
    </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

