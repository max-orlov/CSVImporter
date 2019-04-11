package servlets;

import com.google.gson.Gson;
import dataBase.DAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/top_forms")
public class TopFormsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List list = DAO.executeSQLQuery("SELECT formid, COUNT(*)\n" +
                "FROM forms\n" +
                "GROUP BY formid\n" +
                "ORDER BY COUNT(*) desc");

        List<List<String>> result = new ArrayList<>();
        for (int i = 0, count = 0; i < list.size() && count < 5; i++) {
            Object[] columns = (Object[]) list.get(i);
            if(!columns[0].equals("")){
                List<String> row = new ArrayList<>();
                for (Object column : columns)
                    row.add(column.toString());
                result.add(row);
                count++;
            }
        }
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(result));
        DAO.closeOpenedSession();
    }
}
