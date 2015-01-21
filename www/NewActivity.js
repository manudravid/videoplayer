 */

var exec = require("cordova/exec");

var NewActivty = {
    play: function(url,width,height) {
        exec(null, null, "NewActivity", "playVideo", [url,width,height]);
    }
};

module.exports = NewActivty;
