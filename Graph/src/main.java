import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import java.awt.Dimension;
import javax.swing.JFrame;

public class main {
	
	public static <V, E> void BFS(Graph<V, E> g, V start){
		
		ArrayList visited = new ArrayList();
		Queue<V> toVisit = new Queue<V>();
		
		V[] temp = (V[]) g.getNeighbors(start).toArray();
		for(Object s: temp){
			toVisit.enqueue((V) s);
		}
		
		System.out.println(start);
		visited.add(start);
		
		V tempV;
		
		
		while(toVisit.size() != 0){
			tempV = (V) toVisit.dequeue();
			if(!visited.contains(tempV)){
				System.out.println(tempV);
			}
			visited.add(tempV);
			
			temp = (V[]) g.getNeighbors(tempV).toArray();
			for(V s: temp){
				if(!visited.contains(s)){
					toVisit.enqueue((V) s);
				}
			}
		}
		
	}
	
	public static void DFS(Graph g, String start){
		Set visited = new HashSet<String>();
		DFS(g, start, visited);
	}
	
	public static void DFS(Graph g, String start, Set visited){
		System.out.println(start);
		visited.add(start);
		Object[] temp = g.getNeighbors(start).toArray();
		
		for(Object s: temp){
			if(!visited.contains(s)){
				DFS(g, s.toString(), visited);
			}
		}
	}
	
	public static void main(String args[]){
		Graph<String, Integer> g = new SparseGraph<String, Integer>();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("M");
		g.addVertex("N");
		g.addVertex("O");
		
		g.addEdge(1, "D", "A");
		g.addEdge(2, "D", "B");
		g.addEdge(3, "A", "O");
		g.addEdge(4, "O", "M");
		g.addEdge(5, "B", "O");
		g.addEdge(6, "B", "N");
		g.addEdge(7, "E", "D");
		
		// The Layout<V, E> is parameterized by the vertex and edge types
		Layout<Integer, String> layout = new CircleLayout(g);
		layout.setSize(new Dimension(300,300)); // sets the initial size of the space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<Integer,String> vv =
		new BasicVisualizationServer<Integer,String>(layout);
		vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());

		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true); 
		 
		 
		
		System.out.println("The graph g = " + g.toString());
		
		DFS(g, "D");
	}
}
