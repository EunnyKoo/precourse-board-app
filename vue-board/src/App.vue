<script>
import NavBar from "@/components/NavBar.vue";

export default {
  name: 'App',
  components: {NavBar},
  data() {
    return {
      drawer: false,
      title: '프리코스 게시판',
      footImg: require(`@/assets/images/tan.png`),
    }
  },
  methods: {
    close() {
      this.drawer = false;
    }
  }
}
</script>

<template>
  <v-app>
    <v-app-bar>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>{{title}}</v-toolbar-title>
    </v-app-bar>

    <NavBar v-model="drawer" @close="close"/>

    <v-main class="bg-grey-lighten-2">
      <v-container fluid >
       <router-view />
      </v-container>
    </v-main>

     <v-card
          tile
          width="100%"
          height="90px"
          class="d-flex align-center justify-center"
      >
        <v-img
            class="mx-auto"
            height="80"
            max-width="100"
            :src="footImg"
        />
      </v-card>
  </v-app>
</template>