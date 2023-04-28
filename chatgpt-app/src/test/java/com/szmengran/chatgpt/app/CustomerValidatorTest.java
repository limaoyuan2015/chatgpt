package com.szmengran.chatgpt.app;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.junit.Test;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.text.ParseException;

public class CustomerValidatorTest {

    @Test
    public void testValidation() throws ParseException {
        String token = "eyJraWQiOiIxIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1ZCI6Ind4YzZlMDA4ZTNiNWI5MmRjNSIsIm5iZiI6MTY4MjY3MDQ1NCwic2NvcGUiOlsib3BlbmlkIiwic2hvcG9vIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4OCIsImV4cCI6MTY4Mzg4MDA1NCwiaWF0IjoxNjgyNjcwNDU0fQ.eEoCtf90qj1CKFedbz_5k-_Uhej9gPB3n5VuuI6ooMXsn6lAj6fXNNMsBngDAj3bqT5hYL1mLiFUvTj0w360tPVuEVuV-5ZpvfGYFgzpu2qVQT5xWOfcanw8eG2zCmwqVwm3rNETg7vdxzAfWE9giUn3WgtYVrfb9qNuPNWVdFrL92qRDGfakx354fFO4iwjeEf7CM07QqZFwSmh1RSBwTDWpTdAhETiBWvpDg3b4cnZx0jIqHoZmDIGPzrrQkkmsHDsKYL22_nJ8aLjBeXqcI5fhp-fUeW5-NIWukeC5egH1UmRTWjjyPziIEXilanYmIc7m7kgDcDi7uE48_dqTw";
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri("http://localhost:8088/rsa/publicKey").build();
        Jwt jwt = jwtDecoder.decode(token);
        System.out.println(jwt.getSubject());
    }
}
