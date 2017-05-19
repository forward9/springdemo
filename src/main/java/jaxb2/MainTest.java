package jaxb2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class MainTest {
    public static void main(String[] args) throws XmlMappingException, IOException {
        File file = new File("E:/renxg_java/springxsd/src/jaxb2/xml/student.xml");
        File tFile = new File("E:/renxg_java/springxsd/src/jaxb2/xml/teacher.xml");

        Student student = new Student();
        student.setId(Integer.valueOf(21231));
        student.setName("mary");

        Teacher teacher = new Teacher();
        teacher.setName("Lucy");

        ApplicationContext ac = new AnnotationConfigApplicationContext(new Class[] { SpringConfigure.class });

        MarshalAndUnmarshalService maus =
                (MarshalAndUnmarshalService) ac.getBean(MarshalAndUnmarshalService.class);

        maus.getMarshaller().marshal(student, new StreamResult(file));
        maus.getMarshaller().marshal(teacher, new StreamResult(tFile));

        StreamSource streamSource = new StreamSource();
        streamSource.setInputStream(new FileInputStream(file));
        Object obj = maus.getUnmarshaller().unmarshal(streamSource);
        Student s = (Student) obj;
        Teacher t = (Teacher) maus.getUnmarshaller().unmarshal(new StreamSource(new FileInputStream(tFile)));

        System.out.println(s.getName());
        System.out.println(t.getName());
    }
}