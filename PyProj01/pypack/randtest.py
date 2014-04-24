from random import randint

__author__ = 'igord'


def rand_test_main():
    for i in range(5):
        print(randint(1, 6), end=" ")   # inclusive, inclusive
        # print(str(i))
    print()

if __name__ == "__main__":
    rand_test_main()