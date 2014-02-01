import tweepy, traceback

consumer_key = "XXX"
consumer_secret = "XXX"

tweetblock_access_token = "XXX"
tweetblock_access_token_secret = "XXX"

user_access_token = ""

message = ""

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)

request = auth.get_authorization_url()

while user_access_token == "":
    print "Go to the following URL to authorize TweetBlock:",
    print request
    pin = raw_input("Enter pin: ")

    try:
        user_access_token = auth.get_access_token(pin)
    except TweepError:
        traceback.print_exc()

user_api = tweepy.API(auth)

username = user_api.me().screen_name
print username

while message == "":
    print "What would you like me to tweet you master?"
    message = raw_input("Message: ")

auth.set_access_token(tweetblock_access_token, tweetblock_access_token_secret)
tweetblock_api = tweepy.API(auth)

status = "@" + username + " " + message
tweetblock_api.update_status(status)
print status
        
