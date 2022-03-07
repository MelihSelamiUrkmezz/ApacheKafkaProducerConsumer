import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KProducer {
    public static void main(String[] args) throws Exception {
       Properties prop=new Properties();
       prop.put("bootstrap.servers","localhost:9092");
       prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
       prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer"); 

       Producer<String,String> prod=new KafkaProducer<>(prop);
       prod.send(new ProducerRecord<String,String>("msu","12","12")); 
       prod.close();
    
    
    
    }
}
