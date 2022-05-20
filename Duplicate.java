import java.util.HashMap;

public class Duplicate {
    public static void main (String[] args) {
        int [] isMarry = {1, 2, 3, 1, 1, 1, 4, 3};

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < isMarry.length; i++) {
            if(hashMap.containsKey(isMarry[i])) {
                hashMap.put(isMarry[i], hashMap.get(isMarry[i])+1);
            } else {
                hashMap.put(isMarry[i],1);
            }
        }
        for (Integer i : hashMap.keySet()){
            System.out.println(i + " , " + hashMap.get(i));
        }

    }
}
