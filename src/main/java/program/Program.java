package program;

import csv.CSVUtil;
import dataBase.DAO;
import model.Form;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ParseException, IOException {

// Загрузка объектов из csv файла----------------------------------------------------------------------------

        /*try {
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
        }*/

//------------------------------------------------------------------------------------------------------------

 //Созданте нового объекта за последний час-------------------------------------------------------------------

        /*Form form = new Form("index", 12345L, "group", "evType", "veSubtype", "www...", "original",
                "Form", "uqCode", "ltps???", "aaaaa", CSVUtil.dateToString());
        System.out.println(form);
        DAO.addObject(form);*/

    //---------------------------------------------------------------------------------------------------------
    }
}
