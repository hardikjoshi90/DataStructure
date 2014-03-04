import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;
import com.datastructure.stack.MyStack;

class StackX
{
	int []theStack;
	int maxSize;
	int top;
	
	StackX(int Size)
	{
		maxSize = Size;
		theStack = new int[maxSize];
		top = -1;
		
	}
	
	public void push(int i)
	{
		theStack[++top] = i;
	}
	
	public int pop()
	{
		return theStack[top--];
	}
	
	public int peek()
	{
		return theStack[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==maxSize);
	}
	
	public int size(){
		return top+1;
	}
}


public class Power {

	static StackX sx = new StackX(100);
	static StackX sy = new StackX(100);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Demonstrating X power Y");
		System.out.println("Enter value of X:");
		int x = getString();
		System.out.println("Enter Value of Y");
		int y = getString();
		
		long Answer = doPower(x,y);
		System.out.println("Answer is:"+Answer);

	}

	private static long doPower(int x, int y) {
		// TODO Auto-generated method stub
		long answer = x;
		if(y==1)
			return answer;
		sx.push(x);
		sy.push(y);
		
		long ans = doPower(x*x, y/2);
		
		for(int j=0;j<=sx.top;j++){
			int n = sy.pop();
			int mul = sx.pop();
			if(n%2!=0)
				ans = ans * mul;
		}
				
		
		
		return ans;
	}

	private static int getString() throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String s = br.readLine();
		return Integer.parseInt(s);
	}

}
