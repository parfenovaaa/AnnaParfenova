package com.epam.tc.hw4;

import io.qameta.allure.Allure;
import java.io.InputStream;

public class AttachmentUtils {

    private AttachmentUtils() {

    }

    public static void attachFromInputStream(final String name, final InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

}
