import java.util.Random;
import java.util.Scanner;

public class Numberguessinggame {
   public Numberguessinggame() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      Random var2 = new Random();
      System.out.println("Welcome to the Number Guessing Game!");
      int var3 = 0;

      String var9;
      for(boolean var4 = true; var4; var4 = var9.equalsIgnoreCase("yes")) {
         int var5 = var2.nextInt(100) + 1;
         int var6 = 0;
         byte var7 = 5;
         System.out.println("I have selected a number between 1 and 100. Can you guess it?");

         while(var6 < var7) {
            System.out.print("Enter your guess: ");
            int var8 = var1.nextInt();
            var1.nextLine();
            ++var6;
            if (var8 == var5) {
               System.out.println("Congratulations! You guessed the number " + var5 + " in " + var6 + " attempts.");
               ++var3;
               break;
            }

            if (var8 < var5) {
               System.out.println("Too low! Try again.");
            } else {
               System.out.println("Too high! Try again.");
            }
         }

         if (var6 >= var7) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + var5 + ".");
         }

         System.out.print("Do you want to play again? (yes/no): ");
         var9 = var1.nextLine();
      }

      System.out.println("Game over! Your score: " + var3);
      var1.close();
   }
}
