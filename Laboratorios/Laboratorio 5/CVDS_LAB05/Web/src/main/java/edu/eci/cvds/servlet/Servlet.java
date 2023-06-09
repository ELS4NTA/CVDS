package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
    urlPatterns = "/AngieDanielServlet"
)

public class Servlet extends HttpServlet {

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer responseWriter = response.getWriter();
        String messageResponse = "";
        String messageError = "";
        try {
            Optional<String> optId = Optional.ofNullable(request.getParameter("id"));
            int id = Integer.parseInt(optId.get());
            Todo item = Service.getTodo(id);
            ArrayList<Todo> todoList = new ArrayList<Todo>();
            todoList.add(item);
            response.setStatus(HttpServletResponse.SC_OK);
            messageResponse = Service.todosToHTMLTable(todoList);
        } catch (FileNotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            messageError = "No existe un item con el identificador dado.";
        } catch (NoSuchElementException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } catch (MalformedURLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            messageError = "Error interno en el servidor";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } finally {
            messageResponse = response.getStatus() == 200 ? messageResponse : Service.getHTMLError(response.getStatus(), messageError);
            responseWriter.write(messageResponse);
            responseWriter.flush();   
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer responseWriter = response.getWriter();
        String messageResponse = "";
        String messageError = "";
        try {
            Optional<String> optId = Optional.ofNullable(request.getParameter("id"));
            int id = Integer.parseInt(optId.get());
            Todo item = Service.getTodo(id);
            ArrayList<Todo> todoList = new ArrayList<Todo>();
            todoList.add(item);
            response.setStatus(HttpServletResponse.SC_OK);
            messageResponse = Service.todosToHTMLTable(todoList);
        } catch (FileNotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            messageError = "No existe un item con el identificador dado.";
        } catch (NoSuchElementException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } catch (MalformedURLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            messageError = "Error interno en el servidor";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            messageError = "Requerimiento invalido.";
        } finally {
            messageResponse = response.getStatus() == 200 ? messageResponse : Service.getHTMLError(response.getStatus(), messageError);
            responseWriter.write(messageResponse);
            responseWriter.flush();   
        }
    }

}
