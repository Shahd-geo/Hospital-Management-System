package utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.UUID;

public class HelperUtils {
    private static final Random random = new Random();


    // *****Null Check Methods (Overloaded)*****

    // Check if Object is null
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    // Check if String is null OR empty
    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Check if Object is NOT null
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    // Check if String is NOT null AND not empty
    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }




