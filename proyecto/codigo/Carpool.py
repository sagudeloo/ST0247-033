import numpy as np
graph = np.zeros((11, 11), int)


def file_reader():
    file = open("dataset-ejemplo-U=11-p=1.2.txt", "r")
    global u
    global p
    for line in file:
        x = line.split(" ")
        if x[0] == "p":
            p = x[1]
            print(p)
        elif x[0] == "u":
            u = int(x[1])
            print(u)
        else:
            source = int(x[0])
            destination = int(x[1])
            cost = int(x[2])
            graph[source-1][destination-1] = cost


def fill_cars(graph_in, p):
    global car_dict
    car_dict = {}
    farthest = 0
    i = 0
    print(graph_in)
    while i < u - 1:
        first = graph_in[0][i]
        second = graph_in[0][i+1]
        if first < second:
            farthest = i + 1
        else:
            farthest = i
        i += 1
    original_time = graph_in[0][farthest]
    percentage = p
    total_time = original_time * percentage
    print(total_time)


file_reader()
fill_cars(graph, p)
