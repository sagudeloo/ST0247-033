class Find_Shortest_Path(object):
    no_path_to_dest = 100

    def __init__(self, graph, arcs):
        self.arc = arcs
        self.graph = graph
        self.min_cost = {}
        self.visited = set()

    def sub_path_sum(self, source, destination):
        if source is None:
            print('Route not possible.')
        self.visited.add(source)
        route_cost = 100

        for child_node in self.graph[source]:
            if child_node not in self.visited and child_node != destination:
                sub_path_cost = self.sub_path_sum(child_node, destination)
                route_cost = min(route_cost, self.arc.get((source, child_node)) + sub_path_cost)
            elif child_node == destination:
                route_cost = min(route_cost, self.arc.get((source, child_node)))
            else:
                if child_node not in self.min_cost:
                    continue
                route_cost = min(
                    route_cost, self.arc.get((source, child_node)) + self.min_cost[child_node])
        self.min_cost[source] = route_cost
        return route_cost


graph = {
    0: {
        1: 3,
        2: 4,
        3: 7
    },
    1: {
        0: 4,
        2: 5,
        3: 4,
        4: 3
    },
    2: {
        1: 4,
        3: 6
    },
    3: {
        0: 8,
        1: 3,
        2: 7,
        4: 2
    },
    4: {
        1: 2
    }
}


arcs = {
    (0,1): 3,
    (0,2): 4,
    (0,3): 7,
    (1,0): 4,
    (1,2): 5,
    (1,3): 4,
    (1,4): 3,
    (2,1): 4,
    (2,3): 6,
    (3,0): 8,
    (3,1): 3,
    (3,2): 7,
    (3,4): 2,

}


fsp = Find_Shortest_Path(graph, arcs)
n = int(input('Enter in where you want to start.'))
m = int(input('Enter in your destination.'))
find_min_cost = fsp.sub_path_sum(n, m)
z = 'Minimum cost to complete route: ' + str(find_min_cost)
print(z)
