public class Test2 {

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

    public static void main(String[]args){
        System.out.println(DAYS.MON);

        String[] names = {"a","b","c","d"};

        for (DAYS d : DAYS.values()) {
            System.out.println(d);
        }
        System.out.println(DAYS.valueOf("MON").type);
    }
}
