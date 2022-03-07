from socket import timeout
from confluent_kafka import Consumer


conf={'bootstrap.servers':"localhost:9092",'group.id':"ConsGroup"}

cons=Consumer(conf)

def basic_loop(consumer,topics):

    try:
        consumer.subscribe(topics)

        while True:
            msg=consumer.poll(timeout=1.0)

            if msg is None: continue

            if msg.error():
                print("Beklenmedik bir hata oluştu.")
            else:
                print("Gelen mesaj:{}".format(msg.value().decode('utf-8')))
    finally:
        consumer.close()


basic_loop(consumer=cons,topics=["msu"])

            
