crowd = [8,7,4,10,3,17,11,-4]
container = 0.0
changeindicator = 1

print("hallo")
while changeindicator == 1 :

    changeindicator = 0

    for x in range(len(crowd)-1):

      if (crowd[x] - (crowd[x+1])) > 0:
        container = crowd[x+1]
        crowd[x+1] = crowd[x]
        crowd[x] = container

        print(crowd[x])
        print(crowd[x+1])
        changeindicator = 1

    print("cabron")


print("And now, the list!")
for x in range(len(crowd)-1):
    print(crowd[x])

