import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String s = JSON.toJSONString(new Student("1", "2"));
        String s1 = JSON.toJSONString(new Student(), SerializerFeature.WriteMapNullValue);
        System.out.println(s);
        System.out.println(s1);
        String name="{\n" +
                "\"name\": \"lisi\"\n" +
                "}";
        String name1 = "[{\"name\": \"lisi\"},\n" +
                "{\"name\": \"lisi\"},\n" +
                "{\"name\": \"lisi\"},\n" +
                "{\"name\": \"lisi\"},\n" +
                "{\"name\": \"lisi\"}]";
        Student student = JSON.parseObject(name, Student.class);
        List<Student> students = JSON.parseArray(name1, Student.class);
        List<Student> student1 = (List<Student>) JSON.parseObject(name1, List.class);
        System.out.println(student.getName());
        System.out.println(students);
        System.out.println(student1);
        testDate();
    }

    public static void testDate(){
        Date date = new Date();
        String s = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss:SS");
        System.out.println("test Date ===>"+s);
    }
}

class Student{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }
}