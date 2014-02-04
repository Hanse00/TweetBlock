import sys, tweepy

'''
Takes: minecraft username, message
Returns: Nothing

This script is used to tweet the given user, with the given
message.
'''

get_consumer_key = "XXX"
get_consumer_secret = "XXX"

post_consumer_key = "XXX"
post_consumer_secret = "XXX"

tweetblock_access_token = "XXX"
tweetblock_access_token_secret = "XXX"

f = open("users", "a")
f.close()

if len(sys.argv) > 2:
    user = sys.argv[1]
    message = sys.argv[2]

    get_auth = tweepy.OAuthHandler(get_consumer_key, get_consumer_secret)

    with open("users", "r") as f:
        for line in f:
            if user in line:
                user_access_token = line[line.find("oauth_token=") + 12:-1]
                user_access_token_secret = line[line.find("oauth_token_secret=") + 19:line.find("&")]

                get_auth.set_access_token(user_access_token, user_access_token_secret)

    user_api = tweepy.API(get_auth)
    username = user_api.me().screen_name

    post_auth = tweepy.OAuthHandler(post_consumer_key, post_consumer_secret)
    post_auth.set_access_token(tweetblock_access_token, tweetblock_access_token_secret)
    tweetblock_api = tweepy.API(post_auth)

    status = "@" + username + " " + message
    tweetblock_api.update_status(status)
else:
    print "Usage: tweet.py <user> <message>"
