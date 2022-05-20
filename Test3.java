import java.text.SimpleDateFormat;
import java.util.*;

public class Test3 {

    public static long randomNum(long min, long max) {

        return (long) (Math.random() * (max - min) + min);
    }

    static HashMap<Long , Long> rawData = new HashMap<>();
    static HashMap<String , Long> finalData = new HashMap<>();

    public static void main(String[] args) {
        //First day of last month
        Calendar mycalander = Calendar.getInstance();

        mycalander.add(Calendar.MONTH, -1);
        mycalander.set(Calendar.DATE, 1);
        mycalander.set(Calendar.HOUR_OF_DAY, 0);
        mycalander.set(Calendar.MINUTE, 0);
        mycalander.set(Calendar.SECOND, 0);
        mycalander.set(Calendar.MILLISECOND, 0);

        Date lastMonth1Date = mycalander.getTime();
        long epochTime1Date = lastMonth1Date.getTime();


        Calendar mysecondCal = Calendar.getInstance();

        mysecondCal.add(Calendar.MONTH, -1);
        mysecondCal.set(Calendar.DATE, mysecondCal.getActualMaximum(Calendar.DATE));
        mysecondCal.set(Calendar.HOUR_OF_DAY, 23);
        mysecondCal.set(Calendar.MINUTE, 59);
        mysecondCal.set(Calendar.SECOND, 59);
        mysecondCal.set(Calendar.MILLISECOND, 999);

        Date lastMonthLastDate = mysecondCal.getTime();

        long epochTimeLastDate = lastMonthLastDate.getTime();

        for(int i = 0; i< 500; i++){
            rawData.put( randomNum( epochTime1Date , epochTimeLastDate ) , randomNum( 10, 20 ) );
        }


        long [] keys = new long[mysecondCal.getActualMaximum(Calendar.DATE)];
        for( int d = 1; d <= mysecondCal.getActualMaximum(Calendar.DATE) ; d++ ){

            keys[d-1] = d+(mysecondCal.get(Calendar.MONTH)+1)+mysecondCal.get(Calendar.YEAR);
            String key =  d+ "/" + (mysecondCal.get(Calendar.MONTH)+1) + "/" + mysecondCal.get(Calendar.YEAR);
            finalData.put( key, 0L );
        }

        for( Long ll : rawData.keySet() ){
//            System.out.println( ll );
            Calendar cal = Calendar.getInstance();
            cal.setTime( new Date(ll));
            String key =  cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);

//            System.out.println(key);
//            if(finalData.get(key) != null){
            try{
                finalData.put( key , finalData.get(key) + rawData.get(ll) );
            } catch (Exception d){
                System.out.println("err start");
                System.out.println(key);
                System.out.println("err end");
            }
        }
        TreeMap<String, Long> treeMap = new TreeMap<>();

        for( String ss : finalData.keySet()){
            System.out.println( ss+ " : " + finalData.get(ss) );
            Calendar calendar = Calendar.getInstance();
            String[] split = ss.split("/");
            calendar.set(Calendar.MONTH , Integer.parseInt(split[1])-1);
            calendar.set(Calendar.YEAR , Integer.parseInt(split[2]));
            calendar.set(Calendar.DATE , Integer.parseInt(split[0]));
            treeMap.put(calendar.getTime().getTime()+"-"+ss , finalData.get(ss));
        }

        System.out.println("----------------");

        for( String string : treeMap.keySet() ){
            String[] split = string.split("-");
            System.out.println( split[1] + " = "  + treeMap.get(string));
        }
    }
}