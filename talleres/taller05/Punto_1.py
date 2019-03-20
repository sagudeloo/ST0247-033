nodes = {
    0: [1, 2, 5],
    1: [0, 6, 7],
    2: [0, 3, 8],
    3: [2, 4, 7],
    4: [5, 6],
    5: [0, 4, 9],
    6: [1, 4, 8],
    7: [1, 3, 9],
    8: [2, 6, 9],
    9: [7, 8]
}

colored_graph = {}
visited = []
colors = ["Red", "Blue", "Green", "Purple"]
vertices = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
n = int(input('Enter number of colors.'))
is_it_safe = ''
number_of_colors = {}


def check_color(vertex, color):
    for neighbor in nodes.get(vertex):
        color_of_neighbor = colored_graph.get(neighbor)
        color_of_source = colored_graph.get(vertex)
        if color_of_source == color:
            return False
        if color_of_neighbor == color:
            print ('Color already taken.')
            return False
    return True


def assign_color(vertex):
    for color in colors:
        if check_color(vertex, color):
            return color


def main():
    for vertex in vertices:
        colored_graph[vertex] = assign_color(vertex)
    for source in colored_graph:
        number_of_colors.setdefault(colored_graph.get(source))
        print(source, ':', colored_graph[source])


    print(colored_graph)
    if len(number_of_colors) > n:
        print('You need more colors to color this graph.')
    else:
        print('You can color the graph with selected number of colors.')


main()