#setup:
#    brew install carthage
#    npm install -g firebase-tools

start-firebase-emulators:
	firebase emulators:start --config=./test/firebase.json