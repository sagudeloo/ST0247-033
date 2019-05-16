import numpy as np
import time
import json
graph = np.zeros((205, 205), int)


def file_reader():
    file = open("dataset-ejemplo-U=205-p=1.2.txt", "r")
    global u
    global p
    for line in file:
        x = line.split(" ")
        if x[0] == "p":
            p = 10
            print("People willing to take up to ",str(p) + " minutes more")
        elif x[0] == "u":
            u = int(x[1])
            print("U value: ", u)
        else:
            source = int(x[0])
            destination = int(x[1])
            cost = int(x[2])
            graph[source-1][destination-1] = cost


def fill_all_cars(graph_in):
    global people_already_in_cars
    global total_time_fill_cars
    global car_dict
    people_already_in_cars = []
    number_of_people = u - 1
    number_of_cars = 0
    total_time_fill_cars = 0
    car_dict = {}
    while len(people_already_in_cars) < number_of_people:
        start_time = time.time()
        list_of_people_in_car = fill_cars(graph_in)
        total_time_fill_cars += (time.time() - start_time)
        number_of_cars += 1
        car_dict.setdefault(number_of_cars, list_of_people_in_car)
    print("Number of cars: ", number_of_cars, "Cars reduced by: ", u - number_of_cars)
    print(car_dict)


def fill_cars(graph_in):
    global total_time_find_any
    global total_time_find_closest
    global total_time_find_farthest
    current_car = []
    number_of_people_in_car = 0
    time_taken_so_far = 0
    destination = 1
    total_time_for_route = 0
    total_time_find_farthest = 0
    total_time_find_closest = 0
    total_time_find_any = 0
    while destination != 0:
        if len(current_car) == 0:
            start_time_2 = time.time()
            first_person = find_farthest_person(graph_in)
            total_time_find_farthest += (time.time() - start_time_2)
            people_already_in_cars.append(first_person)
            total_time_for_route = graph_in[first_person][0] + p
            current_car.append(first_person)
            number_of_people_in_car += 1
        else:
            next_person_possible = True
            while next_person_possible and time_taken_so_far <= total_time_for_route:
                last_person = current_car[-1]
                if last_person == 0:
                    people_already_in_cars.remove(0)
                    current_car.remove(0)
                    break
                start_time_3 = time.time()
                next_person = find_closest_person(graph_in, last_person)
                total_time_find_closest += (time.time() - start_time_3)
                total_time_for_person = graph_in[last_person][0] + p
                if graph_in[last_person][next_person] + graph_in[next_person][0] <= total_time_for_person \
                        and number_of_people_in_car < 5:
                    people_already_in_cars.append(next_person)
                    current_car.append(next_person)
                    number_of_people_in_car += 1
                    time_taken_so_far += graph_in[last_person][next_person]
                else:
                    if len(current_car) == 1:
                        if not find_any_possible(graph_in, current_car[-1]):
                            break
                        else:
                            start_time_1 = time.time()
                            result = find_any_possible(graph_in, current_car[-1])
                            total_time_find_any += (time.time() - start_time_1)
                            print("Time to find any possible: ", "--- %s seconds ---" % (time.time() - start_time_1))
                            current_car.append(result[0])
                            people_already_in_cars.append(result[0])
                            time_taken_so_far += result[1]
                            total_time_for_route = total_time_for_route - time_taken_so_far
                    next_person_possible = False
                    time_taken_so_far += graph_in[last_person][0]
            destination = 0
    return current_car


def find_farthest_person(graph_in):
    farthest_distance = 0
    farthest_person = 0
    i = 0
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


def find_any_possible(graph_in, source):
    i = 0
    next_person_possible = False
    time_for_person = graph_in[source][0] + p
    while i < u:
        if i == 0:
            pass
        elif graph_in[source][i] == 0:
            pass
        elif people_already_in_cars.__contains__(i):
            pass
        elif int(graph_in[source][i]) + int(graph_in[i][0]) <= time_for_person:
            tuple_of_next_info = (i, int(graph_in[source][i] + graph_in[i][0]))
            return tuple_of_next_info
        else:
            pass
        i += 1
    return next_person_possible


def write_cars_to_file():
    with open('list_of_cars.txt', 'w') as file:
        file.write(json.dumps(car_dict))


file_reader()
fill_all_cars(graph)
write_cars_to_file()
