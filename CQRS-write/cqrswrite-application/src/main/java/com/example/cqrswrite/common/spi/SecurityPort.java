package com.example.cqrswrite.common.spi;

import java.util.UUID;

public interface SecurityPort {

    UUID getCurrentUserId();

    String encodePassword(String password);

    boolean matchesPassword(String rawPassword, String encodedPassword);
}
