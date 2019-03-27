total_to_be_returned = int(input('Enter change to be returned.'))
coin_denominations = [50, 100, 200, 500, 1000]


def change_return(total_to_be_returned, coin_denominations):
    coins_selected = None
    for change in coin_denominations:
        if change == total_to_be_returned:
            return change
        if change < total_to_be_returned:
            coins_selected = change
    balance = total_to_be_returned - coins_selected
    return [coins_selected] + [change_return(balance, coin_denominations)]





def get_list(x):
    for i in x:
        try:
            yield from get_list(i)
        except TypeError:
            yield i


result = change_return(total_to_be_returned, coin_denominations)
result_in_list = list(get_list(result))
number_of_coins = len(result_in_list)
print('Coins to give to customer: ', result_in_list, 'Minimum number of coins needed: ', number_of_coins)
