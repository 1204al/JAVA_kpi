package workshop.task_1_1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class AbbrivationBuilder {


    public static String build(List<String> list) {
//        StringBuilder sb=new StringBuilder();
//        list.forEach(str->{
//            if(str!=null&&str.length()!=0){
//                sb.append(str.charAt(0));
//            }
//        });
//        // implement function body in order all tests to complete successfully
//        return String.valueOf(sb);

        return list.stream().filter(e->e!=null&&!e.isEmpty()).map(e->e.substring(0,1)).reduce("",(s1,s2)->s1+s2);
    }

    public static void main(String[] args) {

    }

}
