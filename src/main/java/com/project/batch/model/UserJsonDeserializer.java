package com.project.batch.model;



import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.JsonEOFException;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.kafka.common.errors.SerializationException;


public class UserJsonDeserializer extends JsonDeserializer<user> {

   @Override
   public user deserialize(String topic, byte[] data) {
       try {
           return super.deserialize(topic, data);
       } catch (Exception e) {
           System.out.println("Problem deserializing data " + new String(data) + " on topic " + topic);
           return null;
       }
   }

}



