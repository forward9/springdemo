package jaxb2;

import javax.annotation.Resource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;


/**
 * @author Henry
 * 
 */
@Component
public class MarshalAndUnmarshalService {

    @Resource
    private Marshaller marshaller;

    @Resource
    private Unmarshaller unmarshaller;


    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }


    public Marshaller getMarshaller() {
        return this.marshaller;
    }


    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }


    public Unmarshaller getUnmarshaller() {
        return this.unmarshaller;
    }
}