import tweepy

get_consumer_key = "XXX"
get_consumer_secret = "XXX"

get_auth = tweepy.OAuthHandler(get_consumer_key, get_consumer_secret)
request = str(get_auth._get_request_token())
request_token = request[request.find("oauth_token=") + 12:request.find("&", request.find("oauth_token="))]
request_token_secret = request[request.find("oauth_token_secret=") + 19:request.find("&", request.find("oauth_token_secret="))]

print get_auth.get_authorization_url()
print request_token
print request_token_secret
