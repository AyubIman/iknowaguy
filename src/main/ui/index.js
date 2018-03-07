require('../resources/static/css/styles.css');

const React = require('react');
const ReactDOM = require('react-dom');
const Provider = require('mobx-react').Provider;
const AppStore = require('./stores/AppStore');


const RootComponent = require('./components/RootComponent');

ReactDOM.render(<div>{RootComponent}</div>, document.getElementById('root')
);


