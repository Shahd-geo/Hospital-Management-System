package utility;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

        private static final Scanner scanner = new Scanner(System.in);

        // String input
        public static String getStringInput(
                String prompt){

            String input;

            do{

                System.out.println(prompt);

                input = scanner.nextLine();

                if(HelperUtils.isNull(input)){

                    System.out.println(
                            "Input cannot be empty.");
                }

            }while(HelperUtils.isNull(input));

            return input;
        }

        // int input
        public static int getIntInput(
                String prompt){

            while(true){

                try{

                    System.out.println(prompt);

                    return Integer.parseInt(
                            scanner.nextLine());

                }catch(NumberFormatException e){

                    System.out.println(
                            "Invalid number.");
                }
            }
        }

        // overloaded int input
        public static int getIntInput(
                String prompt,
                int min,
                int max){

            int number;

            do{

                number = getIntInput(prompt);

                if(!HelperUtils.isValidNumber(
                        number,min,max)){

                    System.out.println("Number must be between " + min + " and " + max);
                }

            }while(!HelperUtils.isValidNumber(
                    number,min,max));

            return number;
        }

        // double input
        public static double getDoubleInput(
                String prompt){

            while(true){

                try{

                    System.out.println(prompt);

                    double value = Double.parseDouble(
                            scanner.nextLine());

                    if(!HelperUtils.isPositive(value)){

                        System.out.println(
                                "Number must be positive.");

                        continue;
                    }

                    return value;

                }catch(NumberFormatException e){

                    System.out.println(
                            "Invalid decimal number.");
                }
            }
        }

        // date input
        public static LocalDate getDateInput(
                String prompt){

            while(true){

                try{

                    System.out.println(prompt);

                    String input = scanner.nextLine();

                    if(HelperUtils.isValidDate(input)){

                        return LocalDate.parse(input);
                    }

                    System.out.println("Invalid date format.");

                }catch(Exception e){

                    System.out.println("Invalid date.");
                }
            }
        }

        // yes/no confirmation
        public static boolean getConfirmation(
                String prompt){

            while(true){

                System.out.println(
                        prompt + " (yes/no)");

                String answer =
                        scanner.nextLine();

                if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){

                    return true;
                }

                if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")){

                    return false;
                }

                System.out.println(
                        "Please enter yes or no.");
            }
        }
    }

