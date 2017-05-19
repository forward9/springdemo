package jaxb2;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class SpringConfigure {
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        Map properties = new HashMap();
        properties.put("jaxb.formatted.output", Boolean.TRUE);
        marshaller.setClassesToBeBound(new Class[] { Student.class, Teacher.class });
        marshaller.setMarshallerProperties(properties);
        return marshaller;
    }


    @Bean
    public MarshalAndUnmarshalService marshalAndUnmarshalService() {
        return new MarshalAndUnmarshalService();
    }
}