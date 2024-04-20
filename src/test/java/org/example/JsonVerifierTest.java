package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JsonVerifierTest {

    @Test
    void testVerifierValidJson(){
        String valid = """
                {
                    "PolicyDocument": {
                        "Statement": [
                            {
                                "Resource": ""
                            }
                        ]
                    }
                }
                """;
        assertTrue(JsonVerifier.verifyJson(valid));
    }
    @Test
    void testVerifierInvalidJson(){
        String Invalid = """
                {
                    "PolicyDocument": {
                        "Statement": [
                            {
                                "Resource": "*"
                            }
                        ]
                    }
                }
                """;
        assertFalse(JsonVerifier.verifyJson(Invalid));
    }

}