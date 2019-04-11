package program;

import csv.CSVUtil;
import dataBase.DAO;
import model.Form;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws ParseException, IOException {
        try {
            CSVUtil util = new CSVUtil("test_case.csv");
            ArrayList<Form> forms = util.parseForms();
            DAO.addObjects(forms);
        } catch (IOException e) {
            if(e instanceof FileNotFoundException)
                System.out.println("File Not Found!");
            else {
                System.out.println("Input Error!");
                e.printStackTrace();
            }
        } catch (ParseException e) {
            System.out.println("Incorrect date format!");
        }
    }
}
