import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
    // In state we are keeping our data we are sharing with our components
    state: {
        characters: []
    },
    // Getters are like computed properties. Simple functions to get a state
    getters: {
        getAllCharacters(state){
            console.log('in get')
            return state.characters
        }
    },
    // Simple functions to mutate a state
    mutations: {
        setCharacters (state , characters){
            console.log('in set')
            state.characters = characters
        }
    },
    // Actions are like methods in vue componenet. They should not mutate the state.
    // Very good spot to fetch a data. Action call usualy should resolve into data.
    actions: {
        async fetchCharacters (context) {
            console.log('in fetch')
            await axios.get('https://rickandmortyapi.com/api/character')
                .then(res => {
                    const characters = res.data.results;
                    context.commit('setCharacters' , characters);
                })
        }
    },
})