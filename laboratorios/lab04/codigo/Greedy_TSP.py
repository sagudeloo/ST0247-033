arcs = {
    1: {
        2: 4,
        3: 2,
        4: 8},
    2: {
        1: 5,
        3: 8,
        4: 4},
    3: {
        1: 3,
        2: 7,
        4: 6},
    4: {
        1: 7,
        2: 4,
        3: 3}
}

graph = {1: [2, 3, 4],
         2: [1, 3, 4],
         3: [1, 2, 4],
         4: [1, 2, 3]
         }

vertexes = [1, 2, 3, 4]
visited = []
start_vertex = int(input('Enter start position.'))


def find_nearest_node(vertex):
    neighbors = graph[vertex]
    closest_distance = 100
    cost = None
    next_node = None
    for neighbor in range(len(neighbors)):
        if len(vertexes) == 1 and vertexes[0] == start_vertex:
            next_node = start_vertex
            cost = arcs[visited[-1]][start_vertex]
        if visited.__contains__(neighbors[neighbor]):
            continue
        if arcs[vertex][neighbors[neighbor]] < closest_distance:
            next_node = neighbors[neighbor]
            cost = arcs[vertex][neighbors[neighbor]]
            closest_distance = arcs[vertex][neighbors[neighbor]]
        else:
            continue

    return next_node, cost


def find_shortest_path(start_vertex):
    total_cost = 0
    vertexes.append(start_vertex)
    next_node = None
    while vertexes:
        if len(visited) == 0:
            visited.append(start_vertex)
            vertexes.remove(start_vertex)
            print("visited: ", visited)
            print("vertexes: ", vertexes)
            next_node_info = find_nearest_node(start_vertex)
            next_node = next_node_info[0]
            total_cost += next_node_info[1]
            visited.append(next_node)
            vertexes.remove(next_node)
            print("visited: ", visited)
            print("vertexes: ", vertexes)
        else:
            next_node_info = find_nearest_node(next_node)
            next_node = next_node_info[0]
            total_cost += next_node_info[1]
            vertexes.remove(next_node)
            visited.append(next_node)
            print("visited: ", visited)
            print("vertexes: ", vertexes)

    print("Total cost: ", total_cost)


find_shortest_path(start_vertex)
