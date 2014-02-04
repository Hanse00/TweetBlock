import sys, tweepy

get_consumer_key = "XXX"
get_consumer_secret = "XXX"

user_access_token = ""

f = open("users", "a")
f.close()

if len(sys.argv) > 3:
    user = sys.argv[1]
    request_token = sys.argv[2]
    request_token_secret = sys.argv[3]
    pin = sys.argv[4]

    get_auth = tweepy.OAuthHandler(get_consumer_key, get_consumer_secret)
    get_auth.set_request_token(request_token, request_token_secret)

    user_access_token = get_auth.get_access_token(pin)

    with open("users", "a") as f:
        f.write(user + ":" + str(user_access_token) + "\n")
else:
    print "Usage: register.py <user> <request token> <request token secret> <pin>"
