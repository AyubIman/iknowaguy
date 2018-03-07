const React = require('react');
const Component = require('react').Component;
const observableTodoStore = require('./stores/TodoStore');

class RootComponent extends Component{

    componentDidMount(){}
    render(){
        return <h2>Root component</h2>;
    }
}

var rootComponent = new RootComponent();

export default rootComponent;