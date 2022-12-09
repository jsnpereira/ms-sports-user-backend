package com.sports.user.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JSR310Module());
//        mapper.registerModule(registerStatusModuleMapper());
        return mapper;
    }



//    public SimpleModule registerStatusModuleMapper() {
//        SimpleModule simpleModule = new SimpleModule("JSONEventTypeModule", PackageVersion.VERSION);
//        simpleModule.addDeserializer(RegisterStatus.class, new RegisterStatusDeserialize());
//        simpleModule.addSerializer(RegisterStatus.class, new RegisterStatusSerializer());
//        return simpleModule;
//    }
//
//    class RegisterStatusSerializer extends StdSerializer<RegisterStatus> {
//
//        protected RegisterStatusSerializer() {
//            super(RegisterStatus.class);
//        }
//
//        @Override
//        public void serialize(RegisterStatus registerStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeString(registerStatus.name());
//        }
//    }
//
//    class RegisterStatusDeserialize extends StdDeserializer<RegisterStatus> {
//        public RegisterStatusDeserialize() {
//            super(RegisterStatus.class);
//        }
//
//        @Override
//        public RegisterStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
//
//            String value = jsonParser.getText();
//            return RegisterStatus.valueOf(value);
//        }
//    }
}
