package info.algorithms.nearestNeighborAlgorithm;

import java.util.*;

public class NearestNeighbor {

    // Класс для представления города
    static class City {
        String name;
        int x, y;

        City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        // Метод для вычисления расстояния до другого города
        double distanceTo(City other) {
            int dx = this.x - other.x;
            int dy = this.y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        // Создаём города
        City A = new City("A", 0, 0);
        City B = new City("B", 1, 2);
        City C = new City("C", 3, 1);
        City D = new City("D", 2, 0);

        List<City> cities = Arrays.asList(A, B, C, D);
        City start = A;

        List<City> path = findPathUsingNearestNeighbor(cities, start);
        double totalDistance = calculateTotalDistance(path);

        System.out.println("Путь: " + path);
        System.out.printf("Общее расстояние: %.2f%n", totalDistance);
    }

    // Алгоритм ближайшего соседа
    public static List<City> findPathUsingNearestNeighbor(List<City> cities, City start) {
        List<City> path = new ArrayList<>();
        Set<City> visited = new HashSet<>();
        City current = start;

        // Пока не посетим все города
        while (true) {
            path.add(current);
            visited.add(current);

            // Находим ближайший непосещённый город
            City nearest = null;
            double minDistance = Double.MAX_VALUE;

            for (City city : cities) {
                if (!visited.contains(city)) {
                    double dist = current.distanceTo(city);
                    if (dist < minDistance) {
                        minDistance = dist;
                        nearest = city;
                    }
                }
            }

            // Если нет непосещённых — выходим
            if (nearest == null) break;

            current = nearest;
        }

        // Возвращаемся в начальный город
        path.add(start);

        return path;
    }

    // Вычисляем общее расстояние по пути
    public static double calculateTotalDistance(List<City> path) {
        double total = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            total += path.get(i).distanceTo(path.get(i + 1));
        }
        return total;
    }
}
