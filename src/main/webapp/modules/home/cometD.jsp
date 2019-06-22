<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Cometd Libraries  -->
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="js/comet/cometd-namespace.js"></script>
<script type="text/javascript" src="js/comet/cometd-json.js"></script>
<script type="text/javascript" src="js/comet/AckExtension.js"></script>
<script type="text/javascript" src="js/comet/TransportRegistry.js"></script>
<script type="text/javascript" src="js/comet/Transport.js"></script>
<script type="text/javascript" src="js/comet/RequestTransport.js"></script>
<script type="text/javascript" src="js/comet/WebSocketTransport.js"></script>
<script type="text/javascript" src="js/comet/CallbackPollingTransport.js"></script>
<script type="text/javascript" src="js/comet/LongPollingTransport.js"></script>
<script type="text/javascript" src="js/comet/Utils.js"></script>
<script type="text/javascript" src="js/comet/Cometd.js"></script>
<script type="text/javascript" src="js/comet/jquery.cometd.js"></script>
<!-- Cometd Libraries  -->

<script type="text/javascript">
function startSubscription() {
	cometd.subscribe('/application/samples', function(msg) {
		if (msg) {
			console.log("JSON: " + JSON.stringify(msg));
		} else {
			console.log("JSON: " + JSON.stringify(msg));
		}
	});
}
var cometd = $.cometd;
cometd.registerTransport('websocket', new org.cometd.WebSocketTransport());
cometd.registerTransport('long-polling', new org.cometd.LongPollingTransport());
cometd.registerTransport('callback-polling', new org.cometd.CallbackPollingTransport());
var r = document.location.href.match(/^(.*)\/secureapi/);
cometd.init(r[0] + '/cometd');
var tweetCount = 0;
cometd.addListener('/meta/handshake', function(handshake) {
	if (handshake.successful === true ) {
		cometd.batch(function () {
			startSubscription();
		});
	}
});
cometd.handshake();
</script>
</head>
</html>