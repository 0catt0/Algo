import javax.swing.*;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.List;

public class Map extends JFrame {
    public Map(List<Node> nodes, List<Edge> edges, List<Mudang> mudangs, List<Edge> shortestPathEdges) {
        setTitle("Campus Map with Highlighted Area");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // MapPanel 객체 생성
        MapPanel mapPanel = new MapPanel(nodes, edges, mudangs, shortestPathEdges);
        add(mapPanel);
    }
    public static void main(String[] args) {
        // 노드 생성
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("정문", 700, 720));  // 0
        nodes.add(new Node("비타", 780, 670));  // 1
        nodes.add(new Node("공대2", 850, 590));  // 2
        nodes.add(new Node("반단대", 620, 670));  // 3
        nodes.add(new Node("글센", 550, 670));  // 4
        nodes.add(new Node("전정도", 660, 590));  // 5
        nodes.add(new Node("예체대", 520, 500));  // 6
        nodes.add(new Node("가천관", 680, 450));  // 7
        nodes.add(new Node("산협", 800, 470));  // 8
        nodes.add(new Node("교대", 550, 280));  // 9
        nodes.add(new Node("중도", 470, 220));  // 10
        nodes.add(new Node("학생회관", 400, 180));  // 11
        nodes.add(new Node("에공", 190, 200));  // 12
        nodes.add(new Node("3긱", 100, 250));  // 13
        nodes.add(new Node("1,2긱", 50, 140));  // 14
        nodes.add(new Node("운동장", 150, 100));  // 15

        // 엣지 생성
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(nodes.get(0), nodes.get(1), 1));
        edges.add(new Edge(nodes.get(0), nodes.get(3), 1));
        edges.add(new Edge(nodes.get(0), nodes.get(5), 3));
        edges.add(new Edge(nodes.get(1), nodes.get(2), 1));
        edges.add(new Edge(nodes.get(1), nodes.get(5), 3));
        edges.add(new Edge(nodes.get(2), nodes.get(8), 1));
        edges.add(new Edge(nodes.get(3), nodes.get(4), 1));
        edges.add(new Edge(nodes.get(3), nodes.get(5), 1));
        edges.add(new Edge(nodes.get(4), nodes.get(5), 2));
        edges.add(new Edge(nodes.get(4), nodes.get(6), 4));
        edges.add(new Edge(nodes.get(4), nodes.get(7), 5));
        edges.add(new Edge(nodes.get(5), nodes.get(6), 2));
        edges.add(new Edge(nodes.get(5), nodes.get(7), 1));
        edges.add(new Edge(nodes.get(6), nodes.get(7), 2));
        edges.add(new Edge(nodes.get(6), nodes.get(9), 5));
        edges.add(new Edge(nodes.get(7), nodes.get(8), 1));
        edges.add(new Edge(nodes.get(7), nodes.get(9), 5));
        edges.add(new Edge(nodes.get(9), nodes.get(10), 3));
        edges.add(new Edge(nodes.get(10), nodes.get(11), 2));
        edges.add(new Edge(nodes.get(11), nodes.get(12), 5));
        edges.add(new Edge(nodes.get(11), nodes.get(15), 3));
        edges.add(new Edge(nodes.get(12), nodes.get(13), 1));
        edges.add(new Edge(nodes.get(12), nodes.get(14), 2));
        edges.add(new Edge(nodes.get(12), nodes.get(15), 1));
        edges.add(new Edge(nodes.get(13), nodes.get(14), 1));
        edges.add(new Edge(nodes.get(14), nodes.get(15), 1));


        // 무당 경로 생성
        List<Mudang> mudang = new ArrayList<>();
        mudang.add(new Mudang(nodes.get(0), nodes.get(3), 2));
        mudang.add(new Mudang(nodes.get(3), nodes.get(9), 1));
        mudang.add(new Mudang(nodes.get(9), nodes.get(10), 1));
        mudang.add(new Mudang(nodes.get(10), nodes.get(11), 1));
        mudang.add(new Mudang(nodes.get(11), nodes.get(15), 1));

        //최단 경로 계산
        List<Edge> shortestPathEdges = Dijkstra.findShortestPath(nodes, edges, nodes.get(0), nodes.get(9));
        // GUI 실행
        SwingUtilities.invokeLater(() -> {
            new Map(nodes, edges, mudang, shortestPathEdges).setVisible(true);
        });
    }
}
