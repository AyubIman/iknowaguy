
const observable = require('mobx').observable;
const action = require('mobx').action;
const computed = require('mobx').computed;

class UserStore{
    @observable names = [];

    @action addName = (name) => {
        this.names.push(name)
    }

    @computed get namesCount(){
        return this.names.length;
    }

}

const userStore = new UserStore();

module.exports = userStore;