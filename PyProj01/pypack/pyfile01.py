from pypack.Animal import Animal

__author__ = 'igord'


def nl():
    print("\n")

def main():
    # print("Hello2")
    # animal = Animal(45)
    # animal.double_age()
    # print(animal.age)

    print("Start")

    msg = "ana i mujica"
    msg2 = msg.replace("a", "$")
    print(msg)
    print(msg2)
    ivana = "ivana"
    print(ivana * 2)

    # print(sys.api_version)

    fruit = ["banana", "apple", "legit"]
    for i in range(len(fruit)):
        # pass
        # sys.stdout.write("test")
        # print("test", end="")
        print(fruit[i], end="")
    nl()

    print([fruit[0], fruit[1]])
    print([fruit[0], fruit[1]], sep="$")

    animal1 = Animal(30)
    print(animal1)

    nl()
    print("End")

main()
