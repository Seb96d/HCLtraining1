import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
    public static void main(String[]args){
        scanners();

    }



    public static void scanners(){
        Scanner scanner = new Scanner(System.in);
        String s = "temp";
        while (!(s.length()==0)){
            System.out.println("Enter a string: ");
            s = scanner.nextLine();

        }



    }


    public static void remaningdays(){

        Calendar obj = Calendar.getInstance();
        System.out.println("Current Date and time: "+ obj.getTime());
        int currDay = obj.get(Calendar.DAY_OF_MONTH);//day of month
        int currMonth = obj.get(Calendar.MONTH); //month
        int currYear = obj.get(Calendar.YEAR); //year

        int daysInCurrentMonth = YearMonth.of(currYear,currMonth+1).lengthOfMonth();
        System.out.println("Current day : " +currDay);
        System.out.println("Days in current month : " + daysInCurrentMonth);
        int remainingDays = daysInCurrentMonth-currDay;
        System.out.println("Remaining days : " + remainingDays);
    }

    private static void czas(){
        System.out.println(DAYS.MON);

        String[] names = {"a","b","c","d"};

        for (DAYS d : DAYS.values()) {
            //System.out.println(d);
        }
        System.out.println(DAYS.valueOf("MON").type);

        Date date = new Date();

        System.out.println(System.currentTimeMillis());

        long myTime = System.currentTimeMillis();

        date.setTime(myTime - 24*60*60*1000);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/Y");

        String ss = simpleDateFormat.format(date);

        System.out.println(ss);

        System.out.println("______________");
        remaningdays();

    }

    enum DAYS{MON(1, "FirstDay"),TUE(2),WED(3),THU(4),FRI(5),SAT(6),SUN(7);
        private int value;
        private String type;

        private DAYS(int v){
            this.value=v;
        }

        private DAYS(int v, String type){
            this.value = v ;
            this.type = type;
        }
    }

}
