__author__ = 'igord'


class Animal(object):

    def __init__(self, age):
        print("Init self")
        self.age = age

    def __str__(self):
        return "Animal! Age: " + str(self.age)

    def double_age(self):
        self.age *= 2