package utility;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class myLog {

    /**
     * Generar un log con el error
     *
     * @param msn timeHour+"\t"+sType+"\t"+myClass+"\t"+method+"\t"+msn+"\n"
     * @param type tipo de error 0 => Error, 1 => Warning, 2 => Info
     * @param method metodo donde ocurre el error
     * @param myClass Clase donde ocurre el error
     */
    public static void message(String msn, int type, String method, String myClass) {
        String sType = new myLog().getType(type);
        JOptionPane.showMessageDialog(null, sType + ": " + msn);
        String timeHour = new myLog().getTimeHour();
        String info = timeHour + "\t" + sType + "\t" + myClass + "\t" + method + "\t" + msn + "\n";
        new myLog().save(info);
    }

    private void save(String information) {
        try {
            String dirLog = System.getProperty("user.dir") + "/log/";
            String nameLog = dirLog + getMonthYear() + "log.txt";
            File dir = new File(dirLog);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileWriter archivo = new FileWriter(nameLog, true);
            archivo.write(information);
            archivo.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Retorna el tiempo Año y Mes
     *
     * @return String Year and Month
     */
    private String getMonthYear() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        return year + "-" + month;
    }

    /**
     * Retorna el tiempo con la Hora
     *
     * @return String de Time Hours
     */
    private String getTimeHour() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        //int month = c.get(Calendar.MONTH) + 1;
        //int year = c.get(Calendar.YEAR);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return getMonthYear() + "-" + day + " :: " + hour + ":" + minute + ":" + second;
    }

    /**
     * Retorna el tipo de Error
     *
     * @param type codigo del error
     * @return String del error
     */
    private String getType(int type) {
        String sType;
        switch (type) {
            case 0:
                sType = "Error";
                break;
            case 1:
                sType = "Warning";
                break;
            case 2:
                sType = "info";
                break;
            default: {
                sType = "NONE";
            }
        }
        return sType;
    }
}
