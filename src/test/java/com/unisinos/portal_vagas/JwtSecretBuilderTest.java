package com.unisinos.portal_vagas;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

public class JwtSecretBuilderTest {

    @Test
    public void generateSecret() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encondedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nChave = [%s]\n", encondedKey);
    }
}
