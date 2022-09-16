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
    <%
        Note note = (Note) request.getAttribute("note");
        String deletion = note.getTitle() + "," + note.getNoteBody() + ",";
        String name = note.getTitle();
    %>
    <h2><%=note.getTitle()%></h2>
    <span><strong>Your Note: </strong><%=note.getNoteBody()%></span>
    <br>
    <br>
    <a href="viewEditNote.html?noteId=<%=note.getTitle()%>">Edit Note</a>
    <br>
    <a href="delete.html?deletion=<%=deletion%>">Delete Note</a>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>