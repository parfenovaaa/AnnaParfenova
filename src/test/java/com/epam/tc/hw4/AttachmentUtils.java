package com.epam.tc.hw4;

import io.qameta.allure.Allure;
import java.io.InputStream;
//import lombok.experimental.UtilityClass;

//@UtilityClass
public class AttachmentUtils {

    public static void attachFromInputStream(final String name, final InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

}
