package com.epam.tc.hw6;

import io.qameta.allure.Allure;
import java.io.InputStream;

public class AttachmentUtils {

    public static void attachFromInputStream(final String name, final InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

}
