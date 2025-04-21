package java_codingTest_study.section5_해시;
import java.util.*;
import java.lang.*;

/*
[30000, 2000, 1500000] # 상품의 가격
[20, 40]               # 쿠폰, 할인율의 단위는 % 입니다

0         1     2
[1500000,30000,2000]
[40,    20]

*(100-40)/100
 */
public class s5_00_딩코3week_숙제1 {
    private static int getMaxDiscountedPrice(List<Integer> price,List<Integer> discount){
        //*
        int price_index = 0;
        int discount_index = 0;

        int max_discounted_total = 0;

        while(price_index< price.size()&& discount_index<discount.size()) {
            max_discounted_total += price.get(price_index) * (100 - discount.get(discount_index)) / 100;
            price_index+=1;
            discount_index+=1;
        }

        while(price_index<price.size()){
            max_discounted_total += price.get(price_index);
            price_index+=1;
        }
        return max_discounted_total;



    }


    public static void main(String []args){
        List<Integer> price = Arrays.asList(30000, 2000, 1500000);
        List<Integer> discount = Arrays.asList(20,40);

//        int[] price = {30000, 2000, 1500000};
//        int[] discount = {20, 40};
//
//        Arrays.sort(price, Collections.reverseOrder());

        price.sort((a, b) -> b.compareTo(a));
        discount.sort((a, b) -> b.compareTo(a));


        System.out.println(getMaxDiscountedPrice(price,discount));
    }
}
