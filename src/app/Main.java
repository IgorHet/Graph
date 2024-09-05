package app;

public class Main {
    public static void main(String[] args) {
        // Створення графу
        Graph graph = new Graph();

        // Додавання вершин
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Додавання ребер
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        // Виведення графу
        System.out.println("Graph after adding vertices and edges:");
        graph.printGraph();

        // Перевірка наявності вершини
        System.out.println("Graph has vertex 3: " + graph.hasVertex(3));
        System.out.println("Graph has vertex 5: " + graph.hasVertex(5));

        // Перевірка наявності ребра
        System.out.println("Graph has edge between 1 and 2: " + graph.hasEdge(1, 2));
        System.out.println("Graph has edge between 2 and 4: " + graph.hasEdge(2, 4));

        // Видалення вершини
        graph.removeVertex(4);
        System.out.println("Graph after removing vertex 4:");
        graph.printGraph();

        // Видалення ребра
        graph.removeEdge(1, 2);
        System.out.println("Graph after removing edge between 1 and 2:");
        graph.printGraph();
    }
}

