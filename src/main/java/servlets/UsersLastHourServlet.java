package servlets;

import com.google.gson.Gson;
import csv.CSVUtil;
import dataBase.DAO;
import model.Form;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/users_last_hour")
public class UsersLastHourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List list = DAO.getAllObjects(Form.class);
        Gson gson = new Gson();

        try {
            List<Form> res = usersLastHour(list);
            resp.getWriter().write(gson.toJson(res));
            System.out.println(gson.toJson(res));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DAO.closeOpenedSession();
    }

    public ArrayList<Form> usersLastHour(List<Form> forms) throws ParseException {
        ArrayList<Form> users = new ArrayList<>();
        Date date = new Date();
        for (int i = 0; i < forms.size(); i++) {
            if(forms.get(i).getYmdh() != null) {
                long dif = date.getTime() - CSVUtil.stringToDate(forms.get(i).getYmdh()).getTime();
                if (dif >= 0 && dif <= 3600000)
                    users.add(forms.get(i));
            }
        }
        return users;
    }
}

