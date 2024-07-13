import java.util.ArrayList;
import java.util.List;

public class NodeList {

  private List<Node> nodeList;

  public NodeList() {
    nodeList = new ArrayList<>();
  }

  public void addNode(Node node) {
    nodeList.add(node);
    nodeList.sort((n1, n2) -> Integer.compare(n1.frequency, n2.frequency));
  }

  public Node removeMinNode() {
    return nodeList.remove(0);
    // return nodeList.remove(nodeList.size() - 1);
  }

  public int size() {
    return nodeList.size();
  } 
}
