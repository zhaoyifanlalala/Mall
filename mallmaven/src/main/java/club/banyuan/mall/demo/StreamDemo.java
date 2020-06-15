package club.banyuan.mall.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        List<String> list2 = list.stream()
                .filter(name -> name.equals("张三") || name.equals("王五"))
                .map(name -> name + " 是土豪")
                .collect(Collectors.toList());

        System.out.println(list2);
    }
}