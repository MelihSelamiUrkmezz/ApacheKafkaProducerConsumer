import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KConsumer{
    public static void main(String[] args) throws Exception {
       Properties prop=new Properties();
       prop.put("bootstrap.servers","localhost:9092");
       prop.put(ConsumerConfig.GROUP_ID_CONFIG,"Consumer Group 1");
       prop.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
       prop.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer"); 

       KafkaConsumer<String,String> cons=new KafkaConsumer<String,String>(prop);
       cons.subscribe(Arrays.asList("msu"));
       while(true){

        ConsumerRecords<String,String> records=cons.poll(Duration.ofMillis(100));

        for(ConsumerRecord<String,String> consrec:records){

            System.out.printf("Offset:%d Key:%s Value:%s",consrec.offset(),consrec.key(),consrec.value());
        }
       } 
    }
}
