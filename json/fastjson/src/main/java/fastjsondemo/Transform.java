package fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;

public class Transform {

    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
        //JSON格式字符串与JSON对象之间的转换
        JSONObject jsonObject1 = JSON.parseObject(JSON_OBJ_STR);
        //判断jsonObject中是否含有对应的key值
        System.out.println(jsonObject1.containsKey("studentName"));  //true
        System.out.println(jsonObject1.containsKey("notexist"));     //false
        //获取jsonObject对象中的值
        System.out.println(jsonObject1.containsValue("lily"));       //true
        System.out.println(jsonObject1.get("studentName"));          //lily
        System.out.println(jsonObject1.getInteger("studentAge"));     //12

        JSONObject jsonObject2 = JSON.parseObject(COMPLEX_JSON_STR);
        //获取jsonObject
        System.out.println(jsonObject2.getJSONObject("course"));    //{"code":1270,"courseName":"english"}
        //获取JSONArray
        System.out.println(jsonObject2.getJSONArray("students"));   //[{"studentAge":12,"studentName":"lily"},{"studentAge":15,"studentName":"lucy"}]
        System.out.println(jsonObject2.getJSONArray("students").get(0));    //{"studentAge":12,"studentName":"lily"}
        //简单json和javabean转换
        Student student = JSON.parseObject(JSON_OBJ_STR, Student.class);
        System.out.println(student);
        //数组类型与JavaBean_List之间的转换
        ArrayList<Student> list = (ArrayList<Student>) JSON.parseArray(JSON_ARRAY_STR, Student.class);
        for (Student s : list) {
            System.out.println(s);
        }
        //建议用这种
        ArrayList<Student> students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        for (Student s : students) {
            System.out.println(s);
        }
        //复杂json格式字符串与与javaBean之间的转换
        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});

        //TypeReference<T>，由于其构造方法使用 protected 进行修饰，所以在其他包下创建其对象的时候，要用其实现类的子类：new TypeReference<Teacher>() {}
    }

}
