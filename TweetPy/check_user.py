import sys

'''
Takes: minecraft username
Returns: boolean value

This script is used to check if the database contains
an entry for the given username.
'''

user_found = False

f = open("users", "a")
f.close()

if len(sys.argv) > 1:
    user = sys.argv[1]

    with open("users", "r") as f:
        for line in f:
            if user in line:
                user_found = True

    print user_found
else:
    print "Usage: check_user.py <user>"
