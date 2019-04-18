package servlets;

import com.google.gson.Gson;
import dataBase.DAO;
import model.Form;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users_not_completed")
public class UsersNotCompletedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List list = DAO.getAllObjects(Form.class);
        Gson gson = new Gson();

        try {
            List<Form> res = usersNotCompleted(list);
            resp.getWriter().write(gson.toJson(res));
            System.out.println(gson.toJson(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DAO.closeOpenedSession();

    }

    public ArrayList<Form> usersNotCompleted(List<Form> forms) {
        ArrayList<Form> users = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String subtype = forms.get(i).getSubtype();
            if(subtype != null && subtype.equals("start"))
                users.add(forms.get(i));
        }
        return users;
    }
}
