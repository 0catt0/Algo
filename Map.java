import javax.swing.*;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    int x, y;

    Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

class Edge {
    Node from, to;
    int cost;

    Edge(Node from, Node to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class MapPanel extends JPanel {
    private final List<Node> nodes;
    private final List<Edge> edges;
    private final Image treeImage; // 나무 이미지

    public MapPanel(List<Node> nodes, List<Edge> edges, String treeImagePath) {
        this.nodes = nodes;
        this.edges = edges;
        this.treeImage = new ImageIcon(treeImagePath).getImage(); // 나무 이미지 로드
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // 배경색 그라데이션 추가
        GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, getWidth(), getHeight(), Color.WHITE);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 학교 영역을 파란색으로 칠하기
        g2.setColor(new Color(173, 216, 230, 150)); // 반투명한 파란색
        int[] xPoints = {30, 40, 400, 470, 480, 700, 880, 870, 410, 150}; // X 좌표
        int[] yPoints = {80, 300, 250, 500, 690, 750, 590, 450, 150, 80}; // Y 좌표
        g2.fillPolygon(xPoints, yPoints, xPoints.length);

        // 앤티앨리어싱 설정
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 나무 배경 장식 추가
        for (int i = 50; i < getWidth(); i += 100) {
            for (int j = 50; j < getHeight(); j += 100) {
                g2.drawImage(treeImage, i, j, 40, 40, this);
            }
        }

        // 엣지 그리기 (곡선)
        g2.setColor(new Color(70, 130, 180)); // 파란색 계열
        g2.setStroke(new BasicStroke(2)); // 선 두께
        for (Edge edge : edges) {
            double ctrlX1 = (edge.from.x + edge.to.x) / 2.0 + 30; // 첫 번째 제어점
            double ctrlY1 = (edge.from.y + edge.to.y) / 2.0 - 30;
            double ctrlX2 = (edge.from.x + edge.to.x) / 2.0 - 30; // 두 번째 제어점
            double ctrlY2 = (edge.from.y + edge.to.y) / 2.0 + 30;

            CubicCurve2D.Double curve = new CubicCurve2D.Double();
            curve.setCurve(
                edge.from.x, edge.from.y, // 시작점
                ctrlX1, ctrlY1,           // 첫 번째 제어점
                ctrlX2, ctrlY2,           // 두 번째 제어점
                edge.to.x, edge.to.y      // 끝점
            );
            g2.draw(curve);
        }

        // 노드 그리기
        for (Node node : nodes) {
            // 노드 원
            g2.setColor(new Color(220, 20, 60)); // 붉은색 계열
            g2.fillOval(node.x - 15, node.y - 15, 30, 30);

            // 노드 테두리
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(node.x - 15, node.y - 15, 30, 30);

            // 노드 이름 표시
            g2.setColor(Color.BLACK);
            g2.drawString(node.name, node.x - 20, node.y - 20);
        }
    }
}

public class Map extends JFrame {
    public Map(List<Node> nodes, List<Edge> edges) {
        setTitle("Campus Map with Highlighted Area");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CustomPanel을 JFrame에 추가
        MapPanel mapPanel = new MapPanel(nodes, edges, "tree.png");
        add(mapPanel);
    }

    public static void main(String[] args) {
        // 노드 생성
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("정문", 700, 720));
        nodes.add(new Node("비타", 780, 670));
        nodes.add(new Node("공대2", 850, 590));
        nodes.add(new Node("반단대", 620, 670));
        nodes.add(new Node("글센", 550, 670));
        nodes.add(new Node("전정도", 660, 590));
        nodes.add(new Node("예체대", 520, 500));
        nodes.add(new Node("가천관", 680, 450));
        nodes.add(new Node("산협", 800, 470));
        nodes.add(new Node("교대", 550, 280));
        nodes.add(new Node("중도", 470, 220));
        nodes.add(new Node("학생회관", 400, 180));
        nodes.add(new Node("에공", 190, 200));
        nodes.add(new Node("3긱", 100, 250));
        nodes.add(new Node("1,2긱", 50, 140));
        nodes.add(new Node("운동장", 150, 100));

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

        // GUI 실행
        SwingUtilities.invokeLater(() -> {
            new Map(nodes, edges).setVisible(true);
        });
    }
} 