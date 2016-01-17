import java.lang.*;

public class InnerClassDemo{
    
    static int i = 2;
    int j = 1;
    
    public static void main(String args[]){
        InnerClassDemo icd = new InnerClassDemo();
        
        InnerClassDemo.InnerClass ic = icd.new InnerClass();
        ic.display();
    }
    
    public class InnerClass{
        public void display(){
           System.out.println("Inside Inner Class " + i); 
        }
    }
}  