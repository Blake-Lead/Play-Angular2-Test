var webpack    = require('webpack');
var htmlPlugin = require('html-webpack-plugin');
var copyPlugin = require('copy-webpack-plugin');

module.exports = {
  entry: {
    app: './src/main.ts'
  },
  output: {
    path: 'dist',
    filename: '[name].bundle.js'
  },
  resolve: {
    extensions: ['', '.ts', '.js', 'css', 'html']
  },
  module: {
    loaders: [
    { test: /\.ts$/, loaders: ['ts-loader'], exclude: /node_modules/ },
    { test: /\.html$/, loader: 'html' },
    ]
  },
  plugins: [
  new webpack.optimize.UglifyJsPlugin(),
  new htmlPlugin({ template: './src/index.html' }),
  new copyPlugin([
    { from: './src/app/views', to: 'app/views' },
    { from: './src/app/styles', to: 'app/styles' }
    ])
  ]
};