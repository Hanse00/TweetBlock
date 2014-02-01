import tweepy

consumer_key = "XXX"
consumer_secret = "XXX"

access_token = "XXX"
access_token_secret = "XXX"

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)

api = tweepy.API(auth)

print api.me().name

api.update_status("Python?")
