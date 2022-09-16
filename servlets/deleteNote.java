package ucl.ac.uk.servlets;

import ucl.ac.uk.model.Model;
import ucl.ac.uk.model.ModelFactory;
import ucl.ac.uk.model.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.*;

/*@WebServlet("/delete.html")
public class deleteNote extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model

        Model model = ModelFactory.getModel();
        List<Note> ournotes = model.getNotes();
        request.setAttribute("notes", ournotes);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllNotes.jsp");
        dispatch.forward(request, response);
    }

}*/
@WebServlet("/delete.html")
public class deleteNote extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model

        Model model = ModelFactory.getModel();
        try {
            model.deleteNote(request.getParameter("deletion"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String filename = request.getParameter("name");;

        String file = "./data/" +filename + ".txt";
        File f= new File(file);
        if(f.delete())                      //returns Boolean value
        {
            System.out.println(f.getName() + " deleted");   //getting and printing the file name
        }

            List<Note> notes = model.getNotes();
        request.setAttribute("notes", notes);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllNotes.jsp");
        dispatch.forward(request, response);
    }
}