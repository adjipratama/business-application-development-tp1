package bilanganprima;

/**
 *
 * @author Adji
 */

import java.util.Scanner;

public class BilanganPrima {
    
    public static void main(String[] args) {
        int bilangan, bagi=0;
        boolean prima=true;
        
        // Scanner object
        Scanner input = new Scanner(System.in);
        
        // Input angka
        System.out.print("Input sebuah bilangan bulat : ");
        bilangan = input.nextInt();
        
        if(bilangan <= 1){
            // Jika bilangan kurang dari 1
            System.out.println(bilangan+" bukan bilangan prima karena kurang dari 2");
        }else{
           
            // Mencari bilangan prima menggunakan looping
            for (int i = 2; i <= Math.sqrt(bilangan) ; i++) {
                
                // Jika bilangan bukan bilangan prima, looping dihentikan
                if(bilangan % i == 0){
                    prima = false;
                    bagi = i;
                    break;
                }
            }
            
            if(prima){
                System.out.println(bilangan+" adalah bilangan prima");
            }else{
                System.out.println(bilangan+" bukan bilangan prima karena bisa dibagi "+bagi);
            }
        }
    } 
    
}
