package csv;

import model.Form;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CSVUtil {
    private File csvFile;
    private String data;

    public CSVUtil(String csvFile) throws IOException {
        this.setCsvFile(csvFile);
    }

    public void setCsvFile(String csvFile) throws IOException {
        this.csvFile = new File(csvFile);
        this.loadData();
    }

    public void loadData() throws IOException {
        try (FileInputStream inputStream = new FileInputStream(this.csvFile)) {
            byte[] ar = new byte[inputStream.available()];
            inputStream.read(ar, 0, ar.length);
            this.data = new String(ar);
        }
    }

    public static Date stringToDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d-h");
        Date date = sdf.parse(s);
        return date;
    }

    public static String dateToString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d-H");
        String s = sdf.format(date);
        return s;
    }

    public ArrayList<Form> parseForms() throws ParseException {
        ArrayList<Form> forms = new ArrayList<>();
        String[] strings = this.data.split("\n");
        for (int i = 1; i < strings.length; i++) {
            String[] dat = strings[i].split(";");
            if(dat.length == 12)
                forms.add(new Form(dat[0], Long.valueOf(dat[1]), dat[2], dat[3],
                        dat[4], dat[5], dat[6], dat[7], dat[8], dat[9], dat[10], dat[11]));
            else if(dat.length == 3)
                forms.add(new Form(dat[0], Long.valueOf(dat[1]), dat[2]));
        }
        return forms;
    }
}
