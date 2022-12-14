package DataStructure.map;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *    Map是java中的接口，Map.Entry是Map的一个内部接口。
 *
 *    Map提供了一些常用方法，如keySet()、entrySet()等方法。
 *
 *    keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
 *
 *    Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
 *    它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
 */
public class MapLearning {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时</span>
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

        System.out.println(map.getOrDefault("key1", "value0")); // return value1
        System.out.println(map.getOrDefault("key0", "value0")); // return value0

        String s = "ababsdafg";
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1); // map.put(key, map.getOrDefault(key, defaultValue) + 1)
        }
        System.out.println(map1.toString());


    }

    @Test
    public void basic_test() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> x = map.getOrDefault("key1", new ArrayList<>());
        x.add("value1");
        x.add("value2");
        map.put("key1", x);
//        System.out.println(map.toString());

        map.computeIfAbsent("key2", val -> new ArrayList<>()).add("value3");
        // 如果是Value以Collection的形式存在，可以用 computeIfAbsent 对value赋值新的Collection。类似getOrDefault
        map.get("key2").add("value4");
        System.out.println(map.toString());
    }

    @Test
    public void basic_test1() {
        Map<String, Integer> map = new HashMap();

        map.put("1", 8);
        map.put("2", 12);
        map.put("3", 53);
        map.put("4", 33);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);

        Collection<Integer> c = map.values();

        Object[] obj = c.toArray();

        Arrays.sort(obj);

        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        System.out.println(list.get(0).getKey()); // "6"

        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
        System.out.println(list.get(0).getKey()); // "3"

    }

    @Test
    public void basic_test2() {
//        Map<Integer, Integer> map = new Hashtable<>()
    }


}
