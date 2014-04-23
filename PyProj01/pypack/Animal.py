__author__ = 'igord'


class Animal(object):

    def __init__(self, age):
        print("Init self")
        self.age = age

    def double_age(self):
        self.age *= 2