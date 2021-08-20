package yanolza;

import yanolza.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired PaymentHistoryRepository paymentHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveCanceled_CancelPayment(@Payload ReserveCanceled reserveCanceled){

        if(!reserveCanceled.validate()) return;

        System.out.println("\n\n##### listener CancelPayment : " + reserveCanceled.toJson() + "\n\n");



        // Sample Logic //
        // PaymentHistory paymentHistory = new PaymentHistory();
        // paymentHistoryRepository.save(paymentHistory);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
