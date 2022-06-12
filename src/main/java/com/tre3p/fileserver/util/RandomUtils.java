package com.tre3p.fileserver.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Component
public class RandomUtils {

    private static final int MIN_PASSWORD_LENGTH = 40;
    private static final int MAX_PASSWORD_LENGTH = 100;
    private static final int MAX_HASH_LENGTH = 15;

    /**
     * This method used for generation random password for each file which is gonna be zipped.
     * @return String which contains random generated bytes.
     * @throws NoSuchAlgorithmException
     */
    public String generateRandomPassword() throws NoSuchAlgorithmException {
        byte[] result = new byte[generateRandomIntFromRange()];
        SecureRandom.getInstanceStrong().nextBytes(result);
        return new String(result);
    }

    /**
     * @return String which contains random generated hash for FileMetadata.
     */
    public String generateRandomAlphaNumericHash() {
        return RandomStringUtils.randomAlphanumeric(MAX_HASH_LENGTH);
    }

    private int generateRandomIntFromRange() {
        return new Random().nextInt(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
    }

}