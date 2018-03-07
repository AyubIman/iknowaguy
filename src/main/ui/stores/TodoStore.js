import {observable, computed} from 'mobx';
import * as mobx from 'mobx';
class ObservableTodoStore {
    @observable todos = [];
    @observable pendingRequests = 0;

    constructor() {
        mobx.autorun(() => console.log(this.report));
    }

    @computed get completedTodosCount() {
        return this.todos.filter(
            todo => todo.completed === true
        ).length;
    }

    @computed get report() {
        if (this.todos.length === 0)
            return "<none>";
        return `Next todo: "${this.todos[0].task}". ` +
            `Progress: ${this.completedTodosCount}/${this.todos.length}`;
    }

    addTodo(task) {
        this.todos.push({
            task: task,
            completed: false,
            assignee: null
        });
    }
}


const observableTodoStore = new ObservableTodoStore();

observableTodoStore.addTodo("read MobX tutorial");
observableTodoStore.addTodo("try MobX");
observableTodoStore.todos[0].completed = true;
observableTodoStore.todos[1].task = "try MobX in own project";
observableTodoStore.todos[0].task = "grok MobX tutorial";


// class TodoStore {
//     todos = [];
//
//     get completedTodosCount() {
//         return this.todos.filter(
//             todo => todo.completed === true
//         ).length;
//     }
//
//     report() {
//         if (this.todos.length === 0)
//             return "<none>";
//         return `Next todo: "${this.todos[0].task}". ` +
//             `Progress: ${this.completedTodosCount}/${this.todos.length}`;
//     }
//
//     addTodo(task) {
//         this.todos.push({
//             task: task,
//             completed: false,
//             assignee: null
//         });
//     }
// }
//
// const todoStore = new TodoStore();
//
// todoStore.addTodo("read MobX tutorial");
// console.log(todoStore.report());
//
// todoStore.addTodo("try MobX");
// console.log(todoStore.report());
//
// todoStore.todos[0].completed = true;
// console.log(todoStore.report());
//
// todoStore.todos[1].task = "try MobX in own project";
// console.log(todoStore.report());
//
// todoStore.todos[0].task = "grok MobX tutorial";
// console.log(todoStore.report());
