<template>
  <div id="app">
    <button>All characters</button>
    <div>
      <ul id="characters">
        <li v-for="hero in characters" :key="hero.id">
          <img :src="hero.image" alt="heroImage"> {{hero.name}}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {},
  data() {
    return {
      /*characters: [
        {
          id: 1,
          name: "Rick Sanchez",
          status: "Alive",
          species: "Human",
          type: "",
          gender: "Male",
          origin: {
            name: "Earth",
            url: "https://rickandmortyapi.com/api/location/1"
          },
          location: {
            name: "Earth",
            url: "https://rickandmortyapi.com/api/location/20"
          },
          image: "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
          episode: [
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2",
          ],
          url: "https://rickandmortyapi.com/api/character/1",
          created: "2017-11-04T18:48:46.250Z"
        },
        {
          id: 2,
          name: "Morty Smith",
          status: "Alive",
          species: "Human",
          type: "",
          gender: "Male",
          origin: {
            name: "Earth",
            url: "https://rickandmortyapi.com/api/location/1"
          },
          location: {
            name: "Earth",
            url: "https://rickandmortyapi.com/api/location/20"
          },
          image: "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
          episode: [
            "https://rickandmortyapi.com/api/episode/1",
            "https://rickandmortyapi.com/api/episode/2",
          ],
          url: "https://rickandmortyapi.com/api/character/2",
          created: "2017-11-04T18:50:21.651Z"
        }]*/
    }
  },
  computed: {
    characters() {
      console.log('in computed')
      return this.$store.getters['getAllCharacters'];
    }
  },
  created() {
    console.log('created')
    this.$store.dispatch('fetchCharacters');
  },
}
</script>

<style>
</style>
