graph = {
    1: {
        2: 15,
        3: 8
    },
    2: {
        3: 3,
        4: 2
    },
    3: {
        2: 5,
        4: 7,
        5: 9
    },
    4: {
        5: 9
    },
    5: {
        4: 12
    }
}

vertexes = [1, 2, 3, 4, 5]
start_vertex_input = int(input("Entire desired start vertex, 1-5"))


def find_minimum_cost_for_path(graph_in, initial_vertex, end_vertex):
    print("initial vertex ", initial_vertex, "end vertex ", end_vertex)
    minimum_cost_for_path = {}
    previous_vertex = {}
    unvisited_vertexes = graph_in.copy()
    high_number = 20000
    path = []
    # set distance to every vertex high to compare and find shortest
    for vertex in unvisited_vertexes:
        minimum_cost_for_path[vertex] = high_number
    minimum_cost_for_path[initial_vertex] = 0

    while unvisited_vertexes:
        nearest_vertex = None
        for vertex in unvisited_vertexes:
            if nearest_vertex is None:
                nearest_vertex = vertex
            elif minimum_cost_for_path[vertex] < minimum_cost_for_path[nearest_vertex]:
                nearest_vertex = vertex

        for neighbor, distance in graph_in[nearest_vertex].items():
            if distance + minimum_cost_for_path[nearest_vertex] < minimum_cost_for_path[neighbor]:
                minimum_cost_for_path[neighbor] = distance + minimum_cost_for_path[nearest_vertex]
                previous_vertex[neighbor] = nearest_vertex
        unvisited_vertexes.pop(nearest_vertex)

    current_vertex = end_vertex
    while current_vertex != initial_vertex:
        try:
            path.insert(0, current_vertex)
            current_vertex = previous_vertex[current_vertex]
        except KeyError:
            print("Path not possible.")
            break

    path.insert(0, initial_vertex)
    print("Minimum distance possible: ", minimum_cost_for_path[end_vertex])
    print("The path is: ", path)
    print(minimum_cost_for_path[end_vertex], path)
    return minimum_cost_for_path[end_vertex], path


def dijkstra_for_entire_graph(start_vertex):
        graph_with_paths = {}
        vertexes.remove(start_vertex)
        for vertex in range(len(vertexes)):
            path_info = find_minimum_cost_for_path(graph, start_vertex, vertexes[vertex])
            graph_with_paths[(start_vertex, vertexes[vertex])] = path_info
        print(graph_with_paths)


dijkstra_for_entire_graph(start_vertex_input)
