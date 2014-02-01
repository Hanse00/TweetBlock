import tweepy, traceback

#Identifies the sending party (Us)
consumer_key = "XXX"
consumer_secret = "XXX"

#Info to access the twitter account that'll send on our behalf
tweetblock_access_token = "XXX"
tweetblock_access_token_secret = "XXX"

user_access_token = ""

message = ""

user_found = False

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)

#Make sure users file exists
tempFile = open("users", "a")
tempFile.close()

user = raw_input("Who would you like to tweet? ")

with open("users", "r") as f:
    for line in f:
        #If the given username is in the system, load their details
        if user in line:
            user_access_token = line[line.find("oauth_token=") + 12:-1]
            user_access_token_secret = line[line.find("oauth_token_secret=") + 19:line.find("&")]

            auth.set_access_token(user_access_token, user_access_token_secret)
            user_found = True

#Otherwise use a request token to get permissions
if user_found == False:
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

#If user wasn't previosuly in the system, store them for later use
if user_found == False:
    with open("users", "a") as f:
        f.write(username + ":" + str(user_access_token) + "\n")

while message == "":
    print "What would you like me to tweet you master?"
    message = raw_input("Message: ")

#authenticate as sending account
auth.set_access_token(tweetblock_access_token, tweetblock_access_token_secret)
tweetblock_api = tweepy.API(auth)

#Send the requested tweet
status = "@" + username + " " + message
tweetblock_api.update_status(status)
print status
