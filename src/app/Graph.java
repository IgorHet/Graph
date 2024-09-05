package app;

import java.util.*;

public class Graph {
    private Map<Integer, Set<Integer>> adjacencyList;

    // Конструктор для ініціалізації графа
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Метод для додавання вершини до графу
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Метод для додавання ребра між двома вершинами
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Для неорієнтованого графа
    }

    // Метод для видалення вершини з графу
    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) return;

        // Видалення ребер, що під'єднані до вершини
        for (Integer adjacent : adjacencyList.get(vertex)) {
            adjacencyList.get(adjacent).remove(vertex);
        }
        adjacencyList.remove(vertex);
    }

    // Метод для видалення ребра між двома вершинами
    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            adjacencyList.get(source).remove(destination);
            adjacencyList.get(destination).remove(source); // Для неорієнтованого графа
        }
    }

    // Метод для перевірки, чи існує вершина у графі
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Метод для перевірки, чи існує ребро між двома вершинами
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    // Метод для виведення графу
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " is connected to: " + entry.getValue());
        }
    }
}