package jaxb2;

import javax.annotation.Resource;


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