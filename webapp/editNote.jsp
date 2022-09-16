<%@ page import="ucl.ac.uk.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Edit Note</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <%
        Note note = (Note) request.getAttribute("note");
        String original = note.getTitle() + "," + note.getNoteBody() + ",";
    %>
    <h1>Edit Note</h1>
    <form method="POST" action="/edit.html">
        <input type="hidden" name="original" value="<%=original%>" />
        <input type="text" name="title" size=64 value="<%=note.getTitle()%>" />
        <br>
        <br>
        <input type="text" name="note" value="<%=note.getNoteBody()%>" size=64 style="height:200px" />
        <br>
        <br>
        <input type="submit" value="Edit Note"/>
    </form>
</div>
</body>
</html>