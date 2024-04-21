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
    @Test
    void testVerifierEmptyJson(){
        String Invalid = """
                {}
                """;
        assertFalse(JsonVerifier.verifyJson(Invalid));
    }
    @Test
    void testVerifierInvalidFile(){
        String Invalid = "not a Json";
        assertFalse(JsonVerifier.verifyJson(Invalid));
    }
    @Test
    void testVerifierMissingResource(){
        String Invalid =  """
                {
                    "PolicyDocument": {
                        "Statement": [
                            {
                                "Not resource: ""
                            }
                        ]
                    }
                }
                """;
        assertFalse(JsonVerifier.verifyJson(Invalid));
    }

}