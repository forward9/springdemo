package jaxb2;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author Henry
 * 
 */
public class MainTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/jaxb2/xml/student.xml");
        File tFile = new File("src/main/java/jaxb2/xml/teacher.xml");

        Student student = new Student();
        student.setId(Integer.valueOf(21231));
        student.setName("mary");

        Teacher teacher = new Teacher();
        teacher.setName("Lucy");

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(new Class[] { SpringConfigure.class });

        MarshalAndUnmarshalService maus =
                (MarshalAndUnmarshalService) ctx.getBean(MarshalAndUnmarshalService.class);

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