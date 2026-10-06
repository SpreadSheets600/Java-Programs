import java.io.*;
import java.util.Scanner;
class A{
String S;
int arr[]=new int[5];
void Input()
{
Scanner sc =new Scanner(System.in);
int i;
for(i=0;i<5;i++){
try{
arr[i]=sc.nextInt();
if(arr[i]%10!=0){
ArithmeticException e=new ArithmeticException();
throw e;
}
}
catch(ArithmeticException e){
System.out.println("Array elments must be divided by ten");
}
}
}
//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//S=br.readLine(); 
void display(){
System.out.println(S);
}
}
class kamila{
public static void main(String args[])
{
A obj= new A();
//try{
//obj.input();
//}
//(IOException e){
//System.out.print("IO Exception generated");
obj.Input();
//System.out.println(obj.calculate(12,2));
//obj.display();
}
}
