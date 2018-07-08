import java.util.*;
import java.io.*;
class Stack{
	int top, ar[], capacity;
	Stack(int capacity){
		this.capacity = capacity;
		ar = new int[capacity];
		top = -1;
	}
	void push(int element){
		if(top>=capacity)
			System.out.println("Stack overflow..");
		else
			ar[++top] = element;
	}
	void pop(){
		if(top<0)
			System.out.println("Stack underflow..");
		else
			top--;
	}
	int peek(){
		return ar[top];
	}
	boolean empty(){
		return (top < 0);
	}
}
class ApplicationDFS{
	int vertices = 6;
	boolean graph[][] = {{false, true, false, true, true, true}, 
						 {true, false, false, true, true, false}, 
						 {false, false, false, true, true, true}, 
						 {true, true, true, false, true, true}, 
						 {true, true, true, true, false, true},
						 {true, false, true, true, true, false}};
	boolean visited[] = new boolean[vertices];
	Stack stack = new Stack(vertices);
	void dfs(int source, int destination){
		if(source<vertices && destination<vertices){
			stack.push(source);
			visited[source] = true;
			System.out.print((1+source) + " ");
			while(!stack.empty()){
				if(stack.peek()==destination){
					System.out.println("\nReached destination.. (" + (destination+1) + ")");
					break;
				}
				else{
				    boolean canpop = true;
					for(int i=0; i<vertices; i++){
						if(graph[stack.peek()][i] && !visited[i]){
							stack.push(i);
							visited[i] = true;
							System.out.print((i+1) + " ");
							break;
						}
					}
					if(stack.peek()!=destination){
					    for(int i=0; i<vertices; i++){
							if(graph[stack.peek()][i] && !visited[i]){
					            canpop = false;
								break;
							}
					    }
					    if(canpop)
					        stack.pop();
					}
				}
			}
		}
		else{
			System.out.println("Invalid entry..");
		}
	}
	public static void main(String args[]){
		ApplicationDFS dfs = new ApplicationDFS();
		Scanner sc = new Scanner(System.in);
		int source, destination;
		System.out.println("enter source and destination between 1 and " + dfs.vertices + ": ");
		source = sc.nextInt();
		destination = sc.nextInt();
		dfs.dfs(source-1, destination-1);
	}
}