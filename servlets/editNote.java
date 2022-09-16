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

@WebServlet("/edit.html")
public class editNote extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model
        Model model = ModelFactory.getModel();
        String filename = request.getParameter("title");
        String filebody = request.getParameter("note");
        System.out.println(request.getParameter("original"));
        String edited = filename + "," + filebody + ",";
        System.out.println(edited);
        try {
            model.editNote(request.getParameter("original"), edited);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO: Edit the correct note in the model
        //TODO: Update with new title and body

        List<Note> notes = model.getNotes();
        request.setAttribute("notes", notes);
        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllNotes.jsp");
        dispatch.forward(request, response);
    }
}
