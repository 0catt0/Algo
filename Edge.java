class Edge {
    Node from, to;
    int cost;

    Edge(Node from, Node to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

//    // cost 표시를 위한 - 예찬
//    @Override
//    public String toString() {
//        return "" + cost;
//    }
}