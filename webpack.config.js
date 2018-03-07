const path = require('path');


module.exports = {

    context : __dirname,
    mode : 'development',
    entry : "./src/main/ui/index.js",
    output : {
        path : path.resolve(__dirname, "./src/main/resources/static/js/bundle/"),
        filename : "scripts.js"
    },
    devtool: 'inline-source-map',
    module : {
        rules : [
            {
                test : /\.css$/,
                use: [ 'style-loader', 'css-loader' ]
            }
            ,{
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/
            },{
                test: /\.jsx$/,
                loader: 'babel-loader',
                exclude: /node_modules/
            }
        ]
    }

};