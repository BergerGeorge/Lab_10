import java.util.Scanner;
public class SafeInput
{

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + ": ");
            System.out.println("");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                done = true;

            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid int not " + trash);
                System.out.println("Please try again!");

            }
        } while (!done);
        System.out.println("You entered " + result);
        return result;

    }

    public static double getDouble(Scanner pipe, String prompt) {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + ": ");
            System.out.println("");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                done = true;

            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid double not " + trash);
                System.out.println("Please try again!");

            }
        } while (!done);
        System.out.println("You entered " + result);
        return result;

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]");
            System.out.println("");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();

                if (result >= low && result <= high) //if its in range
                {
                    done = true;
                } else {
                    System.out.println(result + " is out of range [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid int not " + trash);
                System.out.println("Please try again!");

            }
        } while (!done);
        System.out.println("You entered " + result);
        return result;

    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]");
            System.out.println("");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();

                if (result >= low && result <= high) //if its in range
                {
                    done = true;
                } else {
                    System.out.println(result + " is out of range [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid int not " + trash);
                System.out.println("Please try again!");

            }
        } while (!done);
        System.out.println("You entered " + result);
        return result;

    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String answer = "";
        boolean yn = false;
        boolean done = false;
        do
        {
            System.out.print(prompt + "[Y/N]: ");
            answer = pipe.nextLine();
            if (answer.equalsIgnoreCase("Y"))
            {
                done = true;
                yn = true;
            }

            else if(answer.equalsIgnoreCase("N"))
            {
                done = true;
                yn = false;
            }
        }while(!done);

        return yn;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String result = "";
        boolean done = false;
        do
        {
            System.out.print(prompt + ": ");
            result = pipe.nextLine();
            if(result.matches(regEx))
                done = true;
            else
                System.out.println("\nMust match the pattern: "+result);

        }
        while(!done);
        return result;
    }



}
