setup:
    brew install carthage
    npm install -g firebase-tools

test:
	firebase emulators:start --config=./test/firebase.json