//U fajlu je dat niz od n brojeva.
// Sa dva prolaska kroz niz odrediti da li postoji broj koji se pojavljuje više od n/2 puta.
// (Traži se algoritam je složenosti O(n)).
//        Ulaz 				    Izlaz
//        n = 9 			    broj 5
//        5 7 1 1 5 5 2 5 5

package zadatak12;

import java.util.HashMap;
import java.util.Map;

public class Zadatak12 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 1, 5, 5, 2, 5, 5};
        Integer ret = recurrentNum(arr, arr.length);
        if(ret != null){
            System.out.println(ret);
        }else{
            System.out.println("Ne postoji broj u nizu koji se pojavljuje vise od n/2 puta");
        }
    }
    public static Integer recurrentNum(int[] arr, int n){
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            int num = arr[i];
            if(!arrMap.containsKey(num)){
                arrMap.put(num, 1);
            }else{
                arrMap.put(num, arrMap.get(num)+1);
            }
        }
        for (Map.Entry<Integer, Integer> kv : arrMap.entrySet()){
            if(kv.getValue() >= n/2){
                return kv.getKey();
            }
        }
        return null;
    }
}
