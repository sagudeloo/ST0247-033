import numpy as np
graph = np.zeros((205, 205), int)


def file_reader():
    file = open("dataset-ejemplo-U=205-p=1.2.txt", "r")
    global u
    global p
    for line in file:
        x = line.split(" ")
        if x[0] == "p":
            p = float(x[1])
            print(p)
        elif x[0] == "u":
            u = int(x[1])
            print(u)
        else:
            source = int(x[0])
            destination = int(x[1])
            cost = int(x[2])
            graph[source-1][destination-1] = cost


def fill_all_cars(graph_in):
    print(graph_in)
    global people_already_in_cars
    people_already_in_cars = []
    number_of_people = u - 1
    number_of_cars = 0
    number_of_full_cars = 0
    while len(people_already_in_cars) < number_of_people:
        list = fill_cars(graph_in)
        number_of_cars += 1
        if len(list) == 5:
            number_of_full_cars += 1
    print("Number of cars: ", number_of_cars)
    print("Number of full cars: ", number_of_full_cars)


def fill_cars(graph_in):
    current_car = []
    number_of_people_in_car = 0
    time_taken_so_far = 0
    destination = 1
    global go_to_next
    while destination != 0:
        if len(current_car) == 0:
            first_person = find_farthest_person(graph_in)
            people_already_in_cars.append(first_person)
            total_time_for_person = graph_in[first_person][0] * p
            current_car.append(first_person)
            number_of_people_in_car += 1
            print("Total for route", total_time_for_person)
        else:
            next_person_possible = True
            while next_person_possible:
                last_person = current_car[-1]
                if last_person == 0:
                    people_already_in_cars.remove(0)
                    current_car.remove(0)
                    break
                next_person = find_closest_person(graph_in, last_person)
                total_time_for_person = graph_in[last_person][0] * p
                print("Person: ", last_person, "Total time for route: ", total_time_for_person)
                if graph_in[last_person][next_person] + graph_in[next_person][0] <= total_time_for_person and number_of_people_in_car < 5:
                    people_already_in_cars.append(next_person)
                    current_car.append(next_person)
                    number_of_people_in_car += 1
                    time_taken_so_far += graph_in[last_person][next_person]
                else:
                    next_person_possible = False
                    time_taken_so_far += graph_in[last_person][0]
                    print("time taken", time_taken_so_far)
            destination = 0
    print(current_car)
    return current_car


def find_farthest_person(graph_in):
    farthest_distance = 0
    farthest_person = 0
    i = 0
    visited = []
    farthest_list = []
    while i < u:
        if i == 0:
            farthest_distance = 0
        elif people_already_in_cars.__contains__(i):
            pass
        elif int(graph_in[i][0]) > farthest_distance:
            farthest_distance = graph_in[i][0]
            farthest_person = i
        else:
            pass
        i += 1
    return farthest_person


def find_closest_person(graph_in, source):
    closest_distance = 100
    closest_person = 0
    i = 0
    visited = []
    farthest_list = []
    while i < u:
        if i == 0:
            closest_distance = 100
        elif graph_in[source][i] == 0:
            pass
        elif people_already_in_cars.__contains__(i):
            pass
        elif int(graph_in[source][i]) < closest_distance:
            closest_distance = graph_in[source][i]
            closest_person = i
        else:
            pass
        i += 1
    return closest_person


file_reader()
fill_all_cars(graph)
