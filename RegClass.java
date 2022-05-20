import java.util.regex.Pattern;

public class RegClass {

    public static void main(String[] args) {

        String ll = "eelDupaNicponia"; ///mondayTime

        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)+");

        System.out.println(pattern.matcher(ll).matches());

//        System.out.println( );
//
//        String email = "fsdfsdfsd@ewh.erer.ere";
//
//        System.out.println(validemail(email));
//
    }

    /*  CaMeL CaSE
            String ll = "caMel"; ///mondayTime

        Pattern pattern = Pattern.compile("[a-z][a-z]*[A-Z][a-z]*");

        System.out.println(pattern.matcher(ll).matches());
     */



    static boolean validemail(String str){
        if( !str.contains("@") ){
            return false;
        }

        String[] breaks = str.split("@");

        if( breaks.length != 2 ){
            return false;
        }

        breaks[0] =  breaks[0].replace("." , "");
        breaks[0] =  breaks[0].toLowerCase();

        if( breaks[0].length() == 0 || breaks[1].length() == 0){
            return false;
        }
        if(isSpecial(breaks[0])){
            return false;
        }

        breaks[1] =  breaks[1].toLowerCase();

        if(breaks[1].charAt(0) == '.' || breaks[1].charAt(breaks[1].length()-1) == '.'){
            return false;
        }

        String[] b2 = breaks[1].split("\\.");

        if( b2.length > 2 ){
            return false;
        } else if(b2.length == 2){

            if( b2[0].length() == 0 || b2[1].length() == 0){
                return false;
            }
            if(isSpecial(b2[0]) || isSpecial(b2[1])){
                return false;
            }
        } else{
            if(isSpecial(b2[0]) || b2[0].length() == 0){
                return false;
            }
        }
        return true;
    }

    static boolean isSpecial(String str){
        for(int i = 0; i < str.length() ; i++ ){
            if( !( (str.charAt(i) >= 'a' &&  str.charAt(i) <= 'z')  || (str.charAt(i) >= '0' &&  str.charAt(i) <= '9'))){
                return true;
            }
        }
        return false;
    }
}

