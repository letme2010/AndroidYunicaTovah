sudo killall node-webkit
zip T1.nw index.html package.json jquery.js main.js mainUI.js
adb forward tcp:9527 tcp:9527
open -a node-webkit T1.nw