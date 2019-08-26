package zuoye1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {
    /**
     * 读取xml学生列表信息
     */
    public List<Student> listStudent(){
        SAXReader reader=new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File("d:/student.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //获取根节点元素对象
        Element node = document.getRootElement();
        return elementMethod(node);
    }

    private List<Student> elementMethod(Element node){
        List<Student> list = new ArrayList<Student>();
        //获取所有class 节点
        List<Element> elementClass = node.elements("class");
        for (Element aClass : elementClass) {
            //获取所有student节点
            List<Element> elelmentStu=aClass.elements("student");
            for (Element element : elelmentStu) {
                //创建学生对象
                Student stu = new Student();
                //class节点里name的值
                stu.setSclazz(aClass.attribute("name").getValue());
                //student节点里ID的值
                stu.setSid(element.attribute("id").getValue());
                //student节点里的String值
                stu.setSname(element.getStringValue());

                list.add(stu);
            }
        }

        return list;
    }

    public class Student {
        private String sname;
        private String sid;
        private String sclazz;
        public String getSname() {

            return sname;
        }
        public void setSname(String sname) {

            this.sname = sname;
        }
        public String getSid() {

            return sid;
        }
        public void setSid(String sid) {

            this.sid = sid;
        }
        public String getSclazz() {

            return sclazz;
        }
        public void setSclazz(String sclazz) {

            this.sclazz = sclazz;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "sname='" + sname + '\'' +
                    ", sid='" + sid + '\'' +
                    ", sclazz='" + sclazz + '\'' +
                    '}';
        }
    }
    public static class StudentDaoTest {
        public void testlistStudent(){
            List<Student> list = new XmlUtil().listStudent();
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        new StudentDaoTest().testlistStudent();
    }
}