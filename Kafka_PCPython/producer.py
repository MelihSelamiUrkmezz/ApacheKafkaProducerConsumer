from confluent_kafka import Producer
import json 
import random

conf={'bootstrap.servers':"localhost:9092"}

producer=Producer(conf)

def sonuc(err,msg):
    if err is not None:
        print("Hatalı bir gönderim.")
    else:
        print("Gönderme işlemi başarılı.")



"""with open("system_logs.json") as jsonfile:

    jsonobject=json.load(jsonfile)
    jsonfile.close()

for x in jsonobject:
    if x["type"]=='system':
        producer.produce("msu2",key="Melih Selami Urkmez",value=str(x),callback=sonuc,partition=0)
    else:
        producer.produce("msu2",key="Melih Selami Urkmez",value=str(x),callback=sonuc,partition=1)
"""

for x in range(1,10):
    producer.produce("msu",key="Melih Selami Urkmez",value=str(x),callback=sonuc)




producer.poll(1)