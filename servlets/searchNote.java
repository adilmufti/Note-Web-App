package ucl.ac.uk.servlets;

import ucl.ac.uk.model.Model;
import ucl.ac.uk.model.ModelFactory;
import ucl.ac.uk.model.Note;
import ucl.ac.uk.servlets.addNote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/runsearch.html")
public class searchNote extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model
        Model model = ModelFactory.getModel();
        List<String> search = model.searchFor(request.getParameter("searchstring"));
        request.setAttribute("input", search);

        for(int i = 0; i < search.size(); i++) {
            model.getNoteFromName(search.get(i));
        }

        List<Note> notes = model.getNotes();
        request.setAttribute("notes", notes);
        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
        dispatch.forward(request, response);
    }
}
