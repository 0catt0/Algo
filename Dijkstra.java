import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Dijkstra {
    static class NodeInfo {
        Node node;
        int distance;

        NodeInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static List<Edge> findShortestPath(List<Node> nodes, List<Edge> edges, Node start, Node end) {
        HashMap<Node, Integer> distances = new HashMap<>();
        HashMap<Node, Node> previous = new HashMap<>();
        PriorityQueue<NodeInfo> queue = new PriorityQueue<>(Comparator.comparingInt(info -> info.distance));
        Set<Node> visited = new HashSet<>();

        // 초기화
        for (Node node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
            previous.put(node, null);
        }
        distances.put(start, 0);
        queue.add(new NodeInfo(start, 0));

        // 알고리즘 실행
        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            if (!visited.add(current.node)) continue;

            for (Edge edge : edges) {
                if (edge.from.equals(current.node) && !visited.contains(edge.to)) {
                    int newDist = distances.get(current.node) + edge.cost;
                    if (newDist < distances.get(edge.to)) {
                        distances.put(edge.to, newDist);
                        previous.put(edge.to, current.node);
                        queue.add(new NodeInfo(edge.to, newDist));
                    }
                }
            }
        }

        // 최단 경로 복원
        List<Edge> path = new ArrayList<>();
        for (Node at = end; previous.get(at) != null; at = previous.get(at)) {
            Node prev = previous.get(at);
            for (Edge edge : edges) {
                if (edge.from.equals(prev) && edge.to.equals(at)) {
                    path.add(0, edge);
                    break;
                }
            }
        }
        return path;
    }
}